package com.example.lihaojuan.survey;

import android.content.Context;
import android.os.Environment;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lihaojuan on 17/3/11.
 */

public class txtFileOperation {
    private Context context;

    /** SD卡的路径**/
    private String SDPATH;



    public txtFileOperation(Context context) {
        this.context = context;
        SDPATH = Environment.getExternalStorageDirectory().getPath();
    }

    /**
     * 在SD卡上创建文件
     *
     * @throws IOException
     */
    public File createSDFile(String fileName) throws IOException {
        File file = new File(SDPATH + "//" + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /**
     * 写入内容到SD卡中的txt文本中
     * str为内容
     */
    public void writeSDFile(String str,String fileName)
    {
        try {
            //继续写入
            str=readSDFile(fileName)+str;
            FileWriter fw = new FileWriter(SDPATH + "//" + fileName);
            File f = new File(SDPATH + "//" + fileName);
            fw.write(str);

            FileOutputStream os = new FileOutputStream(f);
            DataOutputStream out = new DataOutputStream(os);
            out.writeShort(2);
            out.writeUTF("");
            System.out.println(out);
            fw.flush();
            fw.close();
            System.out.println(fw);
        } catch (Exception e) {
        }
    }

    /**
     * 读取SD卡中文本文件
     *
     * @param fileName
     * @return
     */
    public String readSDFile(String fileName) {
        StringBuffer sb = new StringBuffer();
        File file = new File(SDPATH + "//" + fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            int c;
            while ((c = fis.read()) != -1) {
                sb.append((char) c);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }



    public String getSDPATH() {
        return SDPATH;
    }


}






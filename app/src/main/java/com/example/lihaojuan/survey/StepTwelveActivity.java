package com.example.lihaojuan.survey;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph on 2017/3/11.
 */

public class StepTwelveActivity extends AppCompatActivity {
    Button btn12;
    CheckBox cb121=null;
    CheckBox cb122=null;
    CheckBox cb123=null;
    CheckBox cb124=null;
    CheckBox cb125=null;
    CheckBox cb126=null;
    CheckBox cb127=null;
    CheckBox cb128=null;
    CheckBox cb129=null;
    CheckBox cb1210=null;
    CheckBox cb1211=null;
    CheckBox cb1212=null;
    CheckBox cb1213=null;
    CheckBox cb1214=null;
    List<CheckBox> checkBoxs = new ArrayList<CheckBox>();
    String content = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twelve);

        TextView tvStep12 = (TextView) findViewById(R.id.tvStep12);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep12.setTypeface(typeface);

        btn12= (Button) findViewById(R.id.btn12);

        cb121=(CheckBox)findViewById(R.id.cb121);
        cb122=(CheckBox)findViewById(R.id.cb122);
        cb123=(CheckBox)findViewById(R.id.cb123);
        cb124=(CheckBox)findViewById(R.id.cb124);
        cb125=(CheckBox)findViewById(R.id.cb125);
        cb126=(CheckBox)findViewById(R.id.cb126);
        cb127=(CheckBox)findViewById(R.id.cb127);
        cb128=(CheckBox)findViewById(R.id.cb128);
        cb129=(CheckBox)findViewById(R.id.cb129);
        cb1210=(CheckBox)findViewById(R.id.cb1210);
        cb1211=(CheckBox)findViewById(R.id.cb1211);
        cb1212=(CheckBox)findViewById(R.id.cb1212);
        cb1213=(CheckBox)findViewById(R.id.cb1213);
        cb1214=(CheckBox)findViewById(R.id.cb1214);



        checkBoxs.add(cb121);
        checkBoxs.add(cb122);
        checkBoxs.add(cb123);
        checkBoxs.add(cb124);
        checkBoxs.add(cb125);
        checkBoxs.add(cb126);
        checkBoxs.add(cb127);
        checkBoxs.add(cb128);
        checkBoxs.add(cb129);
        checkBoxs.add(cb1210);
        checkBoxs.add(cb1211);
        checkBoxs.add(cb1212);
        checkBoxs.add(cb1213);
        checkBoxs.add(cb1214);




        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (CheckBox cbx : checkBoxs) {
                    if (cbx.isChecked()) {
                        content += cbx.getText() + "|";
                    }
                }

                if ("".equals(content)) {
                    Toast.makeText(getApplicationContext(),"Select all those that apply.",Toast.LENGTH_LONG).show();
                }else{
                    txtFileOperation helper=new txtFileOperation(getApplicationContext());

                    helper.writeSDFile(((TextView)findViewById(R.id.tvStep12)).getText().toString()+ content +"\n", "test.txt");
                    //  Toast.makeText(getApplicationContext(),helper.readSDFile("test.txt"),Toast.LENGTH_LONG).show();

                    Intent i12=new Intent(StepTwelveActivity.this,StepEmailActivity.class);
                    startActivity(i12);
                }

            }
        });


    }






}

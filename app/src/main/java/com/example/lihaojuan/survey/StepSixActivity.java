package com.example.lihaojuan.survey;

/**
 * Created by lihaojuan on 17/3/11.
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by lihaojuan on 17/3/11.
 */

public class StepSixActivity extends AppCompatActivity {
    Button btn6;

    private ArrayList myStringArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.six);

        TextView tvStep6 = (TextView) findViewById(R.id.tvStep6);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep6.setTypeface(typeface);

        myStringArray.add("Beijing");
        myStringArray.add("Shanghai");
        myStringArray.add("Tianjin");
        myStringArray.add("Chongqin");
        myStringArray.add("Xi'an");
        myStringArray.add("Wihan");
        myStringArray.add("Nanjin");
        myStringArray.add("Baotou");
        myStringArray.add("Chengdu");
        myStringArray.add("kunming");
        myStringArray.add("Dalian");
        myStringArray.add("XishuangBan'na");
        myStringArray.add("Changsha");
        myStringArray.add("Yinchuan");



        btn6 = (Button)findViewById(R.id.btn6);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myStringArray);
        final ListView listView=(ListView)findViewById(R.id.lv6) ;
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final String dataSeleted= (String) myStringArray.get(position);
                btn6.setText("You are living in the:"+dataSeleted+",next");

                btn6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper=new txtFileOperation(getApplicationContext());
                        helper.writeSDFile(((TextView)findViewById(R.id.tvStep6)).getText().toString()+ dataSeleted +"\n", "test.txt");

                        Toast.makeText(getBaseContext(),"You are living in the:"+dataSeleted,Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(StepSixActivity.this,StepSevenActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });



    }


}

package com.example.lihaojuan.survey;

/**
 * Created by lihaojuan on 17/3/11.
 */

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * Created by lihaojuan on 17/3/11.
 */

public class StepOneActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);

        TextView tvStep1 = (TextView) findViewById(R.id.tvStep1);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep1.setTypeface(typeface);


        btn1 = (Button) findViewById(R.id.btn1);
        RadioGroup group1=(RadioGroup)findViewById(R.id.rgStep1);

        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb1Id = group.getCheckedRadioButtonId();
                final RadioButton rb = (RadioButton) findViewById(rb1Id);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper = new txtFileOperation(getApplicationContext());
                        helper.writeSDFile(((TextView) findViewById(R.id.tvStep1)).getText().toString() + rb.getText().toString() + "\n", "test.txt");
                        //.makeText(getApplicationContext(),helper.readSDFile("test.txt"),Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getBaseContext(), StepTwoActivity.class);
                        startActivity(intent);

                    }
                });

            }
        });

    }
}











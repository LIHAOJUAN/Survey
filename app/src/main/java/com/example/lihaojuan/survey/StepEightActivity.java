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

public class StepEightActivity extends AppCompatActivity {
    Button btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eight);

        TextView tvStep8 = (TextView) findViewById(R.id.tvStep8);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep8.setTypeface(typeface);

        btn8=(Button)findViewById(R.id.btn8);
        RadioGroup group8=(RadioGroup)findViewById(R.id.rgStep8);

        group8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb8Id=group.getCheckedRadioButtonId();
                final RadioButton rb=(RadioButton)findViewById(rb8Id);

                btn8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper=new txtFileOperation(getApplicationContext());

                        helper.writeSDFile(((TextView)findViewById(R.id.tvStep8)).getText().toString()+ rb.getText().toString() +"\n", "test.txt");
                        //Toast.makeText(getApplicationContext(),helper.readSDFile("test.txt"),Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(StepEightActivity.this,StepNineActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });



    }


}

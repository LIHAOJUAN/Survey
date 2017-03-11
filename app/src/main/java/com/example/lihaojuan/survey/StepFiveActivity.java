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

public class StepFiveActivity extends AppCompatActivity {
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five);

        TextView tvStep5 = (TextView) findViewById(R.id.tvStep5);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep5.setTypeface(typeface);

        btn5=(Button)findViewById(R.id.btn5);
        RadioGroup group5=(RadioGroup)findViewById(R.id.rgStep5);

        group5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb5Id=group.getCheckedRadioButtonId();
                final RadioButton rb=(RadioButton)findViewById(rb5Id);

                btn5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper=new txtFileOperation(getApplicationContext());

                        helper.writeSDFile(((TextView)findViewById(R.id.tvStep5)).getText().toString()+ rb.getText().toString() +"\n", "test.txt");
                        //Toast.makeText(getApplicationContext(),helper.readSDFile("test.txt"),Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(StepFiveActivity.this,StepSixActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });



    }


}

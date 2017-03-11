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

public class StepFourActivity extends AppCompatActivity {
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);

        TextView tvStep4 = (TextView) findViewById(R.id.tvStep4);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep4.setTypeface(typeface);

        btn4=(Button)findViewById(R.id.btn4);
        RadioGroup group4=(RadioGroup)findViewById(R.id.rgStep4);

        group4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb4Id=group.getCheckedRadioButtonId();
                final RadioButton rb=(RadioButton)findViewById(rb4Id);

                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper=new txtFileOperation(getApplicationContext());

                        helper.writeSDFile(((TextView)findViewById(R.id.tvStep4)).getText().toString()+ rb.getText().toString() +"\n", "test.txt");
                        //Toast.makeText(getApplicationContext(),helper.readSDFile("test.txt"),Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(StepFourActivity.this,StepFiveActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });



    }


}

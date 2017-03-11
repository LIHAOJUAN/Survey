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

public class StepTenActivity extends AppCompatActivity {
    Button btn10;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ten);

        TextView tvStep10 = (TextView) findViewById(R.id.tvStep10);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep10.setTypeface(typeface);

        btn10=(Button)findViewById(R.id.btn10);
        RadioGroup group10=(RadioGroup)findViewById(R.id.rgStep10);

        group10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb10Id=group.getCheckedRadioButtonId();
                final RadioButton rb=(RadioButton)findViewById(rb10Id);

                btn10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper=new txtFileOperation(getApplicationContext());

                        helper.writeSDFile(((TextView)findViewById(R.id.tvStep10)).getText().toString()+ rb.getText().toString() +"\n", "test.txt");
                        Intent intent=new Intent(StepTenActivity.this,StepElevenActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });



    }


}

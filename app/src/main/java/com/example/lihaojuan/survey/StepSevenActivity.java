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

public class StepSevenActivity extends AppCompatActivity {
    Button btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seven);

        TextView tvStep7 = (TextView) findViewById(R.id.tvStep7);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep7.setTypeface(typeface);

        btn7=(Button)findViewById(R.id.btn7);
        RadioGroup group7=(RadioGroup)findViewById(R.id.rgStep7);

        group7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb7Id=group.getCheckedRadioButtonId();
                final RadioButton rb=(RadioButton)findViewById(rb7Id);

                btn7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper=new txtFileOperation(getApplicationContext());

                        helper.writeSDFile(((TextView)findViewById(R.id.tvStep7)).getText().toString()+ rb.getText().toString() +"\n", "test.txt");
                        //Toast.makeText(getApplicationContext(),helper.readSDFile("test.txt"),Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(StepSevenActivity.this,StepEightActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });



    }


}

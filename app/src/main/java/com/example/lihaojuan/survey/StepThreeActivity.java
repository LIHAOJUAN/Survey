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

public class StepThreeActivity extends AppCompatActivity {
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three);

        TextView tvStep3 = (TextView) findViewById(R.id.tvStep3);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep3.setTypeface(typeface);

        btn3=(Button)findViewById(R.id.btn3);
        RadioGroup group3=(RadioGroup)findViewById(R.id.rgStep3);

        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb3Id=group.getCheckedRadioButtonId();
                final RadioButton rb=(RadioButton)findViewById(rb3Id);

                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper=new txtFileOperation(getApplicationContext());

                        helper.writeSDFile(((TextView)findViewById(R.id.tvStep3)).getText().toString()+ rb.getText().toString() +"\n", "test.txt");
                        //Toast.makeText(getApplicationContext(),helper.readSDFile("test.txt"),Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(StepThreeActivity.this,StepFourActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });



    }


}

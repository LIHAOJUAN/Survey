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

public class StepElevenActivity extends AppCompatActivity {
    Button btn11;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eleven);

        TextView tvStep11 = (TextView) findViewById(R.id.tvStep11);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"Soft Core.ttf");
        tvStep11.setTypeface(typeface);

        btn11=(Button)findViewById(R.id.btn11);
        RadioGroup group11=(RadioGroup)findViewById(R.id.rgStep11);

        group11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb11Id=group.getCheckedRadioButtonId();
                final RadioButton rb=(RadioButton)findViewById(rb11Id);

                btn11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        txtFileOperation helper=new txtFileOperation(getApplicationContext());

                        helper.writeSDFile(((TextView)findViewById(R.id.tvStep11)).getText().toString()+ rb.getText().toString() +"\n", "test.txt");
                        Intent intent=new Intent(StepElevenActivity.this,StepTwelveActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });



    }


}

package com.example.lihaojuan.survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Joseph on 2017/3/11.
 */

public class StepEmailActivity extends AppCompatActivity {
    Button btnemail;
    EditText email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);

        email=(EditText) findViewById(R.id.etEmail);
        btnemail=(Button) findViewById(R.id.btnsubtmit);
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmail(email.getText().toString())){

                    txtFileOperation helper=new txtFileOperation(getApplicationContext());
                    helper.writeSDFile("Your email address :"+ email.getText().toString() +"\n", "test.txt");

                    Intent iEmail=new Intent(StepEmailActivity.this,StepEndActivity.class);
                    startActivity(iEmail);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill in the correct mailbox format.",Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    public boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

}

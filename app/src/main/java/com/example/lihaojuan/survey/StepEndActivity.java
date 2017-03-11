package com.example.lihaojuan.survey;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by lihaojuan on 17/3/12.
 */

public class StepEndActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);

        TextView textView = (TextView) findViewById(R.id.textView);
        Typeface tface = Typeface.createFromAsset(getAssets(),"Annabelle.ttf");
        textView.setTypeface(tface);
    }
}

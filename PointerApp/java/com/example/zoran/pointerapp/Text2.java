package com.example.zoran.pointerapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by Zoran on 03.02.2017..
 */

public class Text2 extends AppCompatActivity {


    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text2);


        t = (TextView) findViewById(R.id.textView2);
        loadText();

        Intent ii = getIntent();
        Bundle ib = ii.getExtras();
        String a = (String) ib.get("name");
        t.setText(a);
    }
    private void loadText(){
        String s = "";
        for (int i=0; i<100; i++){
            s += ""+ String.valueOf(i) + "\n";
        }
        t.setMovementMethod(new ScrollingMovementMethod());
        t.setText(s);

    }
}

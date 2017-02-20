package com.example.zoran.pointerapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class Text1 extends AppCompatActivity {


        Button ok;
        EditText e1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.text1);

            ok = (Button) findViewById(R.id.button2);
            e1 = (EditText) findViewById(R.id.editText);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(getApplicationContext(), Text2.class);
                    String s = e1.getText().toString();
                    i.putExtra("name", s);
                    startActivity(i);
                }
            });

        }
    }


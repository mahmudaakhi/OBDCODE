package com.akhi.obdcodeerror;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Search extends AppCompatActivity {

    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();

        String code=getIntent().getStringExtra("Code");
        String des=getIntent().getStringExtra("Description");
        String possible=getIntent().getStringExtra("Possible_Cause");

 textView1=findViewById(R.id.tv_Code);
        textView2=findViewById(R.id.tv_des);
        textView3=findViewById(R.id.tv_pCause);
        textView1.setText(code);
        textView2.setText(des);
        textView3.setText(possible);


    }
}
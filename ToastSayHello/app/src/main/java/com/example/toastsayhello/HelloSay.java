package com.example.toastsayhello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloSay extends AppCompatActivity {

    private TextView textViewCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_say);

        textViewCount = (TextView)findViewById(R.id.textViewCount);
        Intent catchIntent = getIntent();
        String getCount = catchIntent.getStringExtra(MainActivity.SENDCOUNT);
        textViewCount.setText(getCount);
    }

}
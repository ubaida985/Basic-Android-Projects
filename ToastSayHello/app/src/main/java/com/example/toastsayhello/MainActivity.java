package com.example.toastsayhello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int count = 0;
    private TextView textViewCount;
    public static final String SENDCOUNT = "com.example.android.toastsayhello.extra.SENDCOUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount = (TextView) findViewById(R.id.textViewCount);
    }

    public void sayHello(View view) {
        Intent intent = new Intent(this, HelloSay.class);
        intent.putExtra(SENDCOUNT, Integer.toString(count));
        startActivity(intent);
    }

    public void incrementCount(View view) {
        ++count;
        textViewCount.setText(Integer.toString(count));
    }
}
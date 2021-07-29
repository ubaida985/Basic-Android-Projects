package com.example.implicitintentreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static TextView textViewUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUrl = (TextView)findViewById(R.id.textViewUrl);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if( uri != null ){
            String text = "URI: " + uri.toString();
            textViewUrl.setText(text);
        }
    }
}
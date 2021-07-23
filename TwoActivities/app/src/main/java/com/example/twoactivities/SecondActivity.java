package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewMessage;
    private EditText editTextSecond;
    public static final String REPLY = "com.example.android.twoactivites.extra.REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextSecond = (EditText)findViewById(R.id.editTextSecond);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE);

        textViewMessage = (TextView)findViewById(R.id.textViewMessage);
        textViewMessage.setText(message);
    }

    public void switchToMainActivity(View view) {
        Intent replyIntent = new Intent(this,MainActivity.class);
        String reply = editTextSecond.getText().toString();
        replyIntent.putExtra(REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
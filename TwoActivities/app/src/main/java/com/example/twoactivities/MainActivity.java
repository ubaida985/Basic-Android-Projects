package com.example.twoactivities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private EditText editTextMain;
    private TextView textViewReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMain = (EditText) findViewById(R.id.editTextMain);
        textViewReply = (TextView) findViewById(R.id.textViewReply);
        Log.d("TAG", "CREATED");
    }

    public void switchToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = editTextMain.getText().toString();
        intent.putExtra(MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
        Log.d("TAG", "SWITCHING");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == TEXT_REQUEST ){
            if( resultCode == RESULT_OK ){
                String reply = data.getStringExtra(SecondActivity.REPLY);
                textViewReply.setText(reply);
            }
        }
        Log.d("TAG", "GETTING RESULT");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String reply = textViewReply.getText().toString();
        if( reply != null ){
            outState.putString("REPLY_TEXT", reply );
        }
        Log.d("TAG", "SAVING");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if( savedInstanceState != null ){
            textViewReply.setText(savedInstanceState.getString("REPLY_TEXT"));
        }
        Log.d("TAG", "RESTORING");
    }
}
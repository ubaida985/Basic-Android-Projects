package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    TextView textViewOne, textViewTwo, textViewThree, textViewFour, textViewFive;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOne = findViewById(R.id.textViewOne);
        textViewTwo = findViewById(R.id.textViewTwo);
        textViewThree = findViewById(R.id.textViewThree);
        textViewFour = findViewById(R.id.textViewFour);
        textViewFive = findViewById(R.id.textViewFive);
        buttonAdd = findViewById(R.id.buttonAdd);



    }

    public void addItem(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
        Log.d("LOG_TAG", "addItem()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == TEXT_REQUEST ){
            if( resultCode == RESULT_OK ){
                if (textViewOne.getText().toString() == null) {
                    textViewOne.setText(data.getStringExtra(ListActivity.ITEM));
                } else if (textViewTwo.getText().toString() == null) {
                    textViewTwo.setText(data.getStringExtra(ListActivity.ITEM));
                } else if (textViewThree.getText().toString() == null) {
                    textViewThree.setText(data.getStringExtra(ListActivity.ITEM));
                } else if (textViewFour.getText().toString() == null) {
                    textViewFour.setText(data.getStringExtra(ListActivity.ITEM));
                } else if (textViewFive.getText().toString() == null) {
                    textViewFive.setText(data.getStringExtra(ListActivity.ITEM));
                } else {
                    Toast.makeText(this, "CANNOT ADD LIST FULL", Toast.LENGTH_SHORT).show();
                }
            }
        }
        Log.d("LOG_TAG", "onActivityResult()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("ONE", textViewOne.getText().toString());
        outState.putString("TWO", textViewTwo.getText().toString());
        outState.putString("THREE", textViewThree.getText().toString());
        outState.putString("FOUR", textViewFour.getText().toString());
        outState.putString("FIVE", textViewFive.getText().toString());
        Log.d("LOG_TAG", "onSaveInstanceState()");
    }



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if( savedInstanceState != null ){
            textViewOne.setText(savedInstanceState.getString("ONE"));
            textViewTwo.setText(savedInstanceState.getString("TWO"));
            textViewThree.setText(savedInstanceState.getString("THREE"));
            textViewFour.setText(savedInstanceState.getString("FOUR"));
            textViewFive.setText(savedInstanceState.getString("FIVE"));
        }
        Log.d("LOG_TAG", "onRestoreInstanceState()");
    }

}
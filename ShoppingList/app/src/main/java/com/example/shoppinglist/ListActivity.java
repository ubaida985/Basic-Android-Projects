package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    public static String ITEM = "com.example.android.extra.ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public void addToList(View view) {
        Button button = (Button)view;
        String item = button.getText().toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ITEM", item);
        finish();
    }
}
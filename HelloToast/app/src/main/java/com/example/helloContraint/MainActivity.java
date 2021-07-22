package com.example.helloContraint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    TextView showCount;
    Button buttonZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = (TextView) findViewById(R.id.showCount);
        buttonZero = (Button) findViewById(R.id.buttonZero);
    }


    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void incrementCount(View view) {
        if (count == 0){
            buttonZero.setBackgroundColor(Color.parseColor("#000000"));
        }
        ++count;
        if( count%2 == 0 ){
            view.setBackgroundColor(Color.parseColor("#000000"));
        }else{
            view.setBackgroundColor(Color.parseColor("#dddddd"));
        }
        showCount.setText(Integer.toString(count));
    }

    public void resetCount(View view) {
        buttonZero.setBackgroundColor(Color.parseColor("#808080"));
        count = 0;
        showCount.setText(Integer.toString(count));
    }
}
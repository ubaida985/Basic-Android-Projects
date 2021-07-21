package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = (TextView)findViewById(R.id.showCount);
    }


    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void incrementCount( View view ){
        ++ count;
        showCount.setText(Integer.toString(count));
    }

}
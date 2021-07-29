package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private static EditText editTextWebsite, editTextText, editTextLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWebsite = (EditText)findViewById(R.id.editTextWebsite);
        editTextText = (EditText)findViewById(R.id.editTextText);
        editTextLocation = (EditText)findViewById(R.id.editTextLocation);

    }

    public void shareText(View view) {

        String text = editTextText.getText().toString();
        String textType = "text/plain";
        ShareCompat.IntentBuilder .from(this) .setType(textType) .setChooserTitle("Share the text with: ") .setText(text) .startChooser();

    }

    public void openLocation(View view) {

        String location = editTextLocation.getText().toString();
        Uri address = Uri.parse("geo:0,0?q="+location);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        if( intent.resolveActivity(getPackageManager()) != null ){
            startActivity(intent);
        }else{
            Log.d("IMPLICIT_INTENT", "No apps Compatible");
        }

    }

    public void openWebsite(View view) {

        String url = editTextWebsite.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if( intent.resolveActivity(getPackageManager()) != null ){
            startActivity(intent);
        }else{
            Log.d("IMPLICIT_INTENT", "No apps compatible");
        }

    }

    public void launchCamera(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try{
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Log.d("IMPLICIT_INTENT", "No apps compatible");
        }

    }
}
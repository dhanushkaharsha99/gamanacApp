package com.example.gamanac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;

public class northcentral extends AppCompatActivity {

    ImageButton button1,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the action bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_northcentral);

        button1 = findViewById(R.id.imgbtn_anurapura);
        button2 = findViewById(R.id.imgbtn_polonnaruwa);


    }
}
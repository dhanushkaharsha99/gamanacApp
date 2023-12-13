package com.example.gamanac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class kandy extends AppCompatActivity {

    ImageButton button1,button2,button3,button4,button5,button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the action bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_kandy);

            button1 = findViewById(R.id.imgbtn_kabaragala);
            button2 = findViewById(R.id.imgbtn_narampanawa);
            button3 = findViewById(R.id.imgbtn_belwood);
            button4 = findViewById(R.id.imgbtn_rangala);
            button5 = findViewById(R.id.imgbtn_hulugaga);
            button6 = findViewById(R.id.imgbtn_kalabokka);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),kabaragalakandy.class);
                    startActivity(i);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),NarampanawaKandy.class);
                    startActivity(i);
                }
            });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Bellwoodkandy.class);
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Rangalakandy.class);
                startActivity(i);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Hulugagakandy.class);
                startActivity(i);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),kalabokkakandy.class);
                startActivity(i);
            }
        });


    }
}
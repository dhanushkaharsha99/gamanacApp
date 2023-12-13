package com.example.gamanac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgotpassword extends AppCompatActivity {

    EditText text1,text2,text3,text4;
    Button button1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the action bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forgotpassword);
        text1 = findViewById(R.id.user_id);
        text2 = findViewById(R.id.username3);
        text3 = findViewById(R.id.password3);
        text4 = findViewById(R.id.con_pass3);
        button1 = findViewById(R.id.btn_resetpwd);
        DB = new DBHelper(this);            // instant of DBHelper class


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           //call updatedata() method in DBHelper
                boolean updateData = DB.updateData(text1.getText().toString(), text2.getText().toString(), text3.getText().toString(),text4.getText().toString());
                if (updateData == true) {
                    Toast.makeText(forgotpassword.this, "Update Succesfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(forgotpassword.this, "Data not Updated", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}
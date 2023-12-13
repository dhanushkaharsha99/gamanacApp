package com.example.gamanac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText text1,text2;
    Button button1,button2,button3;
    DBHelper DB;    // variable to call database DBhelper class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the action bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_login);

        text1 = findViewById(R.id.username);
        text2 = findViewById(R.id.password);
        button1 = findViewById(R.id.btn_resetpwd);
        button2 = findViewById(R.id.btn_sign);
        button3 = findViewById(R.id.btn_forgot);
        DB = new DBHelper(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get values entered in the username,password fields
                String user = text1.getText().toString();
                String pass = text2.getText().toString();
                // Check if either any fields are empty
                if (user.equals("")||pass.equals(""))
                    Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusearnamepassword(user,pass);
                    if (checkuserpass==true){       // If the credentials are valid
                        Toast.makeText(Login.this, "Sign in Succesfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else{                          // If the credentials are invalid
                        Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUP.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),forgotpassword.class);
                startActivity(intent);
            }
        });
    }




}

package com.example.gamanac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;

public class SignUP extends AppCompatActivity {

    EditText text1, text2, text3;
    Button button1;
    DBHelper DB;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the action bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_sign_up);

        text1 = findViewById(R.id.username2);
        text2 = findViewById(R.id.password2);
        text3 = findViewById(R.id.conform_pwd);
        button1 = findViewById(R.id.btn_register);
        DB = new DBHelper(this);

        alertDialogBuilder = new AlertDialog.Builder(this); // use to display user id dialog box

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // get input data from user
                String user = text1.getText().toString();
                String pass = text2.getText().toString();
                String con_pass = text3.getText().toString();

                //check if the fields are empty
                if (user.equals("") || pass.equals("") || con_pass.equals("")) {
                    Toast.makeText(SignUP.this, "Please Enter All the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(con_pass)) {        //check passwords are matching
                        boolean checkuser = DB.checkusername(user);
                        if (!checkuser) {                                           // Insert user data into the database if user not exist
                            boolean insert = DB.insertData(user, pass, con_pass);
                            if (insert) {
                                int userId = DB.getUserId(user); // Retrieve the user ID from the database
                                String message = "Please keep this Secure To Reset your password , User ID: " + userId; // Create the message to display

                                // Create and show the pop-up message
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SignUP.this);
                                alertDialogBuilder.setTitle("Register Successfully");
                                alertDialogBuilder.setMessage(message);
                                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(SignUP.this, Login.class);
                                        startActivity(intent);
                                    }
                                });
                                alertDialogBuilder.show();

                            } else {
                                Toast.makeText(SignUP.this, "Registration fails", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUP.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUP.this, "Passwords not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

package com.example.gamanac;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper { //define Dbhelper that extends Sqlitehelper

    public static final String DBNAME = "Login.db"; //db name
    private static final String TABLE_NAME = "users"; // table name

    public DBHelper( Context context) {
        super(context, "Login.db", null, 1);            //DBhelperclass constructor
    }

    @Override               //create Database
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT , password TEXT, con_pass TEXT)");
    }


    @Override               //To Upgrade the database
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }
                           //insertdata into database
    public boolean insertData(String username,String password, String con_pass){  //data insertion
        SQLiteDatabase  MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);             //constentvalues to collect user inputs and insert method to insert data to usertable
        contentValues.put("password",password);
        contentValues.put("con_pass",con_pass);
        long results = MyDB.insert("users",null,contentValues);
        if(results == -1)
            return false;
        else
            return true;
    }
                            // check username exists
    public boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select  * from users where username = ?",new String[]{username});
        if (cursor.getCount()>0)            //Check returning cursor value is  >0,if yes that value exists
            return true;
        else
            return false;
    }
                            //check username,password both exists.
    public boolean checkusearnamepassword(String username, String password){
      SQLiteDatabase MyDB = this.getWritableDatabase() ;
      Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?",new String[]{username,password});
      if (cursor.getCount()>0){
          return true;
      }
      else{
          return false;
      }
    }
                // get userid from user table
    public int getUserId(String username) {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT id FROM users WHERE username = ?", new String[]{username});  // get the userid for given username

        if (cursor.moveToFirst()) {         //get userid from current row
            @SuppressLint("Range") int userId = cursor.getInt(cursor.getColumnIndex("id"));
            cursor.close();
            return userId;
        } else {
            cursor.close();
            return -1; // Return -1 if the user ID is not found
        }
    }
                //update the database
    public boolean updateData(String id,String username, String password, String con_pass){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("con_pass",con_pass);
        MyDB.update(TABLE_NAME,contentValues,"username = ?",new String[]{username});
        return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor results = DB.rawQuery("Select id from" + TABLE_NAME,null);
        return results;
    }

}

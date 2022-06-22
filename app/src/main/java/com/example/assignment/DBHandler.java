package com.example.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

//--------------------------------------------Register and login-----------------------------------------
    public static final String DBNAME = "Login.db";

    public DBHandler(Context context) {
        super(context, "Login.db",null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        Mydb.execSQL("CREATE TABLE users(username TEXT primary Key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("DROP TABLE IF EXISTS users");
    }

    public boolean insertDate(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username",username);
        contentValues.put("password",password);

        long result = MyDB.insert("users",null,contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{username});
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE username = ? and password = ?", new String[]{username,password});
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



}

package com.example.assignment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHandlerPayment extends SQLiteOpenHelper {

    //--------------------------------------------Payment-----------------------------------------

    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "paymentdatabase";
    private static final String TABLE_PAYMENTS = "paymenttable";
    private static final String KEY_ID = "id";
    private static final String KEY_PID = "paymentID";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_DATE = "date";
    private static final String KEY_TAX = "tax";

    public DBHandlerPayment(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PAYMENTS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PID + " TEXT," + KEY_AMOUNT + " TEXT," + KEY_DATE + " TEXT," + KEY_TAX + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAYMENTS);
        onCreate(db);
    }

    public void insertPaymentDetails(String paymentID, String amount, String date, String tax)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_PID, paymentID);
        contentValues.put(KEY_AMOUNT, amount);
        contentValues.put(KEY_DATE, date);
        contentValues.put(KEY_TAX, tax);

        long newRowID = db.insert(TABLE_PAYMENTS, null, contentValues);
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<HashMap<String , String >> getAllPayment()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<HashMap<String , String >> paymentList = new ArrayList<>();

        String query = "SELECT id, paymentID, amount, date, tax FROM " + TABLE_PAYMENTS;
        Cursor cursor = db.rawQuery(query,null);


        while(cursor.moveToNext()){
            HashMap<String, String> payment = new HashMap<>();
            payment.put("id", cursor.getString(cursor.getColumnIndex(KEY_ID)));
            payment.put("paymentID", cursor.getString(cursor.getColumnIndex(KEY_PID)));
            payment.put("amount", cursor.getString(cursor.getColumnIndex(KEY_AMOUNT)));
            payment.put("date", cursor.getString(cursor.getColumnIndex(KEY_DATE)));
            payment.put("tax", cursor.getString(cursor.getColumnIndex(KEY_TAX)));
            paymentList.add(payment);
        }
        return paymentList;

    }

    @SuppressLint("Range")
    public HashMap<String, String> getSinglePayment(int pID){
        SQLiteDatabase db = this.getReadableDatabase();
        HashMap<String, String> payment = new HashMap<>();

        String query = "SELECT id, paymentID, amount, date, tax FROM " + TABLE_PAYMENTS + " WHERE " + KEY_ID + " = " + pID;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor != null && cursor.moveToFirst()){
            payment.put("id", cursor.getString(cursor.getColumnIndex(KEY_ID)));
            payment.put("paymentID", cursor.getString(cursor.getColumnIndex(KEY_PID)));
            payment.put("amount", cursor.getString(cursor.getColumnIndex(KEY_AMOUNT)));
            payment.put("date", cursor.getString(cursor.getColumnIndex(KEY_DATE)));
            payment.put("tax", cursor.getString(cursor.getColumnIndex(KEY_TAX)));
            cursor.close();
        }
        return payment;
    }  //end of getSinglePayment

    public int updatePaymentDetails(int id, String amount, String date, String tax)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_AMOUNT, amount);
        contentValues.put(KEY_DATE, date);
        contentValues.put(KEY_TAX, tax);

        int count = db.update(TABLE_PAYMENTS, contentValues, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        return count;
    }

    public void deletePayment(int pID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PAYMENTS, KEY_ID + " = ?", new String[]{String.valueOf(pID)});
        db.close();
    }

    public String getSumPayment(){
        SQLiteDatabase db = this.getReadableDatabase();

        String sPaymentAmount;
        String sQuery = "SELECT SUM(amount) FROM " + TABLE_PAYMENTS;

        Cursor cursor = db.rawQuery(sQuery,null);

        if(cursor.moveToFirst())
        {
            sPaymentAmount = String.valueOf(cursor.getInt(0));
        }
        else
        {
            sPaymentAmount = "0";
        }

        cursor.close();
        db.close();

        return sPaymentAmount;
    }


    public String getSumTax(){
        SQLiteDatabase db = this.getReadableDatabase();

        String sTaxAmount;
        String sQuery = "SELECT SUM(tax) FROM " + TABLE_PAYMENTS;

        Cursor cursor = db.rawQuery(sQuery,null);

        if(cursor.moveToFirst())
        {
            sTaxAmount = String.valueOf(cursor.getInt(0));
        }
        else
        {
            sTaxAmount = "0";
        }

        cursor.close();
        db.close();

        return sTaxAmount;
    }


}

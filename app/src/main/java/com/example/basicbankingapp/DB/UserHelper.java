package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(6780,'Sahana sana', 'sahana@gmail.com','7564','9098690233', 13000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9876,'Jahnavi janu', 'janu@gmail.com','1876','8877653238', 14000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3456,'Sneha shree', 'sneha@gmail.com','6756','7865445896', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5432,'Shilpa sri', 'shilpa@gmail.com','7752','9995640038', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8765,'Shantha Kumari', 'shantha@gmail.com','7863','8099648962', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8587,'Caroline forbes', 'care@gmail.com','7653','9877654329', 8700)");
        db.execSQL("insert into " + TABLE_NAME + " values(3248,'Klaus Mikelson', 'klaus@gmail.com','8906','9988765432', 9080)");
        db.execSQL("insert into " + TABLE_NAME + " values(9821,'Vidhya dhare', 'vidhya@gmail.com','4522','9985021539', 8900)");
        db.execSQL("insert into " + TABLE_NAME + " values(6542,'Ram pothineni', 'ram@gmail.com','8664','8776889076', 10450)");
        db.execSQL("insert into " + TABLE_NAME + " values(8035,'Nani suraj', 'nani@gmail.com','8754','8675543245', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9870,'Damon salvatore', 'damon@gmail.com','9088','9019644478', 7400)");
        db.execSQL("insert into " + TABLE_NAME + " values(3020,'Pallavi ramaiah', 'pallavi@gmail.com','3215','8066547897', 12200)");
        db.execSQL("insert into " + TABLE_NAME + " values(1613,'Nuthan anil', 'nuthan@gmail.com','8765','9019877765', 8700)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Bonnie bennet', 'bonnie@gmail.com','9087','9876546678', 3590)");
        db.execSQL("insert into " + TABLE_NAME + " values(8106,'Hope mikelson', 'hope@gmail.com','4532','6123547884', 9020)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
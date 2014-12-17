package com.example.james.gamingnews;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
/**
 * Created by James on 15/12/2014.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserDetails.s3db";
    private static final String TABLE_LOGININFORMATION = "LoginInformation";

    // private static final String DB_PATH = "/data/data/com.example.james.gamingnews.app/databases/";
    // private static final String DB_NAME = "UserDetails.s3db";

    public static final String COL_USERID = "UserID";
    public static final String COL_FIRSTNAME = "FirstName";
    public static final String COL_LASTNAME = "LastName";
    public static final String COL_EMAIL = "Email";
    public static final String COL_PASSWORD = "Password";
    public static final String COL_USERNAME = "UserName";


   // private final Context appContext;

    public DBHandler(Context context, String name,
                     SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        // this.appContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGININFORMATION_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_LOGININFORMATION + "("
                + COL_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_FIRSTNAME
                + " TEXT NOT NULL," + COL_LASTNAME + " TEXT NOT NULL," + COL_EMAIL + " TEXT NOT NULL,"
                + COL_PASSWORD + " TEXT," + COL_USERNAME + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_LOGININFORMATION_TABLE);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGININFORMATION);
        onCreate(db);
    }

    public void addUserInfo(DBUserSETGET DBUsersetget) {

        ContentValues values = new ContentValues();

        values.put(COL_FIRSTNAME, DBUsersetget.getFirstName());
        values.put(COL_LASTNAME, DBUsersetget.getLastName());
        values.put(COL_EMAIL, DBUsersetget.getEmail());
        values.put(COL_PASSWORD, DBUsersetget.getPassword());
        values.put(COL_USERNAME, DBUsersetget.getUserName());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_LOGININFORMATION, null, values);
        db.close();
    }

    public DBUserSETGET findUserInfo(String VerifyUser) {
        String query = "Select * FROM " + TABLE_LOGININFORMATION + " WHERE " + COL_USERNAME + " =  \"" + VerifyUser + "\"";
        Log.e("n", "Query Started for UserName");

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        DBUserSETGET DBUsersetget = new DBUserSETGET();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            DBUsersetget.setUserID(Integer.parseInt(cursor.getString(0)));
            DBUsersetget.setFirstName(cursor.getString(1));
            DBUsersetget.setLastName(cursor.getString(2));
            DBUsersetget.setEmail(cursor.getString(3));
            DBUsersetget.setPassword(cursor.getString(4));
            DBUsersetget.setUserName(cursor.getString(5));

            cursor.close();
            Log.e("n", "Cursor Close");
        } else {
            DBUsersetget = null;
            Log.e("n", "Return NULL");
        }
        db.close();
        Log.e("n", "DB Close");
        return DBUsersetget;

    }

    public boolean removeUserInfo(String UsernameInput) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_LOGININFORMATION + " WHERE " + COL_USERNAME + " =  \"" + UsernameInput + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        DBUserSETGET DBUsersetget = new DBUserSETGET();

        if (cursor.moveToFirst()) {
            DBUsersetget.setUserID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_LOGININFORMATION, COL_USERID + " = ?",
                    new String[]{String.valueOf(DBUsersetget.getUserID())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}


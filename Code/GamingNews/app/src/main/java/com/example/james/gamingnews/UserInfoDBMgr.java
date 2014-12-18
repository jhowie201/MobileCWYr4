package com.example.james.gamingnews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by rla on 10/10/2014.
 */
public class UserInfoDBMgr extends SQLiteOpenHelper {

    private static final int DB_VER = 1;
    private static final String DB_PATH = "/data/data/com.example.james.gamingnews.app/databases/";
    private static final String DB_NAME = "UserDetails.s3db";
    private static final String TBL_LOGININFORMATION = "LoginInformation";

    public static final String COL_USERID = "UserID";
    public static final String COL_FIRSTNAME = "FirstName";
    public static final String COL_LASTNAME = "LastName";
    public static final String COL_PASSWORD = "Password";
    public static final String COL_USERNAME = "UserName";
    public static final String COL_EMAIL = "Email";


    private final Context appContext;

    public UserInfoDBMgr(Context context, String name,
                         SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.appContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            String CREATE_LOGININFORMATION_TABLE = "CREATE TABLE IF NOT EXISTS " +
                    TBL_LOGININFORMATION + "("
                    + COL_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_FIRSTNAME
                    + " TEXT NOT NULL," + COL_LASTNAME + " TEXT NOT NULL," + COL_EMAIL + " TEXT NOT NULL,"
                    + COL_PASSWORD + " TEXT," + COL_USERNAME + " TEXT NOT NULL" + ")";
            db.execSQL(CREATE_LOGININFORMATION_TABLE);
        Log.e("DB Create","LoginInformation Created");
        String InsertData = "INSERT INTO LoginInformation VALUES(1,'James','Howie','JamesHowie@hotmail.com','pass','Jhowie201')";
         db.execSQL(InsertData);
        Log.e("DB Create","Data Inserted Into Database");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS " + TBL_LOGININFORMATION);
            onCreate(db);
        }
    }

    // ================================================================================
    // Creates a empty database on the system and rewrites it with your own database.
    // ================================================================================
    public void dbCreate() throws IOException {

        boolean dbExist = dbCheck();

        if(!dbExist){
            //By calling this method an empty database will be created into the default system path
            //of your application so we can overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDBFromAssets();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    // ============================================================================================
    // Check if the database already exist to avoid re-copying the file each time you open the application.
    // @return true if it exists, false if it doesn't
    // ============================================================================================
    private boolean dbCheck(){

        SQLiteDatabase db = null;

        try{
            String dbPath = DB_PATH + DB_NAME;
            db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
            db.setLocale(Locale.getDefault());
            db.setVersion(1);

        }catch(SQLiteException e){

            Log.e("SQLHelper","Database not Found!");

        }

        if(db != null){

            db.close();

        }

        return db != null ? true : false;
    }

    // ============================================================================================
    // Copies your database from your local assets-folder to the just created empty database in the
    // system folder, from where it can be accessed and handled.
    // This is done by transfering bytestream.
    // ============================================================================================
    private void copyDBFromAssets() throws IOException{

        InputStream dbInput = null;
        OutputStream dbOutput = null;
        String dbFileName = DB_PATH + DB_NAME;

        try {

            dbInput = appContext.getAssets().open(DB_NAME);
            dbOutput = new FileOutputStream(dbFileName);
            //transfer bytes from the dbInput to the dbOutput
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dbInput.read(buffer)) > 0) {
                dbOutput.write(buffer, 0, length);
            }

            //Close the streams
            dbOutput.flush();
            dbOutput.close();
            dbInput.close();
        } catch (IOException e)
        {
            throw new Error("Problems copying DB!");
        }
    }


    public void addUserInfo(UserInfo aUserInfo) {

        ContentValues values = new ContentValues();
        values.put(COL_FIRSTNAME, aUserInfo.getFirstName());
        values.put(COL_LASTNAME, aUserInfo.getLastName());
        values.put(COL_EMAIL, aUserInfo.getEmail());
        values.put(COL_PASSWORD, aUserInfo.getPassword());
        values.put(COL_USERNAME, aUserInfo.getUserName());


        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TBL_LOGININFORMATION, null, values);
        db.close();
    }

    public UserInfo findUserInfo(String VerifyUser) {
        String query = "Select * FROM " + TBL_LOGININFORMATION + " WHERE " + COL_USERNAME + " =  \"" + VerifyUser + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        UserInfo UserInfo = new UserInfo();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            UserInfo.setUserID(Integer.parseInt(cursor.getString(0)));
            UserInfo.setFirstName(cursor.getString(1));
            UserInfo.setLastName(cursor.getString(2));
            UserInfo.setEmail(cursor.getString(3));
            UserInfo.setPassword(cursor.getString(4));
            UserInfo.setUserName(cursor.getString(5));

            cursor.close();
        } else {
            UserInfo = null;
        }
        db.close();
        return UserInfo;
    }

    public boolean removeUserInfo(String sUserInfo) {

        boolean result = false;

        String query = "Select * FROM " + TBL_LOGININFORMATION + " WHERE " + COL_FIRSTNAME + " =  \"" + sUserInfo + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        UserInfo StarSignsInfo = new UserInfo();

        if (cursor.moveToFirst()) {
            StarSignsInfo.setUserID(Integer.parseInt(cursor.getString(0)));
            db.delete(TBL_LOGININFORMATION, COL_USERID + " = ?",
                    new String[] { String.valueOf(StarSignsInfo.getUserID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}

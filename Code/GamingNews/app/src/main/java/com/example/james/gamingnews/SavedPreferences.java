package com.example.james.gamingnews;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by James on 13/12/2014.
 */
public class SavedPreferences extends Activity {

    SharedPreferences SharedPref;
    private String UserName;
    private String Email;
    private String Search;

    // *********************************************
    // Declare getters and setters etc.
    // *********************************************

    private void setUserName(String isUsername)
    {
        this.UserName = isUsername;
    }
    public String getUserName()
    {
        return UserName;
    }
    private void setEmail(String isEmail)
    {
        this.Email = isEmail;
    }
    public String getEmail()
    {
        return Email;
    }
    private void setSearch(String isSearch)
    {
        this.Search = isSearch;
    }

    public String getSearch()
    {
        return Search;
    }

    // **************************************************
    // Declare constructor and date manipulation methods.
    // **************************************************

    public SavedPreferences(SharedPreferences SDPrefs){

        setUserName("Guest");
        setEmail("Null");
        setSearch("No Search");
        try {
            this.SharedPref = SDPrefs;
        }
        catch (Exception e)
        {
            Log.e("n", "Pref Manager is NULL");
        }
        setDefaultPrefs();
    }

    public void savePreferences(String key, boolean value) {
        SharedPreferences.Editor editor = SharedPref.edit();

        editor.putBoolean(key, value);
        editor.commit();
    }

    public void savePreferences(String key, String value) {
        SharedPreferences.Editor editor = SharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void savePreferences(String key, int value) {
        SharedPreferences.Editor editor = SharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void setDefaultPrefs(){
        savePreferences("UserName", "Guest");
        savePreferences("Email", "Null");
        savePreferences("Search", "No Search");

    }
}


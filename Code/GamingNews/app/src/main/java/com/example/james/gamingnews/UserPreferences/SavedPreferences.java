package com.example.james.gamingnews.UserPreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.example.james.gamingnews.mainactivities.AppMaps;
import com.example.james.gamingnews.mainactivities.MainActivity;

/**
 * Created by James on 13/12/2014.
 */
public class SavedPreferences extends Activity {

    SharedPreferences SharedPref;
    private String UserName;
    private String Email;


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


    // **************************************************
    // Declare constructor and date manipulation methods.
    // **************************************************

    public SavedPreferences(SharedPreferences SDPrefs){

        setUserName("Guest");
        setEmail("Null");

        try {
            this.SharedPref = SDPrefs;
        }
        catch (Exception e)
        {
            Log.e("n", "Preferences is null");
        }
        setDefaultPrefs();
    }

  //  public void savePreferences(String key, boolean value) {
      //  SharedPreferences.Editor editor = SharedPref.edit();

     //   editor.putBoolean(key, value);
     //   editor.commit();
   // }

    public void savePreferences(String key, String value) {
        SharedPreferences.Editor editor = SharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

   // public void savePreferences(String key, int value) {
        //SharedPreferences.Editor editor = SharedPref.edit();
       // editor.putInt(key, value);
       // editor.commit();
   // }

    public void setDefaultPrefs(){
        savePreferences("UserName", "Guest");
        savePreferences("Email", "Null");
     ;

    }




}


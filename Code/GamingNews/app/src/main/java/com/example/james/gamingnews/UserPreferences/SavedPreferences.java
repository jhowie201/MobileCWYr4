package com.example.james.gamingnews.UserPreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;


import com.example.james.gamingnews.mainactivities.MainActivity;

/**
 * Created by James on 13/12/2014.
 */
public class SavedPreferences extends Activity {

    SharedPreferences SharedPref;
    private String FavGame;


    // *********************************************
    // Declare getters and setters etc.
    // *********************************************



    private void setFavGame(String sFavGame)
    {
        this.FavGame = sFavGame;
    }
    public String getFavGame()
    {
        return FavGame;
    }


    // **************************************************
    // Declare constructor and date manipulation methods.
    // **************************************************

    public SavedPreferences(SharedPreferences SDPrefs){


        setFavGame(getFavGame());

        try {
            this.SharedPref = SDPrefs;
        }
        catch (Exception e)
        {
            Log.e("n", "Preferences is null");
        }
        setDefaultPrefs();
    }

    public void savePreferences(String key, String value) {

        SharedPreferences.Editor editor = SharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void setDefaultPrefs(){

        savePreferences("FavGame:", "No Game Entered");
    }
}


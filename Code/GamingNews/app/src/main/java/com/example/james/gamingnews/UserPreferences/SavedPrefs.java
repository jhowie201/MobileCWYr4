package com.example.james.gamingnews.UserPreferences;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.james.gamingnews.R;
import com.example.james.gamingnews.mainactivities.MainActivity;

/**
 * Created by James on 13/12/2014.
 */
public class SavedPrefs extends ActionBarActivity implements View.OnClickListener{

    SharedPreferences SharedPrefs;

    TextView txtFavGame;
    EditText FavGameInput;
    Button button;




    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView (R.layout.savedprefs);

        txtFavGame = (TextView)  findViewById (R.id.txtFavGame);
        FavGameInput = (EditText) findViewById (R.id.FavGameInput);
        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(this);

        SharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        loadSavedPreferences();

    }

    private void loadSavedPreferences(){


        String name = SharedPrefs.getString("StoredName"," ");
        FavGameInput.setText(name);
        txtFavGame.setText(txtFavGame.getText() + SharedPrefs.getString("FavGame: ", name));

    }



    public void onClick(View view){
        SavedPreferences savedprefs = new SavedPreferences(SharedPrefs);
        savedprefs.savePreferences("StoredName", FavGameInput.getText().toString());


        txtFavGame.setText(FavGameInput.getText());
        setResult(Activity.RESULT_OK);
        finish();


    }

    public void GoToMain (View view){
        Intent main = new Intent(this, MainActivity.class);
        this.startActivity(main);
    }

}


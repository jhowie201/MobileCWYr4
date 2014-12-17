package com.example.james.gamingnews.UserPreferences;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.james.gamingnews.R;
import com.example.james.gamingnews.mainactivities.MainActivity;

/**
 * Created by James on 13/12/2014.
 */
public class SavedPrefs extends Activity implements View.OnClickListener{
    SharedPreferences SharedPref;

    TextView txtUserName;
    TextView txtEmail;



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView (R.layout.savedprefs);

        txtUserName = (TextView)  findViewById (R.id.txtUser);
        txtEmail = (TextView)findViewById (R.id.txtEmail);



        SharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        loadSavedPreferences();
        Log.e("n", "Message");
    }

    private void loadSavedPreferences(){
        txtUserName.setText(txtUserName.getText() + SharedPref.getString("Username","Guest"));
        txtEmail.setText(txtEmail.getText() + SharedPref.getString("Email","Null"));


    }


    public void onClick(View view){
        setResult(Activity.RESULT_OK);
        finish();

    }

    public void GoToMain (View view){

        Intent main = new Intent(this, MainActivity.class);
        this.startActivity(main);
    }

}


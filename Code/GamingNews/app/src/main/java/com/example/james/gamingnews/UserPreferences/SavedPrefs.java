package com.example.james.gamingnews.UserPreferences;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.james.gamingnews.R;

/**
 * Created by James on 13/12/2014.
 */
public class SavedPrefs extends Activity implements View.OnClickListener{
    SharedPreferences SharedPref;
    Button btnBack;
    TextView txtUserName;
    TextView txtEmail;
    TextView txtSearch;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView (R.layout.savedprefs);
        btnBack = (Button) findViewById (R.id.btnBack);
        btnBack.setOnClickListener(this);

        txtUserName = (TextView)  findViewById (R.id.txtUser);
        txtEmail = (TextView)findViewById (R.id.txtEmail);
        txtSearch= (TextView)findViewById (R.id.txtSearch);


        SharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        loadSavedPreferences();
        Log.e("n", "Message");
    }

    private void loadSavedPreferences(){
        txtUserName.setText(txtUserName.getText() + SharedPref.getString("Username","Guest"));
        txtEmail.setText(txtEmail.getText() + SharedPref.getString("Email","Null"));
        txtSearch.setText(txtSearch.getText() + SharedPref.getString("LastSearched","No Search"));

    }


    public void onClick(View view){
        setResult(Activity.RESULT_OK);

    }

}


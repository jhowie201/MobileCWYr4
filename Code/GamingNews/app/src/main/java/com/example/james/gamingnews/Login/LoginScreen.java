package com.example.james.gamingnews.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.james.gamingnews.R;
import com.example.james.gamingnews.UserPreferences.SavedPrefs;

/**
 * Created by James on 15/12/2014.
 */
public class LoginScreen extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_on);
    }

    public void signUp (View view){

        Intent SU = new Intent(this, SignUp.class);
        this.startActivity(SU);
    }
}
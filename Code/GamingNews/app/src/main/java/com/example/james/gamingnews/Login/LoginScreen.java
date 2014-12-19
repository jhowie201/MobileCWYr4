package com.example.james.gamingnews.Login;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.example.james.gamingnews.R;

//JAMES HOWIE S1310206 MUC GamingNews Application!

/**
 * Created by James on 15/12/2014.
 */

//Used to Navigate to Sign Up View
    //NO LOGIN IMPLEMENTED!
public class LoginScreen extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_on);
    }

    public void signUp (View view){

        Intent SU = new Intent(this, SignUp.class); //When Button Clicked start activity
        this.startActivity(SU);
    }
}
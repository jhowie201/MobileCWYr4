package com.example.james.gamingnews.Login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.james.gamingnews.R;
import com.example.james.gamingnews.DataBase.UserInfo;
import com.example.james.gamingnews.DataBase.UserInfoDBMgr;

import java.io.IOException;

/**
 * Created by James on 16/12/2014.
 */
public class SignUp extends ActionBarActivity {
    TextView DBUserName;
    EditText VerifyUser;
    EditText FirstnameInput;
    EditText LastnameInput ;
    EditText EmailInput;
    EditText PasswordInput;
    EditText UsernameInput;

    int UserID;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        //UserInfoDBMgr UIDBMgr = new UserInfoDBMgr(this, null, null, 1);

        DBUserName = (TextView) findViewById(R.id.textView3);
        VerifyUser = (EditText) findViewById(R.id.editText);
        FirstnameInput = (EditText) findViewById(R.id.FnameInput);
        LastnameInput = (EditText) findViewById(R.id.LnameInput);
        EmailInput = (EditText) findViewById(R.id.EmailInput);
        PasswordInput = (EditText) findViewById(R.id.PasswordInput);
        UsernameInput = (EditText) findViewById(R.id.UsernameInput);

    }


    public void addUserInfo (View view) {
        final MediaPlayer mpButtonClick = MediaPlayer.create(this,R.raw.button_click);
        mpButtonClick.start();
        UserInfoDBMgr UIDBMgr = new UserInfoDBMgr(this, null, null, 1);


        String FirstName = FirstnameInput.getText().toString();
        String LastName = LastnameInput.getText().toString();
        String Email = EmailInput.getText().toString();
        String Password = PasswordInput.getText().toString();
        String UserName = UsernameInput.getText().toString();
        Log.e("Sign Up","Gets New Data from User");

        UserInfo userinfo = new UserInfo(UserID,FirstName,LastName,Email,Password,UserName);

        UIDBMgr.addUserInfo(userinfo);
        Log.e("Sign Up","Adds New Data");

        FirstnameInput.setText("");
        LastnameInput.setText("");
        EmailInput.setText("");
        PasswordInput.setText("");// Once Input, Fields display Blank
        UsernameInput.setText("");
        Log.e("Sign Up", "Reset Fields to Blank");
        Toast.makeText(getApplicationContext(), "You Have Signed Up!",
                Toast.LENGTH_LONG).show();
        Log.e("Sign Up","Display Toast Messages");
    }

    public void findUserInfo (View view) {
        final MediaPlayer mpButtonClick = MediaPlayer.create(this,R.raw.button_click);
        mpButtonClick.start();
        UserInfoDBMgr UIDBMgr = new UserInfoDBMgr(this, null, null, 1);

        UserInfo userinfo = UIDBMgr.findUserInfo(VerifyUser.getText().toString());

        if (userinfo != null) {
            DBUserName.setText(String.valueOf(userinfo.toString()));
            Toast.makeText(getApplicationContext(), "Found User!",
                    Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(getApplicationContext(), "Sorry, No Match!",
                    Toast.LENGTH_LONG).show();
        }
    }
    public void returnToLogIn (View view){
        final MediaPlayer mpButtonClick = MediaPlayer.create(this,R.raw.button_click);
        mpButtonClick.start();
        Intent LI = new Intent(this, LoginScreen.class);
        this.startActivity(LI);
    }
}
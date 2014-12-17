package com.example.james.gamingnews;

/**
 * Created by James on 15/12/2014.
 */
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class DatabaseActivity extends ActionBarActivity {

    TextView id;
    EditText FirstnameInput;
    EditText LastnameInput ;
    EditText EmailInput;
    EditText PasswordInput;
    EditText UsernameInput;
    DBUserSETGET userDBUserSETGET;
    int UserID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        userDBUserSETGET = new DBUserSETGET();

        id =  (TextView) findViewById(R.id.textView8);
        FirstnameInput = (EditText) findViewById(R.id.FnameInput);
        LastnameInput = (EditText) findViewById(R.id.LnameInput);
        EmailInput = (EditText) findViewById(R.id.EmailInput);
        PasswordInput = (EditText) findViewById(R.id.PasswordInput);
        UsernameInput = (EditText) findViewById(R.id.UsernameInput);

    }

    public void newUser (View view) {
        DBHandler dbHandler = new DBHandler(this, null, null, 1);



        String FirstName = FirstnameInput.getText().toString();
        String LastName = LastnameInput.getText().toString();
        String Email = EmailInput.getText().toString();
        String Password = PasswordInput.getText().toString();
        String UserName = UsernameInput.getText().toString();

        DBUserSETGET DBUsersetget = new DBUserSETGET(UserID,FirstName,LastName,Email,Password,UserName);

        dbHandler.addUserInfo(DBUsersetget);

        FirstnameInput.setText("");
        LastnameInput.setText("");
        EmailInput.setText("");
        PasswordInput.setText("");
        UsernameInput.setText("");




    }

    public void lookupUser (View view) {
        DBHandler dbHandler = new DBHandler(this, null, null, 1);

   DBUserSETGET DBUsersetget = dbHandler.findUserInfo(UsernameInput.getText().toString());

        if (DBUsersetget != null) {
            id.setText(String.valueOf(DBUsersetget.getUserID()));
            UsernameInput.setText(String.valueOf(DBUsersetget.getUserName()));
            Toast.makeText(getApplicationContext(), "Found User!",
                    Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(getApplicationContext(), "Sorry, No Match!",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void removeUser (View view) {
        DBHandler dbHandler = new DBHandler(this, null,
                null, 1);

        boolean result = dbHandler.removeUserInfo(
                UsernameInput.getText().toString());

        if (result)
        {
            id.setText("Record Deleted");
            FirstnameInput.setText("");
            LastnameInput.setText("");
            EmailInput.setText("");
            PasswordInput.setText("");
            UsernameInput.setText("");

            Toast.makeText(getApplicationContext(), "User Deleted",
                    Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Sorry, No Match!",
                    Toast.LENGTH_LONG).show();

    }



}
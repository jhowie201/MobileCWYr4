package com.example.james.gamingnews.mainactivities;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.james.gamingnews.AboutDialogue.AboutDialogue;
import com.example.james.gamingnews.CircDrawing;
import com.example.james.gamingnews.Login.LoginScreen;
import com.example.james.gamingnews.R;
import com.example.james.gamingnews.UserPreferences.SavedPreferences;
import com.example.james.gamingnews.UserPreferences.SavedPrefs;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    SavedPreferences SDPrefs;
    SharedPreferences SharedPref;
    FragmentManager fmAboutDialogue;

    //TextView LoggedInUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SDPrefs = new SavedPreferences(SharedPref);
        SDPrefs.setDefaultPrefs();

        fmAboutDialogue = this.getFragmentManager();
        Log.e("n", "MainActivity RUN");
    }

    public void GoToNews (View view){

        Intent News = new Intent(this, GamingNews.class);
        this.startActivity(News);
    }

   // public void GoToMaps (View view){

      //  Intent Mp = new Intent(this, AppMaps.class);
      //  this.startActivity(Mp);
  //  }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.DrawToCanvas:
                Intent DTC = new Intent (this,CircDrawing.class);
                this.startActivity(DTC);
                return true;
            case R.id.Login:
                Intent intent = new Intent (this,LoginScreen.class);
                this.startActivity(intent);
                return true;
            case R.id.About:
                DialogFragment AboutDlg = new AboutDialogue();
                AboutDlg.show(fmAboutDialogue, "About_Dlg");
                return true;
            case R.id.Saved:
                Intent intent2 = new Intent(this, SavedPrefs.class);
                this.startActivity(intent2);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void onClick (View view){
        setResult(Activity.RESULT_OK);
         finish();


    }
}
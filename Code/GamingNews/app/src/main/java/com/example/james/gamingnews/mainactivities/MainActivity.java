package com.example.james.gamingnews.mainactivities;

import android.app.ActivityGroup;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

import com.example.james.gamingnews.AboutDialogue.AboutDialogue;
import com.example.james.gamingnews.R;
import com.example.james.gamingnews.UserPreferences.SavedPreferences;
import com.example.james.gamingnews.UserPreferences.SavedPrefs;


public class MainActivity extends ActivityGroup implements View.OnClickListener{


    FragmentManager fmAboutDialogue;
    SavedPreferences SDPrefs;
    SharedPreferences SharedPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup(this.getLocalActivityManager());

        TabHost.TabSpec spec1 =tabHost.newTabSpec("News");
        spec1.setIndicator("News");
        Intent GNIntent = new Intent(this,GamingNews.class);

         //spec1.setContent(R.id.tab1);
        //Intent GNIntent = new Intent(this,GamingNews.class);
        spec1.setContent(GNIntent);


        TabHost.TabSpec spec2 =tabHost.newTabSpec("Reviews");
        spec2.setIndicator("Reviews");
        Intent GRIntent = new Intent(this,GamingReviews.class);
      // spec2.setContent(R.id.tab2);
        //Intent GRIntent = new Intent(this,GamingReviews.class);
        spec2.setContent(GRIntent);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);


        SharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SDPrefs = new SavedPreferences(SharedPref);
        SDPrefs.setDefaultPrefs();

        fmAboutDialogue = this.getFragmentManager();
        Log.e("n", "MainActivity RUN");
    }


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
            case R.id.About:
                DialogFragment AboutDlg = new AboutDialogue();
                AboutDlg.show(fmAboutDialogue, "About_Dlg");
                return true;
            case R.id.Saved:
                Intent intent = new Intent(this, SavedPrefs.class);
                this.startActivity(intent);
               // setContentView(R.layout.savedprefs);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void onClick (View view){

         finish();


    }
}
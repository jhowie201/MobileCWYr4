package com.example.james.gamingnews;

import android.app.Activity;
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

import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{


    FragmentManager fmAboutDialogue;
    SavedPreferences SDPrefs;
    SharedPreferences SharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec1 =tabHost.newTabSpec("News");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("News");


        TabHost.TabSpec spec2 =tabHost.newTabSpec("Reviews");
        spec2.setIndicator("Reviews");
        spec2.setContent(R.id.tab2);

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);

       // RSSDataItem userHoroscope = new RSSDataItem();
         //String RSSFeedURL = "http://www.gamespot.com/feeds/news"; //+ starSignInfo.getStarSign();
         //  AsyncRSSParser rssAsyncParse = new AsyncRSSParser(this,RSSFeedURL);

        // try {
        //  userHoroscope = rssAsyncParse.execute("").get();
        //  }catch (InterruptedException e){
       //  e.printStackTrace();
      //  }catch (ExecutionException e){
          //   e.printStackTrace();
       //   }


        SharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SDPrefs = new SavedPreferences(SharedPref);
        SDPrefs.setDefaultPrefs();

        fmAboutDialogue = this.getFragmentManager();
        Log.e("n", "message");
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
        Intent myIntent = new Intent(MainActivity.this, SavedPrefs.class);
        MainActivity.this.startActivity(myIntent);

    }
}
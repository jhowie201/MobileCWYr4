package com.example.james.gamingnews.mainactivities;


import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.james.gamingnews.AboutDialogue.AboutDialogue;
import com.example.james.gamingnews.CircDrawing;
import com.example.james.gamingnews.Data.RSSDataItem;
import com.example.james.gamingnews.Data.RSSReader;
import com.example.james.gamingnews.Listeners.ListenerGN;
import com.example.james.gamingnews.Login.LoginScreen;
import com.example.james.gamingnews.R;
import com.example.james.gamingnews.UserPreferences.SavedPrefs;
/**
 * Created by James on 13/12/2014.
 */
public class GamingNews extends ActionBarActivity {
    EditText inputSearch;
    Button refresh;
    int count;
    FragmentManager fmAboutDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamingnews);
        fmAboutDialogue = this.getFragmentManager();
        try {
           RSSFeed();
            Log.e("n", "RSSFeed First RUN");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        refresh = (Button) findViewById(R.id.refresh); //Refreshes RSS Feed

        refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    RSSFeed();
                    Toast.makeText(getApplicationContext(), "RSS Feed Has Been Updated", //Gives Feedback on Refresh
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
         });}

    public void RSSFeed() throws Exception{ //Gets RSS FEED Data

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RSSReader Rssreader = new RSSReader ("http://www.gamespot.com/feeds/news/"); //RSS FEED BEING PARSED
        ListView Item = (ListView)findViewById(R.id.listView3);
        final ArrayAdapter <RSSDataItem> adapter = new ArrayAdapter <> (this,R.layout.custom_list_item, Rssreader.getItems());
        Item.setAdapter(adapter);
        Item.setOnItemClickListener(new ListenerGN(Rssreader.getItems(), this));
        count =	Item.getCount(); //COUNTS ITEMS IN LISTVIEW

        Log.e("n","Number of Items in RSS FEED: " + count); //Logcat Items in ListView



        inputSearch = (EditText) findViewById(R.id.TitleSearch); //Used to Filter ListView Results
        inputSearch.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text

                adapter.getFilter().filter(cs); }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

        });

    }

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
 }



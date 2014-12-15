package com.example.james.gamingnews.mainactivities;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.james.gamingnews.Data.RSSDataItem;
import com.example.james.gamingnews.Data.RSSHandler;
import com.example.james.gamingnews.Data.RSSReader;
import com.example.james.gamingnews.Listeners.ListenerGN;
import com.example.james.gamingnews.R;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by James on 13/12/2014.
 */
public class GamingNews extends Activity {
    EditText inputSearch;
    Button refresh;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamingnews);
        try {
           RSSFeed();
            Log.e("n", "RSSFeed First RUN");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Context context = getApplicationContext();
                CharSequence text = "Updating RSS FEED....";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                try {
                    RSSFeed();
                    toast.show();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
         });}
    public void RSSFeed() throws Exception{

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RSSReader Rssreader = new RSSReader ("http://www.gamespot.com/feeds/news/");
        ListView Item = (ListView)findViewById(R.id.listView3);
        final ArrayAdapter <RSSDataItem> adapter = new ArrayAdapter <> (this,R.layout.custom_list_item, Rssreader.getItems());
        Item.setAdapter(adapter);
        Item.setOnItemClickListener(new ListenerGN(Rssreader.getItems(), this));
        count =	Item.getCount();

        Log.e("n","Number of Items in RSS FEED: " + count);



        inputSearch = (EditText) findViewById(R.id.TitleSearch);
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




    }



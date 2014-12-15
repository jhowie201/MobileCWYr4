package com.example.james.gamingnews.SplashScreen;
//<!--James Howie S1310206-->

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;

import com.example.james.gamingnews.Data.RSSDataItem;
import com.example.james.gamingnews.Data.RSSHandler;
import com.example.james.gamingnews.mainactivities.MainActivity;
import com.example.james.gamingnews.R;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SplashScreen extends Activity {
    private Intent myintent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        myintent = new Intent(this, MainActivity.class);
        splashScreen(3000); }

    public void splashScreen (final int x)
    {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(myintent);
                finish();
            }
        }).start();
    }



    }
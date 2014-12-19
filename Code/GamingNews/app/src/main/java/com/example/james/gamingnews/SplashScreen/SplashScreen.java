package com.example.james.gamingnews.SplashScreen;
//<!--James Howie S1310206-->

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.example.james.gamingnews.mainactivities.MainActivity;
import com.example.james.gamingnews.R;

//Used Import Statements

//JAMES HOWIE S1310206 MUC GamingNews Application!

public class SplashScreen extends Activity {
    private Intent myintent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash); //View which splash screen displays

        myintent = new Intent(this, MainActivity.class);
        splashScreen(3000); } //Time Splash Screen is displayed for

    public void splashScreen (final int x)
    {
        new Thread(new Runnable() { //Thread to Run Splash Screen
            public void run() {
                try {
                    Thread.sleep(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(myintent); //Start Activity
                finish();
            }
        }).start();
    }
 }
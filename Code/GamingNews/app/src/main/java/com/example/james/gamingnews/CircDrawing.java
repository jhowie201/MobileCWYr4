package com.example.james.gamingnews;

import android.app.Activity;
import android.os.Bundle;

import com.example.james.gamingnews.Canvas.DrawingView;


/**
 * Created by James on 16/12/2014.
 */
public class CircDrawing extends Activity {
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(new DrawingView(this));


    }
}

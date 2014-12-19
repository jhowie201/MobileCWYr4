package com.example.james.gamingnews.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

//User Import Statements

//JAMES HOWIE S1310206 MUC GamingNews Application!
/**
 * Created by James on 16/12/2014.
 */
public class DrawingView extends View {
    Paint paint = new Paint(); //Preallocated paint

    public DrawingView(Context context){
        super(context);
    }

    public DrawingView(Context context, AttributeSet attrs){
        super(context, attrs);

    }

    public DrawingView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);

    }

@Override
    protected void onDraw (Canvas canvas){
        super.onDraw(canvas);
    canvas.drawCircle(150, 150, 100, paint); //Sets out Circle Parameters
    }
}

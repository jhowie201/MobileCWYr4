package com.example.james.gamingnews.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by James on 16/12/2014.
 */
public class DrawingView extends View {
    Paint paint = new Paint(); //Preallocated

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
   // paint.setColor(getResources().getColor(R.color.RED));
    canvas.drawCircle(150, 150, 100, paint);
    }
}

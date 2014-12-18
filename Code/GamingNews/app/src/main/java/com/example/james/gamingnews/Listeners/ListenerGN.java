package com.example.james.gamingnews.Listeners;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.example.james.gamingnews.Data.RSSDataItem;
import com.example.james.gamingnews.R;
import java.util.List;

/**
 * Created by James on 14/12/2014.
 */
public class ListenerGN implements AdapterView.OnItemClickListener {
    //List items reference
    List<RSSDataItem> listItems;
    // Calling activity reference
    Activity activity;


    public ListenerGN(List<RSSDataItem> aListItems, Activity anActivity) {
        listItems = aListItems;
        activity = anActivity;
    }

    public String removeAllHtmlTags(String inStr) {
        int index=0;
        int index2=0;
        while(index!=-1)
        {
            index = inStr.indexOf("<");
            index2 = inStr.indexOf(">", index);
            if(index!=-1 && index2!=-1){
                inStr = inStr.substring(0, index).concat(inStr.substring(index2+1, inStr.length()));
            }
        }
        return inStr;
    }

    @SuppressLint("SimpleDateFormat")
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        String show;
        String disTag;

        RSSDataItem item = listItems.get(pos);

        disTag = item.getItemDesc();

        disTag = removeAllHtmlTags(disTag);

        final Dialog d = new Dialog(activity);
        d.setContentView(R.layout.dialog);
        TextView tv = new TextView(activity);
        tv.setMovementMethod(new ScrollingMovementMethod());
        show =  disTag.substring(disTag.lastIndexOf("00:00") + 5);
        tv.setText(show);
        d.getWindow().setLayout(1000, 1800);
        d.addContentView(tv, new ViewGroup.LayoutParams(-1, -1));
        d.setTitle("Additional Information");
         d.show();
    }

}






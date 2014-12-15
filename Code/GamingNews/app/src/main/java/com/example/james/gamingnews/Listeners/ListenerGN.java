package com.example.james.gamingnews.Listeners;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.james.gamingnews.Data.RSSDataItem;
import com.example.james.gamingnews.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    @SuppressLint("SimpleDateFormat")
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        String show;
        String disTag;
      //  String titletag;
        RSSDataItem item = listItems.get(pos);

        disTag = item.getItemDesc();
      //  titletag = item.getItemTitle();

        disTag = removeBr(disTag);
        disTag = removeBr2(disTag);
        disTag = removeBr3(disTag);
        disTag = removeP(disTag);
        disTag = removeP2(disTag);
        disTag = removeP3(disTag);
        disTag = removeP4(disTag);
        disTag = removeEx(disTag);


        final Dialog d = new Dialog(activity);

        d.setContentView(R.layout.dialog);
        TextView tv = new TextView(activity);


        show =  disTag.substring(disTag.lastIndexOf("00:00") + 5);


        tv.setText(show);

        d.getWindow().setLayout(1000, 1800);
        d.addContentView(tv, new ViewGroup.LayoutParams(-1, -1));

        d.setTitle("Additional Information");

        d.show();
    }


    private String removeBr(String str1){
        return str1.replaceAll("<br />", " ");
    }

    private String removeBr3(String str1){
        return str1.replaceAll("<br/>", " ");
    }
    private String removeBr2(String str1){
        return str1.replaceAll(">br/<", " ");
    }
    private String removeP(String str1){
        return str1.replaceAll(">/p<", "");

    }
    private String removeP2(String str1){
        return str1.replaceAll(">p<", "");
    }
    private String removeP3(String str1){
        return str1.replaceAll("</p><p>&nbsp;</p>", "");
    }
    private String removeP4(String str1){
        return str1.replaceAll("<p>", "");
    }
    private String removeEx(String str1){
        return str1.replaceAll("nbsp;&", "");
    }
}






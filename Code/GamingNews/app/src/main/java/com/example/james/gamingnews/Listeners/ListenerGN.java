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
//JAMES HOWIE S1310206 MUC GamingNews Application!
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

    public String removeAllHtmlTags(String inStr) { //Used to Remove all HTML Tags from the Dialog Box
        //Removes Instances of < > Tags
        int ind=0;
        int ind2=0;
        while(ind!=-1)
        {
            ind = inStr.indexOf("<");
            ind2 = inStr.indexOf(">", ind);
            if(ind!=-1 && ind2!=-1){
                inStr = inStr.substring(0, ind).concat(inStr.substring(ind2+1, inStr.length()));
            }
        }
        return inStr;
    }



    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) { //Used to Display Dialog Box when ListView Item is Clicked
        String show;
        String disTag;

        RSSDataItem item = listItems.get(pos);

        disTag = item.getItemDesc();

        disTag = removeAllHtmlTags(disTag); //Runs DisTag Through HTML TAG REMOVAL METHOD

        final Dialog d = new Dialog(activity);
        d.setContentView(R.layout.dialog);//Sets Content View of Custom Dialog Box
        TextView tv = new TextView(activity);
        tv.setMovementMethod(new ScrollingMovementMethod()); //Allows Scrolling
        show =  disTag.substring(disTag.lastIndexOf("00:00") + 5);
        tv.setText(show);
        d.getWindow().setLayout(1000, 1800); //Parameters of Dialog Box
        d.addContentView(tv, new ViewGroup.LayoutParams(-1, -1));
        d.setTitle("Additional Information"); //Title of Dialog Box
         d.show(); //Shows Dialog Box
    }

}






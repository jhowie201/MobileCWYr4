package com.example.james.gamingnews.Data;

//JAMES HOWIE S1310206 MUC GamingNews Application!
/**
 * Created by James on 13/12/2014.
 */
public class RSSDataItem {
    // *********************************************
    // Declare variables etc.
    // *********************************************
    private String itemTitle; //Sets Strings in RSS Feed
    private String itemDesc;
    // *********************************************
    // Declare getters and setters etc.
    // *********************************************
    public String getItemTitle() {
        return this.itemTitle;
    }
    public void setItemTitle(String sItemTitle) {
        this.itemTitle = sItemTitle;
    }
    public String getItemDesc() {
        return this.itemDesc;
    }
    public void setItemDesc(String sItemDesc) {
        this.itemDesc = sItemDesc;
    }
 // **************************************************
 // Declare constructor.                            **
 // **************************************************
    public RSSDataItem()
    {
        this.itemTitle = "";
        this.itemDesc = "";
    }
    @Override
    public String toString() {
        String GamingNewsRSSData;
        GamingNewsRSSData =  itemTitle; //Title to be used in ListView Item
        return GamingNewsRSSData;
    }
}




package com.example.james.gamingnews;

import java.io.Serializable;

/**
 * Created by James on 13/12/2014.
 */
public class RSSDataItem {

     // *********************************************
     // Declare variables etc.
     // *********************************************

     private String itemTitle;
     private String itemDesc;
     private String itemLink;

             // *********************************************
             // Declare getters and setters etc.
             // *********************************************

             public String getItemTitle()
    {
        return this.itemTitle;
    }

             public void setItemTitle(String sItemTitle)
     {
        this.itemTitle = sItemTitle;
     }

             public String getItemDesc()
     {
         return this.itemDesc;
     }

             public void setItemDesc(String sItemDesc)
     {
         this.itemDesc = sItemDesc;
     }

             public String getItemLink()
     {
         return this.itemLink;
     }

             public void setItemLink(String sItemLink)
     {
        this.itemLink = sItemLink;
     }


 // **************************************************
 // Declare constructor.
 // **************************************************

             public void mcRSSDataItem() /////CHANGED TO VOID!!!
     {
         this.itemTitle = "";
         this.itemDesc = "";
         this.itemLink = "";
     }

 @Override
     public String toString() {
         String GamingNewsRSSData;
     GamingNewsRSSData = "mcRSSDataItem [itemTitle=" + itemTitle;
     GamingNewsRSSData = ", itemDesc=" +itemDesc;
     GamingNewsRSSData = ", itemLink=" +itemLink +"]";
         return GamingNewsRSSData;
     }

     }



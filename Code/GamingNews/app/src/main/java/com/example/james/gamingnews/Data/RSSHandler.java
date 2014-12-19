package com.example.james.gamingnews.Data;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

//Used Import Statements

//JAMES HOWIE S1310206 MUC GamingNews Application!
/**
 * Created by James on 14/12/2014.
 */
public class RSSHandler extends DefaultHandler {
    private List<RSSDataItem> RssItems; //Declares List of Items
    private RSSDataItem currentItem; //Declares Current Item
    private boolean parsingTitle;
    private boolean parsingDescription; //Declares Variables
    String strTitle;
    public RSSHandler(){
        RssItems = new ArrayList <>();
    }
    public List<RSSDataItem> getItems()
    {
        return RssItems;//returns Items
    }
    @Override
    public void startElement(String uri,String localName, String qName, Attributes attributes) throws SAXException { //Finds Beginning of Tag
        if ("item".equals(qName))  //Start of Item Tag
        {
           currentItem = new RSSDataItem();
        }
        if ("title".equals(qName)) //Start of Title Tag
        {
           parsingTitle = true;
        }
        if(localName.equals("description")) //Start of Description Tag
        {
           parsingDescription = true;
        }
    }

    @Override
    public void endElement(String uri,String localName, String qName) throws SAXException { //Find End of Tag
        if (localName.equalsIgnoreCase("br")){ //Ignores Br Tags
            throw new SAXException();
        }
        if ("item".equals(qName)) { //End of Item tag
            RssItems.add(currentItem);
            currentItem = null;
        }
        if ("title".equals(qName)) {//End of Title Tag
            parsingTitle = false;
            strTitle = "";
        }
        if(localName.equals("description")) { //End of Description Tag
            parsingDescription = false;
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
   if (currentItem != null){
        if (parsingTitle) {
                strTitle = strTitle + new String(ch, start, length); //Parses Title for ListView
                currentItem.setItemTitle(strTitle);
            }
            if(parsingDescription) {
                String sItemDesc = new String(ch, start, length); //Parses Description for Dialog Box
                if(currentItem.getItemDesc() != null) { //If Current item is not Null Then Add Description
                    String curDec = currentItem.getItemDesc();
                    currentItem.setItemDesc(curDec + sItemDesc);
                } else {
                    currentItem.setItemDesc(sItemDesc); //else do not add description
                }
            }
        }
    }
}


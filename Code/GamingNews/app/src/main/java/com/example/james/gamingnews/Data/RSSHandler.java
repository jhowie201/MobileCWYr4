package com.example.james.gamingnews.Data;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 14/12/2014.
 */
public class RSSHandler extends DefaultHandler {

    private List<RSSDataItem> RssItems;
    private RSSDataItem currentItem;
    private boolean parsingTitle;
    private boolean parsingDescription;
    String strTitle;



    public RSSHandler(){
        RssItems = new ArrayList <>();
    }

    public List<RSSDataItem> getItems(){
        return RssItems;
    }

    @Override
    public void startElement(String uri,String localName, String qName, Attributes attributes) throws SAXException {

        if ("item".equals(qName)) {
            currentItem = new RSSDataItem();
        }
        if ("title".equals(qName))
         {
            parsingTitle = true;
        }

        if(localName.equals("description")) {

            parsingDescription = true;
        }

    }

    @Override
    public void endElement(String uri,String localName, String qName) throws SAXException {

        if (localName.equalsIgnoreCase("br")){
            throw new SAXException();
        }

        if ("item".equals(qName)) {
            RssItems.add(currentItem);
            currentItem = null;
        }

        if ("title".equals(qName)) {
            parsingTitle = false;
            strTitle = "";
        }

        if(localName.equals("description")) {
            parsingDescription = false;

        }


    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

   if (currentItem != null){
        if (parsingTitle) {
                strTitle = strTitle + new String(ch, start, length);
                currentItem.setItemTitle(strTitle);
            }
            if(parsingDescription) {
                String sItemDesc = new String(ch, start, length);
                if(currentItem.getItemDesc() != null) {
                    String curDec = currentItem.getItemDesc();
                    currentItem.setItemDesc(curDec + sItemDesc);
                } else {
                    currentItem.setItemDesc(sItemDesc);
                }
            }
        }
    }
}


package com.example.james.gamingnews.Data;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
//Used Import Statements!

//JAMES HOWIE S1310206 MUC GamingNews Application!
/**
 * Created by James on 14/12/2014.
 */
public class RSSReader {
     String rssUrl = "http://www.gamespot.com/feeds/news/"; //RSS FEED URL BEING PARSED!

    public RSSReader (String rssUrl){
       this.rssUrl = rssUrl;
    }
    public List<RSSDataItem> getItems()  throws Exception{

        SAXParserFactory factory = SAXParserFactory.newInstance(); //Initiates instance of Sax Parser

        SAXParser saxParser = factory.newSAXParser();

        RSSHandler handler = new RSSHandler (); //Instance of handler Class

        saxParser.parse(rssUrl, handler);

        return handler.getItems(); //returns Items

    }
}

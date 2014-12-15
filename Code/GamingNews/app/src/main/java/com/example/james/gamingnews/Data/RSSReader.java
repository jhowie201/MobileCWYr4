package com.example.james.gamingnews.Data;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by James on 14/12/2014.
 */
public class RSSReader {
     String rssUrl = "http://www.gamespot.com/feeds/news/";

    public RSSReader (String rssUrl){
       this.rssUrl = rssUrl;
    }
    public List<RSSDataItem> getItems()  throws Exception{

        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser saxParser = factory.newSAXParser();

        RSSHandler handler = new RSSHandler ();

        saxParser.parse(rssUrl, handler);

        return handler.getItems();

    }
}

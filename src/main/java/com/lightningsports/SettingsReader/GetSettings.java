package com.lightningsports.SettingsReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class GetSettings extends DefaultHandler {
    private AppKey appKey;
    private ArrayList currentKeyList;
    private Logger logger;

    public GetSettings() {
        this.logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public AppKey readSettings(String fileName) {
        try {
            DefaultHandler handler = new GetSettings();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse( new File(fileName), handler);
            return ((GetSettings) handler).getAppKey();
        } catch (ParserConfigurationException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            logger.severe(e.toString());
            return (AppKey) null;
        } catch (SAXException e) {
            logger.severe(e.toString());
            return (AppKey) null;
        } catch (IOException e) {
            logger.severe(e.toString());
            return (AppKey) null;
        }
    }

    public AppKey getAppKey() {
        return appKey;
    }

    public void startDocument() throws SAXException {
        currentKeyList =new ArrayList();
        super.startDocument();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public void endDocument() throws SAXException {
        super.endDocument();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if ("settings".equals(qName.toLowerCase())) {
            appKey=new AppKey(qName,attributes);
            currentKeyList.add(appKey);
        } else {
            currentKeyList.add(((AppKey) currentKeyList.get(currentKeyList.size()-1)).findKey(qName,attributes));
        }
        super.startElement(uri, localName, qName, attributes);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentKeyList.remove(currentKeyList.size()-1);
        super.endElement(uri, localName, qName);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (s.length()>0) {
            ((AppKey) currentKeyList.get(currentKeyList.size()-1)).addValue(s);
        }
        super.characters(ch, start, length);    //To change body of overridden methods use File | Settings | File Templates.
    }
}

package com.example.getxml;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class NewsService {

	public static List<News> getLastNews() throws Exception{
		String path = "http://104.160.32.106/test3.xml";
		HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() == 200)
		{
			InputStream xml = conn.getInputStream();
			return parseXML(xml);
		}
		return null;
	}

	private static List<News> parseXML(InputStream xml) throws Exception{
		// TODO Auto-generated method stub
		List<News> newes = null;
		News news = null;
		XmlPullParser pullParser = Xml.newPullParser();
		pullParser.setInput(xml, "UTF-8");
		int event = pullParser.getEventType();
		while(event != XmlPullParser.END_DOCUMENT){
			switch (event){
			case XmlPullParser.START_DOCUMENT:
				newes = new ArrayList<News>();
				break;
			case XmlPullParser.START_TAG:
				if("news".equals(pullParser.getName()))
				{
					int id = new Integer(pullParser.getAttributeValue(0));
					news = new News();
					news.setId(id);
				}
				if("title".equals(pullParser.getName()))
				{
					news.setTitle(pullParser.nextText());
				}
				if("timelength".equals(pullParser.getName()))
				{
					news.setTimelength(new Integer(pullParser.nextText()));
				}
				break;
			case XmlPullParser.END_TAG:
				if("news".equals(pullParser.getName()))
				{
					newes.add(news);
					news = null;
				}
				break;
			}
			event = pullParser.next();
		}
		return newes;
	}
	
	
}

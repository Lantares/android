package com.example.getcodeplus;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.example.getcodeplus.StreamTool;

public class UserInfo {

	public static String save(String name, String age) throws Exception{
		// TODO Auto-generated method stub
		String url = "http://104.160.32.106/test5.php";
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("name", name);
		params.put("age", age);
		
		return sendGETS(url, params, "UTF-8");
	}

	private static String sendGETS(String url, Map<String, String> params,
			String encoding) throws Exception{
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder(url);
		if(params!=null && !params.isEmpty())
		{
			sb.append("?");
			for(Map.Entry<String, String> entry : params.entrySet())
			{
				sb.append(entry.getKey()).append("=");
				sb.append(URLEncoder.encode(entry.getValue(), encoding));
				sb.append("&");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		
		HttpURLConnection conn = (HttpURLConnection) new URL(sb.toString()).openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() == 200)
		{
			InputStream inStream = conn.getInputStream();
			byte[] data = StreamTool.read(inStream);
			return new String(data);
		}
		return null;
	}

	
}

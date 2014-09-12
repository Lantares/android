package com.example.post;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.example.post.StreamTool;

public class UserInfo {

	public static String save(String name, String age) throws Exception{
		// TODO Auto-generated method stub
		String url = "http://104.160.32.106/test6.php";
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("name", name);
		params.put("age", age);
		
		return sendPOST(url, params, "UTF-8");
	}

	private static String sendPOST(String url, Map<String, String> params,
			String encoding) throws Exception{
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		if(params!=null && !params.isEmpty())
		{
			for(Map.Entry<String, String> entry : params.entrySet())
			{
				sb.append(entry.getKey()).append("=");
				sb.append(URLEncoder.encode(entry.getValue(), encoding));
				sb.append("&");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		byte[] data = sb.toString().getBytes();
		
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", (data.length)+"");
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(data);
		outputStream.flush();
		if(conn.getResponseCode() == 200)
		{
			InputStream inStream = conn.getInputStream();
			byte[] bufdata = StreamTool.read(inStream);
			return new String(bufdata);
		}
		return null;
	}

	
}

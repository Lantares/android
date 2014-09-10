package com.example.getimg;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageSerice {

	public static Bitmap getImage(String path) throws Exception{
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() == 200)
		{
			InputStream inStream = conn.getInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(inStream);
			return bitmap;
		}
		return null;
	}
}

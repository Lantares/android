package com.example.getxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ActionBarActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView = (ListView)findViewById(R.id.listView);
		
		String length = "lengh";
		try{
			List<News> newes = NewsService.getLastNews();
			List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
			
			for(News news : newes)
			{
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("id", news.getId());
				item.put("title", news.getTitle());
				item.put("timelength", length + news.getTimelength());
				data.add(item);
			}
			SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item, new String[]{
					"title", "timelength"}, new int[]{R.id.title, R.id.timelength});
			listView.setAdapter(adapter);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

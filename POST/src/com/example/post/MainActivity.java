package com.example.post;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	
	private EditText Ename;
	private EditText Eage;
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Ename = (EditText)findViewById(R.id.name);
		Eage = (EditText)findViewById(R.id.age);
		textView = (TextView)findViewById(R.id.textView);
		
	}
	
	public void save(View v)
	{
		String name = Ename.getText().toString();
		String age = Eage.getText().toString();
		
		try
		{
			String result;
			result = UserInfo.save(name, age);
			if(result != null)
			{
				Toast.makeText(this, "success", 1).show();
				textView.setText(result);
			}
			else
			{
				Toast.makeText(this, "fail", 1).show();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Toast.makeText(this, e.toString(), 1).show();
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

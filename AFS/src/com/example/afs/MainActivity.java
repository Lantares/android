package com.example.afs;

import java.io.File;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends ActionBarActivity {
	
	private Button mButton;
	private EditText mKeyWord;
	private TextView mResult;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mButton = (Button)findViewById(R.id.button1);
		mKeyWord = (EditText)findViewById(R.id.editText1);
		mResult = (TextView)findViewById(R.id.textView1);
		
		mButton.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String keyword = mKeyWord.getText().toString();
				if(keyword.equals(""))
				{
					mResult.setText("cant not be empty");
				}
				else
				{
					mResult.setText(SF(keyword));
				}
			}
			
		});
	}
	
	private String SF(String keyword)
	{
		String result = "";
		File[] files = new File("/").listFiles();
		for( File f : files)
		{
			if (f.getName().indexOf(keyword) >= 0)
			{
				result += f.getPath()+"\n";
			}
		}
		
		if(result.equals(""))
			result = "cant find file";
		
		return result;
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

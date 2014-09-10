package com.example.aclock;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.os.*;
import java.lang.Thread;
import java.util.Calendar;

import android.os.Message;

public class MainActivity extends ActionBarActivity {

		
	protected static final int GUINOTIFIER = 0x1234;
	
	private TextView mTextView;
	private TextView YMDTextView;
	
	public AnalogClock mAnalogClock;
	
	public Handler mHandler;
	public Thread mClockThread;
	
	public Calendar mCalendar;
	public int mMinutes;
	public int mHour;
	public int mS;
	

	
	 java.text.DecimalFormat df = new java.text.DecimalFormat("00");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTextView = (TextView)findViewById(R.id.textView1);
		
		mAnalogClock = (AnalogClock)findViewById(R.id.analogClock1);
		
		mHandler = new Handler()
		{
			public void handleMessage(Message msg)
			{
				switch (msg.what)
				{
				case MainActivity.GUINOTIFIER:
					
					mTextView.setText(df.format(mHour) + " : " + df.format(mMinutes) + " : " + df.format(mS));
					
					break;
				}
				super.handleMessage(msg);
			}
		};
		
		mClockThread = new LooperThread();
		mClockThread.start();
		
	}
	
	class LooperThread extends Thread
	{
		public void run()
		{
			super.run();
			try
			{
				do
				{
					long time = System.currentTimeMillis();
					
					final Calendar mCalendar = Calendar.getInstance();
					mCalendar.setTimeInMillis(time);
					
					
					mHour = mCalendar.get(Calendar.HOUR);
					mMinutes = mCalendar.get(Calendar.MINUTE);
					mS = mCalendar.get(Calendar.SECOND);
					Thread.sleep(1000);
					
					Message m = new Message();
					m.what = MainActivity.GUINOTIFIER;
					MainActivity.this.mHandler.sendMessage(m);
				}while(MainActivity.LooperThread.interrupted()==false);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
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

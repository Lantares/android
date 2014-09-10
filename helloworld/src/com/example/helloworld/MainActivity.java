package com.example.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button; 
import android.widget.Toast;
import android.view.*;
import android.content.SharedPreferences;
import android.content.*;
import android.widget.*;


public class MainActivity extends ActionBarActivity {
	
	private SharedPreferences sharedPref;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//ADD TO STUDY
		
		sharedPref = this.getSharedPreferences("com.example.helloworld", 
                Context.MODE_PRIVATE);
		
		Button btn = (Button)findViewById(R.id.author);
		btn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view){
				Intent intent = new Intent(MainActivity.this, SelfEdit.class);
                MainActivity.this.startActivity(intent);
			}
		
		});
		
		//END
		
	}
	
	protected void onResume() {
        super.onResume();
        TextView nameView = (TextView) findViewById(R.id.welcome);
        
        // retrieve content from shared preference, with key "name"
        String   welcome  = "Welcome, " + sharedPref.getString("name", "unknown") + "!";
        nameView.setText(welcome);
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

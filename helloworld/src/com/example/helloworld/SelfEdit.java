package com.example.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.content.*;
import android.view.*;

public class SelfEdit extends ActionBarActivity {
	
	//ADD
	private EditText nameInput;
    private EditText urlInput;
    private TextView tvSubmit;
    
    private SharedPreferences sharedPref;
    
    //END
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_self_edit);
		
		//ADD
		// find views
        tvSubmit   = (TextView) findViewById(R.id.submit);
        nameInput  = (EditText) findViewById(R.id.name);
        urlInput   = (EditText) findViewById(R.id.url);
        
        sharedPref = this.getSharedPreferences("com.example.helloworld", 
                Context.MODE_PRIVATE);
        
        // submit
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String url  = urlInput.getText().toString();

                // Save to Shared Preferences
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("name", name);
                editor.putString("url", url);
                editor.commit();

                // End Current Activity
                SelfEdit.this.finish();
                
            }
        });
        
        //END
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.self_edit, menu);
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

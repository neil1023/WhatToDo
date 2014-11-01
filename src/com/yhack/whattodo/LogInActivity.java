package com.yhack.whattodo;

import com.firebase.client.Firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LogInActivity extends Activity {

	public static Firebase myFirebaseRef;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Firebase.setAndroidContext(this);
		myFirebaseRef = new Firebase("https://whattodo1031.firebaseio.com/");
		setContentView(R.layout.activity_log_in);
	}
	
	public void goBack(View view){
    	Intent intent = new Intent(this, MainActivity.class);
    	
    	startActivity(intent);
    }
	
	public void logInUser(View view){
		
		TextView tvUserName= (TextView) findViewById(R.id.Username);
		String userName = tvUserName.getText().toString();
		
		TextView tvPassword= (TextView) findViewById(R.id.Password);
		String password = tvPassword.getText().toString();
		
		Intent i = new Intent(this, ListActivity.class);
		Bundle extra = new Bundle();
		extra.putString("userName", userName);
		i.putExtra("bundle", extra);
		startActivity(i);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
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

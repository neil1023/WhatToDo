package com.yhack.whattodo;

import com.firebase.client.Firebase;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LogInActivity extends ActionBarActivity {

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
		
		TextView tvUserName= (TextView) view.findViewById(R.id.Username);
		String userName = tvUserName.getText().toString();
		
		TextView tvPassword= (TextView) view.findViewById(R.id.Password);
		String password = tvPassword.getText().toString();
		
		
		
		Intent intent = new Intent(this, MainActivity.class);
		
		startActivity(intent);
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

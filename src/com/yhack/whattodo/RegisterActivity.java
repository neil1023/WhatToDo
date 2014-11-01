package com.yhack.whattodo;

import com.firebase.client.Firebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends Activity {

	public static Firebase myFirebaseRef;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Firebase.setAndroidContext(this);
		myFirebaseRef = new Firebase("https://whattodo1031.firebaseio.com/");
		setContentView(R.layout.activity_register);
	}

	public void register(View view){
		
		TextView tvFirstName= (TextView) view.findViewById(R.id.FirstName);
		String FirstName = tvFirstName.getText().toString();
		
		TextView tvLastName= (TextView) view.findViewById(R.id.LastName);
		String LastName = tvLastName.getText().toString();
		
		TextView tvUserName= (TextView) view.findViewById(R.id.username);
		String UserName = tvUserName.getText().toString();
		
		TextView tvPassword= (TextView) view.findViewById(R.id.password);
		String password = tvPassword.getText().toString();
		
		myFirebaseRef.child("users").setValue(UserName);
		myFirebaseRef.child("users").child(UserName).child("FirstName").setValue(FirstName);
		myFirebaseRef.child("users").child(UserName).child("LastName").setValue(LastName);
		myFirebaseRef.child("users").child(UserName).child("UserName").setValue(UserName);
		myFirebaseRef.child("users").child(UserName).child("Password").setValue(password);
		//Intent intent = new Intent(this, MainActivity.class);
    	
    	//startActivity(intent);
	}
	
	public void goBack(View view){
    	Intent intent = new Intent(this, MainActivity.class);
    	
    	startActivity(intent);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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

package com.android.rockband;

import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class RockBandInfo extends Activity implements OnTouchListener, OnClickListener {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.welcome);
        
        Button dlcButton = (Button) findViewById(R.id.dlcButton);
        Button searchButton = (Button) findViewById(R.id.scoresButton);
        
        dlcButton.setOnTouchListener(this);
        dlcButton.setOnClickListener(this);
        searchButton.setOnTouchListener(this);
        searchButton.setOnClickListener(this);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_menu, menu);
    	return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.quit:
    		quit();
    		return true;
    	case R.id.properties:
    		Intent propertiesIntent = new Intent();
    		propertiesIntent.setClass(RockBandInfo.this, Preferences.class);
    		startActivity(propertiesIntent);
    		return true;
    	}
    	return false;
    }
    
	public boolean onTouch(View v, MotionEvent event) {
		switch (v.getId()) {
		case R.id.dlcButton:
			if(event.getAction() == MotionEvent.ACTION_UP) {
				Intent dlcIntent = new Intent();
				dlcIntent.setClass(RockBandInfo.this, DLCSearch.class);
				startActivity(dlcIntent);
				return true;
			}
		case R.id.scoresButton:
			if(event.getAction() == MotionEvent.ACTION_UP) {
				Intent scoresIntent = new Intent();
				scoresIntent.setClass(RockBandInfo.this, LeaderboardSearch.class);
				startActivity(scoresIntent);
				return true;
			}
		}
		return false;
	}
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dlcButton:
			Intent dlcIntent = new Intent();
			dlcIntent.setClass(RockBandInfo.this, DLCSearch.class);
			startActivity(dlcIntent);
			return;
		case R.id.scoresButton:
			Intent scoresIntent = new Intent();
			scoresIntent.setClass(RockBandInfo.this, LeaderboardSearch.class);
			startActivity(scoresIntent);
			return;
		}
	}
	
	private void quit() {
    	this.finish();
    }
}
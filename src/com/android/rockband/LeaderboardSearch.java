package com.android.rockband;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class LeaderboardSearch extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_menu, menu);
	   	menu.removeItem(R.id.quit);
    	return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.properties:
    		Intent propertiesIntent = new Intent();
    		propertiesIntent.setClass(LeaderboardSearch.this, Preferences.class);
    		startActivity(propertiesIntent);
    		return true;
    	}
    	return false;
    }
}
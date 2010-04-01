package com.android.rockband;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

public class LeaderboardSearch extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		
		Resources res = getResources();
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		intent = new Intent().setClass(this, WiiScoreSearch.class);
		spec = tabHost.newTabSpec("ic_tab_wii").setIndicator("Wii", res.getDrawable(R.drawable.ic_tab_wii)).setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this, XboxScoreSearch.class);
		spec = tabHost.newTabSpec("ic_tab_360").setIndicator("360", res.getDrawable(R.drawable.ic_tab_360)).setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this, Ps3ScoreSearch.class);
		spec = tabHost.newTabSpec("ic_tab_ps3").setIndicator("PS3", res.getDrawable(R.drawable.ic_tab_ps3)).setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTabByTag("ic_tab_wii");
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
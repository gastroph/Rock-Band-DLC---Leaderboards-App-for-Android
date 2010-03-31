package com.android.rockband;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

public class DLCSearch extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		
		Resources res = getResources();
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		intent = new Intent().setClass(this, RB2DLCSearch.class);
		spec = tabHost.newTabSpec("ic_tab_rb2").setIndicator("RB2", res.getDrawable(R.drawable.ic_tab_rb2)).setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this, TBRBDLCSearch.class);
		spec = tabHost.newTabSpec("ic_tab_tbr").setIndicator("TB:RB", res.getDrawable(R.drawable.ic_tab_tbr)).setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this, RBNDLCSearch.class);
		spec = tabHost.newTabSpec("ic_tab_rbn").setIndicator("RBN", res.getDrawable(R.drawable.ic_tab_rbn)).setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTabByTag("ic_tab_rb2");
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
    		propertiesIntent.setClass(DLCSearch.this, Preferences.class);
    		startActivity(propertiesIntent);
    		return true;
    	}
    	return false;
    }
}
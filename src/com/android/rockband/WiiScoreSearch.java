package com.android.rockband;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WiiScoreSearch extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textview = new TextView(this);
		textview.setText("Wii Leaderboard Search");
		setContentView(textview);
	}
}

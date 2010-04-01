package com.android.rockband;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class XboxScoreSearch extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textview = new TextView(this);
		textview.setText("Xbox 360 Leaderboard Search");
		setContentView(textview);
	}
}

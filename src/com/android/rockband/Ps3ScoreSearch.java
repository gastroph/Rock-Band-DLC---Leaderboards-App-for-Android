package com.android.rockband;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Ps3ScoreSearch extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_search);
		
		Spinner gameSpinner = (Spinner) findViewById(R.id.game_spinner);
		Spinner instrumentSpinner = (Spinner) findViewById(R.id.instrument_spinner);
		
		ArrayAdapter<CharSequence> gameSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.game_array, android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> instrumentSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.instrument_array, android.R.layout.simple_spinner_item);
		
		gameSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		instrumentSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		gameSpinner.setAdapter(gameSpinnerAdapter);
		gameSpinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
		instrumentSpinner.setAdapter(instrumentSpinnerAdapter);
		instrumentSpinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
		
		final EditText name = (EditText) findViewById(R.id.playerName);
		name.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
					Toast.makeText(Ps3ScoreSearch.this, name.getText(), Toast.LENGTH_SHORT).show();
					return true;
				}
				return false;
			}
		});
	}
	
	public class MyOnItemSelectedListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			Toast.makeText(parent.getContext(), "You Selected: " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
		}
		
		public void onNothingSelected(AdapterView<?> parent) {
			Toast.makeText(parent.getContext(), "Please make a selection to continue.", Toast.LENGTH_SHORT).show();
		}
	}
}

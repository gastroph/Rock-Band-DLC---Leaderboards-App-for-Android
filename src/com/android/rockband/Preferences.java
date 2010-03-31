package com.android.rockband;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class Preferences extends Activity implements OnTouchListener, OnClickListener {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preferences);
		TextView devPhone = (TextView) findViewById(R.id.devPhone);
		TextView devEmail = (TextView) findViewById(R.id.devEmail);
		
		devPhone.setOnClickListener(this);
		devPhone.setOnTouchListener(this);
		devEmail.setOnClickListener(this);
		devEmail.setOnTouchListener(this);
	}
	
	public boolean onTouch(View v, MotionEvent event) {
		switch (v.getId()) {
		case R.id.devPhone:
			if(event.getAction() == MotionEvent.ACTION_UP) {
				Intent devPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:3127252263"));
				startActivity(devPhoneIntent);
				return true;
			}
		case R.id.devEmail:
			if(event.getAction() == MotionEvent.ACTION_UP) {
				Intent devEmailIntent = new Intent(Intent.ACTION_SEND);
				devEmailIntent.setType("plain/text");
				devEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tstofflet@gmail.com"});
				startActivity(Intent.createChooser(devEmailIntent, "Choose E-mail..."));
				return true;
			}
		}
		return false;
	}
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.devPhone:
			Intent devPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:3127252263"));
			startActivity(devPhoneIntent);
			return;
		case R.id.devEmail:
			Intent devEmailIntent = new Intent(Intent.ACTION_SEND);
			devEmailIntent.setType("plain/text");
			devEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tstofflet@gmail.com"});
			startActivity(Intent.createChooser(devEmailIntent, "Choose E-mail..."));
			return;
		}
	}
}
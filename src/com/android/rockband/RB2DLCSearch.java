package com.android.rockband;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class RB2DLCSearch extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ImageTextListAdapter(this, getSongList()));
		
		ListView songListView = getListView();
		songListView.setTextFilterEnabled(true);
		
		songListView.setOnItemClickListener(new SongListItemClickListener());
	}
	
	public ArrayList<JSONObject> songList() {
		HttpREST httpREST = new HttpREST();
		String url = "http://services.rockband.com/leaderboard_data/rb2/wii/song_list.json";
		String result = httpREST.getHMXSonglist(url);
		JSONArray nameArray = new JSONArray();
		JSONArray valueArray = new JSONArray();
		JSONObject songList = new JSONObject();
		if(result != null) {
			try {
				JSONObject jsonResult = new JSONObject(result);
				nameArray = jsonResult.names();
				valueArray = jsonResult.toJSONArray(nameArray);
			} catch (JSONException je) {
				Log.e("JSONERRORD", "Exception:[ "+je+"]");
			}
		}
		ArrayList<JSONObject> sontList = new ArrayList<JSONObject>();
		sontList.add(0, nameArray);
		sontList.add(1, valueArray);
		return null;
	}

	

	public class SongListItemClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
		}	
	}
	
	public class ImageTextListAdapter extends ArrayAdapter<JSONObject> {
		public ImageTextListAdapter(Activity activity, List<JSONObject> imageAndText) {
			super(activity, 0, imageAndText);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Activity activity = (Activity) getContext();
			LayoutInflater inflater = activity.getLayoutInflater();
			View songRow = inflater.inflate(R.layout.song_list, null);
			JSONObject song = new JSONObject();
			TextView artistName = (TextView) songRow.findViewById(R.id.artist_name);
			TextView songName = (TextView) songRow.findViewById(R.id.song_name);
			TextView releaseDate = (TextView) songRow.findViewById(R.id.song_release_date);
			try {
				artistName.setText(song.getString("artist_name"));
				songName.setText(song.getString("song_name"));
				releaseDate.setText(song.getString("release_date"));
			} catch (JSONException je) {
				Log.e("JSON", "Error inflating song list", je);
			}
			return songRow;
		}
	}
}
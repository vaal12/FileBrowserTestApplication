package ua.com.vassiliev.FileBrowserTestApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import ua.com.vassiliev.androidfilebrowser.FileBrowserActivity;

public class FileBrowserTestApplicationActivity extends Activity {
	private final String LOGTAG = "FileBrowserTestApplicationActivity";
	private final int REQUEST_CODE_PICK_DIR = 1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Activity activityForButton = this;

		final Button startBrowserButton = (Button) findViewById(R.id.startFileBrowser);

		startBrowserButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.d(LOGTAG, "Start browsing button pressed");
				Intent fileExploreIntent = new Intent(
						ua.com.vassiliev.androidfilebrowser.FileBrowserActivity.INTENT_ACTION_SELECT_DIR,
						null,
						activityForButton,
						ua.com.vassiliev.androidfilebrowser.FileBrowserActivity.class);
				// fileExploreIntent.putExtra(
				// ua.com.vassiliev.androidfilebrowser.FileBrowserActivity.startDirectoryParameter,
				// "/sdcard"
				// );
				startActivityForResult(fileExploreIntent, REQUEST_CODE_PICK_DIR);
			}// public void onClick(View v) {
		});// startBrowserButton.setOnClickListener(new View.OnClickListener() {

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE_PICK_DIR) {
        	if(resultCode == this.RESULT_OK) {
        		String newDir = data.getStringExtra(
        				ua.com.vassiliev.androidfilebrowser.FileBrowserActivity.returnDirectoryParameter);
        		Toast.makeText(
        				this, 
        				"Received DIRECTORY path from file browser:\n"+newDir, 
        				Toast.LENGTH_LONG).show(); 
	        	
        	} else {//if(resultCode == this.RESULT_OK) {
        		Toast.makeText(
        				this, 
        				"Received NO result from file browser",
        				Toast.LENGTH_LONG).show(); 
        	}//END } else {//if(resultCode == this.RESULT_OK) {
        }//if (requestCode == REQUEST_CODE_PICK_DIR) {
		
	}//protected void onActivityResult(int requestCode, int resultCode, Intent data) {
}
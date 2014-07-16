package cce.mobile.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class ConfigureActivity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.custommain);
		
		final Button startConfigure = (Button) findViewById(R.id.custom_begin);
		startConfigure.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openConfigure1();
        		finish();
        	}
		});
		final Button main = (Button) findViewById(R.id.custom_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});	
	}
	
	private void openConfigure1() {
		Intent intent = new Intent(ConfigureActivity.this,Configure1Activity.class);
    	startActivity(intent);
	}

}


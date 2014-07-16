package cce.mobile.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class CheckoutActivity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.checkout);
		
		final Button back = (Button) findViewById(R.id.co_back);
		back.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
				Intent intent = new Intent(CheckoutActivity.this,QuestResultsActivity.class);
				startActivity(intent);
        		finish();
        	}
		});	
	}
	
}


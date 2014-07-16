package cce.mobile.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class QuestionnaireActivity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.questionnaire);
		
		//Setup initial values for our questions - these values will be reset every time the customer re-enters
		//the questionnaire
		SharedPreferences quest = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = quest.edit();
		edit.putInt("quest1", 0);
		edit.putInt("quest2", 0);
		edit.putInt("quest3", 0);
		edit.putInt("quest4", 0);
		edit.putInt("quest5", 0);
		edit.putInt("quest6", 0);
		edit.putInt("quest7", 0);
		edit.putInt("quest8", 0);
		edit.putInt("quest9", 0);	
		edit.commit();
		
		final Button main = (Button) findViewById(R.id.qu_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		
		final Button startQuestionnaire = (Button) findViewById(R.id.qu_begin);
		startQuestionnaire.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				openQuestion1();
				finish();
			}
		});
	}
	
	private void openQuestion1() {
		Intent intent = new Intent(QuestionnaireActivity.this,Question1Activity.class);
    	startActivity(intent);
	}

}

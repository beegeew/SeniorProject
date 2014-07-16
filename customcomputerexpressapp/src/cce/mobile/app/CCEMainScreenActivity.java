package cce.mobile.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class CCEMainScreenActivity extends Activity {
	/** Creating a shared preferences to save data in this session **/
	public static final String PREFS_NAME = "CCEPrefsFile";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		edit.putString("case", " ");
		edit.commit();
		edit.putString("cpu", " ");
		edit.commit();
		edit.putString("motherboard", " ");
		edit.commit();
		edit.putString("ram", " ");
		edit.commit();
		edit.putString("videocard", " ");
		edit.commit();
		edit.putString("harddrive", " ");
		edit.commit();
		edit.putString("ssd", " ");
		edit.commit();
		edit.putString("cd", " ");
		edit.commit();
		edit.putString("cooling", " ");
		edit.commit();
		edit.putString("powersupply", " ");
		edit.commit();
		edit.putString("os", " ");
		edit.commit();
		edit.putFloat("casePrice", (float)0.0);
		edit.commit();
		edit.putFloat("cpuPrice", (float)0.0);
		edit.commit();
		edit.putFloat("moboPrice", (float)0.0);
		edit.commit();
		edit.putFloat("ramPrice", (float)0.0);
		edit.commit();
		edit.putFloat("gpuPrice", (float)0.0);
		edit.commit();
		edit.putFloat("hddPrice", (float)0.0);
		edit.commit();
		edit.putFloat("ssdPrice", (float)0.0);
		edit.commit();
		edit.putFloat("drivePrice", (float)0.0);
		edit.commit();
		edit.putFloat("coolingPrice", (float)0.0);
		edit.commit();
		edit.putFloat("psuPrice", (float)0.0);
		edit.commit();
		edit.putFloat("osPrice", (float)0.0);
		edit.commit();
		
		
		
		
        
        final Button prebuilt = (Button) findViewById(R.id.ms_prebuilt);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPrebuilt();
        	}   
        });
        
        final Button exit = (Button) findViewById(R.id.ms_exit);
        exit.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}   
        });
        
        final Button ms_questionnaire = (Button) findViewById(R.id.ms_questionnaire);
        ms_questionnaire.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openQuestionnaire();
        	}
        });
        
        final Button checkstatus = (Button) findViewById(R.id.ms_orderstatus);
        checkstatus.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openCheckStatus();
        	}
        });
        
        final Button configure = (Button) findViewById(R.id.ms_configure);
        configure.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openConfigure();
        	}
        });
    }
        
    private void openPrebuilt(){
    	Intent intent = new Intent(CCEMainScreenActivity.this,PrebuiltMainActivity.class);
    	startActivity(intent);
    }
    
    private void openQuestionnaire() {
    	Intent intent = new Intent(CCEMainScreenActivity.this,QuestionnaireActivity.class);
    	startActivity(intent);
    }
    
    private void openCheckStatus() {
    	Intent intent = new Intent(CCEMainScreenActivity.this,CheckOrderActivity.class);
    	startActivity(intent);
    }
    
    private void openConfigure() {
    	Intent intent = new Intent(CCEMainScreenActivity.this,ConfigureActivity.class);
    	startActivity(intent);
    }
    
}



package cce.mobile.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class CheckOrderActivity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	EditText mEdit;
	public void onCreate(Bundle b){


		super.onCreate(b);
		setContentView(R.layout.checkorderstatus);
		
		final Button main = (Button) findViewById(R.id.cos_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		mEdit   = (EditText)findViewById(R.id.cos_orderIdNumber);
		final Button find = (Button) findViewById(R.id.cos_find);
		find.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		if(mEdit.getText().toString().length()==10){
        			
        		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
        		SharedPreferences.Editor edit = questVals.edit();
    			edit.putString("orderId", mEdit.getText().toString());
    			edit.commit();
        		openOrders();
        		finish();
        			
        		}
        		else{
        			TextView editText = (TextView)findViewById(R.id.cos_error);
        			editText.setText("An order ID must be 10 digits", TextView.BufferType.EDITABLE);
        		
        		}
        	}
		});
	
	
	
	}
	
    private void openOrders(){
    	Intent intent = new Intent(CheckOrderActivity.this,OrdersActivity.class);
    	startActivity(intent);
    }
    

}

package cce.mobile.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class OrdersActivity extends Activity{
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	public void onCreate(Bundle b){
		super.onCreate(b);
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		String orderId = get.getString("orderId", "NO");
		setContentView(R.layout.orders);
		final Button main = (Button) findViewById(R.id.cos_main);
		TextView editText = (TextView)findViewById(R.id.ordId);
		TextView editText2 = (TextView)findViewById(R.id.header1);
		TextView editText3 = (TextView)findViewById(R.id.header2);
		TextView editText4 = (TextView)findViewById(R.id.headStatus);
		
		if(orderId.equals("9999999999")){
			editText.setText(orderId, TextView.BufferType.EDITABLE);
			editText4.setText("Payment Processing", TextView.BufferType.EDITABLE);
		}
		else if((orderId.equals("1234567891"))){
			editText.setText(orderId, TextView.BufferType.EDITABLE);
			editText4.setText("Shipped", TextView.BufferType.EDITABLE);
		}
		else{
			editText2.setText("Sorry, your order could not be found.", TextView.BufferType.EDITABLE);
			editText3.setText("", TextView.BufferType.EDITABLE);
			editText4.setText("", TextView.BufferType.EDITABLE);
			editText.setText("", TextView.BufferType.EDITABLE);
			
		}
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
	
	
	}
}

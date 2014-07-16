package cce.mobile.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class QuestResultsActivity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.cartsummary);
		int rating;
		TextView currText;
		String temp;
		Float price;
		Float finalcost=(float)0.00;
		//get handle to the textview and then display it for all 9 saved prefs	
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		
		temp = get.getString("cpu", "NA");
		currText = (TextView) findViewById(R.id.cpuName);
		currText.setText(temp);
		price = get.getFloat("cpuPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.cpuPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("motherboard", "NA");
		currText = (TextView) findViewById(R.id.moboName);
		currText.setText(temp);
		price = get.getFloat("moboPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.moboPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("case", "NA");
		currText = (TextView) findViewById(R.id.caseName);
		currText.setText(temp);
		price = get.getFloat("casePrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.casePrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("ram", "NA");
		currText = (TextView) findViewById(R.id.ramName);
		currText.setText(temp);
		price = get.getFloat("ramPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.ramPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("videocard", "NA");
		currText = (TextView) findViewById(R.id.gpuName);
		currText.setText(temp);
		price = get.getFloat("gpuPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.gpuPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("harddrive", "NA");
		currText = (TextView) findViewById(R.id.hddName);
		currText.setText(temp);
		price = get.getFloat("hddPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.hddPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("ssd", "NA");
		currText = (TextView) findViewById(R.id.ssdName);
		currText.setText(temp);
		price = get.getFloat("ssdPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.ssdPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("cd", "NA");
		currText = (TextView) findViewById(R.id.driveName);
		currText.setText(temp);
		price = get.getFloat("drivePrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.drivePrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("cooling", "NA");
		currText = (TextView) findViewById(R.id.coolName);
		currText.setText(temp);
		price = get.getFloat("coolingPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.coolPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("powersupply", "NA");
		currText = (TextView) findViewById(R.id.psuName);
		currText.setText(temp);
		price = get.getFloat("psuPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.psuPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		temp = get.getString("os", "NA");
		currText = (TextView) findViewById(R.id.osName);
		currText.setText(temp);
		price = get.getFloat("osPrice", (float) 0.00);
		currText = (TextView) findViewById(R.id.osPrice);
		currText.setText(""+price);
		finalcost=finalcost+price;
		
		
		currText = (TextView) findViewById(R.id.FinalCost);
		currText.setText(""+Math.round(finalcost*100.00)/100.00);
		
		final Button main = (Button) findViewById(R.id.cs_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		
		final Button next = (Button) findViewById(R.id.cs_cust);
		next.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
					goNext();
					finish();
			}
		});
		
		final Button finish = (Button) findViewById(R.id.cs_check);
		finish.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
					Intent intent = new Intent(QuestResultsActivity.this,CheckoutActivity.class);
					startActivity(intent);
					finish();
			}
		});
		
		
//		currText = (TextView) findViewById(R.id.coolName);
//		currText.setText(temp);
//		
//		rating = get.getInt("quest4", 0);
//		currText = (TextView) findViewById(R.id.res_q4ans);
//		currText.setText(Integer.toString(rating));
//		
//		rating = get.getInt("quest5", 0);
//		currText = (TextView) findViewById(R.id.res_q5ans);
//		currText.setText(Integer.toString(rating));
//		rating = get.getInt("quest6", 0);
//		currText = (TextView) findViewById(R.id.res_q6ans);
//		currText.setText(Integer.toString(rating));
//		rating = get.getInt("quest7", 0);
//		currText = (TextView) findViewById(R.id.res_q7ans);
//		currText.setText(Integer.toString(rating));
//		rating = get.getInt("quest8", 0);
//		currText = (TextView) findViewById(R.id.res_q8ans);
//		currText.setText(Integer.toString(rating));
//		rating = get.getInt("quest9", 0);
//		currText = (TextView) findViewById(R.id.res_q9ans);
//		currText.setText(Integer.toString(rating));

	}
	public void goNext()
	{
		Intent intent = new Intent(QuestResultsActivity.this,Configure1Activity.class);
		startActivity(intent);
	}
}

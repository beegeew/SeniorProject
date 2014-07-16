package cce.mobile.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Prebuilt2Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.prebuilt2);
		
		final Button main = (Button) findViewById(R.id.pb2_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		final Button cart = (Button) findViewById(R.id.pb2_purchase);
		cart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setVals();
				openCart();
				finish();
			}
		});
		final Button customize = (Button) findViewById(R.id.pb2_customize);
		customize.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setVals();
				openConfigure();
				finish();
			}
		});
	}
	public void setVals() 
	{
		SharedPreferences addCart = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = addCart.edit();
		edit.putString("case", "Antec Three Hundred"); edit.putString("cpu", "Intel Core i5-2500 3.3 Ghz");
		edit.putString("motherboard", "Gigabyte LGA 115 HDMI SATA"); edit.putString("ram", "G.skill 4GB SDRAM DDR3");
		edit.putString("videocard", "MSI Cyclone GeForce GTX 550"); edit.putString("harddrive", "Hitachi 500GB 7200 RPM");
		edit.putString("ssd", "SSD: None"); edit.putString("cd", "LG Black DVD-ROM CD-ROM SATA");
		edit.putString("cooling", "Cooling: None"); edit.putString("powersupply", "OCZ ModXStream Pro 700W");
		edit.putString("os", "Windows 7 Home Premium");
		edit.putFloat("casePrice", (float)54.99); edit.putFloat("cpuPrice", (float)209.99);
		edit.putFloat("moboPrice", (float)104.99); edit.putFloat("ramPrice", (float)29.99);
		edit.putFloat("gpuPrice", (float)139.99); edit.putFloat("hddPrice", (float)99.99);
		edit.putFloat("ssdPrice", (float)0.0); edit.putFloat("drivePrice", (float)49.99);
		edit.putFloat("coolingPrice", (float)0.0); edit.putFloat("psuPrice", (float)89.99);
		edit.putFloat("osPrice", (float)99.99);
		edit.commit();
	}
	public void openCart() 
	{
		Intent intent = new Intent(Prebuilt2Activity.this,QuestResultsActivity.class);
		startActivity(intent);
	}
	public void openConfigure() 
	{
		Intent intent = new Intent(Prebuilt2Activity.this,Configure1Activity.class);
		startActivity(intent);
	}
}
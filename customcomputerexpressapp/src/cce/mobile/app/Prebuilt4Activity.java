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

public class Prebuilt4Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.prebuilt4);
		
		final Button main = (Button) findViewById(R.id.pb4_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		final Button cart = (Button) findViewById(R.id.pb4_purchase);
		cart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setVals();
				openCart();
				finish();
			}
		});
		final Button customize = (Button) findViewById(R.id.pb4_customize);
		customize.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setVals();
				openCart();
				finish();
			}
			
		});
	}
	public void setVals() 
	{
		SharedPreferences addCart = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = addCart.edit();
		edit.putString("case", "Antec Lanboy Metal"); edit.putString("cpu", "Intel Core i7-2600K 3.4GHz");
		edit.putString("motherboard", "Gigabyte LGA 1155 Intel SATA 6Gb/s"); edit.putString("ram", "G.skill 8GB SDRAM DDR3");
		edit.putString("videocard", "EVGA GeForce GTX 580"); edit.putString("harddrive", "Seagate 1TB 7200 RPM");
		edit.putString("ssd", "Intel 320 120GB SATA II"); edit.putString("cd", "Asus Black BD-ROM CD-ROM SATA");
		edit.putString("cooling", "Corsair CPU Cooler"); edit.putString("powersupply", "Corsair Enthusiast 850W");
		edit.putString("os", "Windows 7 Home Premium");
		edit.putFloat("casePrice", (float)179.99); edit.putFloat("cpuPrice", (float)299.99);
		edit.putFloat("moboPrice", (float)319.99); edit.putFloat("ramPrice", (float)44.99);
		edit.putFloat("gpuPrice", (float)509.99); edit.putFloat("hddPrice", (float)219.99);
		edit.putFloat("ssdPrice", (float)239.99); edit.putFloat("drivePrice", (float)57.99);
		edit.putFloat("coolingPrice", (float)71.99); edit.putFloat("psuPrice", (float)149.99);
		edit.putFloat("osPrice", (float)99.99);
		edit.commit();
	}
	public void openCart() 
	{
		Intent intent = new Intent(Prebuilt4Activity.this,QuestResultsActivity.class);
		startActivity(intent);
	}
	public void openConfigure() 
	{
		Intent intent = new Intent(Prebuilt4Activity.this,Configure1Activity.class);
		startActivity(intent);
	}
}
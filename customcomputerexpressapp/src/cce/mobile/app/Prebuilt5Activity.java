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

public class Prebuilt5Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.prebuilt5);
		
		final Button main = (Button) findViewById(R.id.pb5_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		final Button cart = (Button) findViewById(R.id.pb5_purchase);
		cart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setVals();
				openCart();
				finish();
			}
		});
		final Button customize = (Button) findViewById(R.id.pb5_customize);
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
		edit.putString("case", "Silverstone Fortress Series"); edit.putString("cpu", "Intel Core i7-2700K 3.5GHz");
		edit.putString("motherboard", "Gigabyte LGA 1155 Intel Z68 SATA 6Gb/s"); edit.putString("ram", "G.skill 8GB SDRAM DDR3 800");
		edit.putString("videocard", "EVGA GeForce GTX 590"); edit.putString("harddrive", "Seagate 3TB 7200 RPM");
		edit.putString("ssd", "OCZ RevoDrive 3 960GB"); edit.putString("cd", "Plextor DVD-ROM CD-ROM SATA");
		edit.putString("cooling", "PC Power-Turbo-Cool 1200W"); edit.putString("powersupply", "Corsair Enthusiast 850W");
		edit.putString("os", "Windows 7 Ultimate");
		edit.putFloat("casePrice", (float)249.99); edit.putFloat("cpuPrice", (float)369.99);
		edit.putFloat("moboPrice", (float)349.99); edit.putFloat("ramPrice", (float)159.99);
		edit.putFloat("gpuPrice", (float)749.99); edit.putFloat("hddPrice", (float)429.99);
		edit.putFloat("ssdPrice", (float)3199.99); edit.putFloat("drivePrice", (float)109.99);
		edit.putFloat("coolingPrice", (float)449.99); edit.putFloat("psuPrice", (float)149.99);
		edit.putFloat("osPrice", (float)189.99);
		edit.commit();
	}
	public void openCart() 
	{
		Intent intent = new Intent(Prebuilt5Activity.this,QuestResultsActivity.class);
		startActivity(intent);
	}
	public void openConfigure() 
	{
		Intent intent = new Intent(Prebuilt5Activity.this,Configure1Activity.class);
		startActivity(intent);
	}
}
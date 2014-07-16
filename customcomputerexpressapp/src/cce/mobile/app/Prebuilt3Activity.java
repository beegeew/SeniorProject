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

public class Prebuilt3Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.prebuilt3);
		
		final Button main = (Button) findViewById(R.id.pb3_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		final Button cart = (Button) findViewById(R.id.pb3_purchase);
		cart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setVals();
				openCart();
				finish();
			}
		});
		final Button customize = (Button) findViewById(R.id.pb3_customize);
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
		edit.putString("case", "Antec Nine Hundred"); edit.putString("cpu", "Intel Core i5-2500K 3.3GHz");
		edit.putString("motherboard", "Asus LGA 1155 HDMI SATA"); edit.putString("ram", "G.skill 8GB SDRAM DDR3");
		edit.putString("videocard", "EVGA GeForce GTX 570 HD"); edit.putString("harddrive", "Seagate 640GB 5400 RPM");
		edit.putString("ssd", "OCZ Vertex 60GB SATA II"); edit.putString("cd", "Sony Black CD-ROM SATA DVD-ROM");
		edit.putString("cooling", "Zalman 2 Ball CPU Cooler"); edit.putString("powersupply", "Corsair CMPSU 750W");
		edit.putString("os", "Windows 7 Home Premium");
		edit.putFloat("casePrice", (float)99.99); edit.putFloat("cpuPrice", (float)224.99);
		edit.putFloat("moboPrice", (float)209.99); edit.putFloat("ramPrice", (float)42.99);
		edit.putFloat("gpuPrice", (float)349.99); edit.putFloat("hddPrice", (float)115.99);
		edit.putFloat("ssdPrice", (float)99.99); edit.putFloat("drivePrice", (float)51.99);
		edit.putFloat("coolingPrice", (float)47.99); edit.putFloat("psuPrice", (float)129.99);
		edit.putFloat("osPrice", (float)99.99);
		edit.commit();
	}
	public void openCart() 
	{
		Intent intent = new Intent(Prebuilt3Activity.this,QuestResultsActivity.class);
		startActivity(intent);
	}
	public void openConfigure() 
	{
		Intent intent = new Intent(Prebuilt3Activity.this,Configure1Activity.class);
		startActivity(intent);
	}
}
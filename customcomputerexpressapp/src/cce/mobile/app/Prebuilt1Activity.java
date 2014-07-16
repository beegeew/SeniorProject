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

public class Prebuilt1Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.prebuilt1);
		
		final Button main = (Button) findViewById(R.id.pb1_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		final Button buy = (Button) findViewById(R.id.pb1_purchase);
		buy.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				setVals();
				openCart();
				finish();
			}
		});
		final Button customize = (Button) findViewById(R.id.pb1_customize);
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
		edit.putString("case", "APEX Vortex 3610"); edit.putString("cpu", "Intel Celeron 2.4Ghz Dual-Core");
		edit.putString("motherboard", "Biostar LGA 1155 ATX"); edit.putString("ram", "G.skill 2GB DDR3 SDRAM DDR3");
		edit.putString("videocard", "GPU: None"); edit.putString("harddrive", "Seagate 320GB 7200 RPM");
		edit.putString("ssd", "SSD: None"); edit.putString("cd", "Asus CD-ROM SATA DVD-ROM");
		edit.putString("cooling", "Cooling: None"); edit.putString("powersupply", "COOLMAX 650W ATX12V");
		edit.putString("os", "Windows 7 Home Premium");
		edit.putFloat("casePrice", (float)19.99); edit.putFloat("cpuPrice", (float)56.99);
		edit.putFloat("moboPrice", (float)49.99); edit.putFloat("ramPrice", (float)24.99);
		edit.putFloat("gpuPrice", (float)0.0); edit.putFloat("hddPrice", (float)95.99);
		edit.putFloat("ssdPrice", (float)0.0); edit.putFloat("drivePrice", (float)16.99);
		edit.putFloat("coolingPrice", (float)0.0); edit.putFloat("psuPrice", (float)54.99);
		edit.putFloat("osPrice", (float)99.99);
		edit.commit();
	}
	public void openCart() 
	{
		Intent intent = new Intent(Prebuilt1Activity.this,QuestResultsActivity.class);
		startActivity(intent);
	}
	public void openConfigure() 
	{
		Intent intent = new Intent(Prebuilt1Activity.this,Configure1Activity.class);
		startActivity(intent);
	}
}

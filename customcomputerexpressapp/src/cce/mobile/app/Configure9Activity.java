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


public class Configure9Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.custom9);
		
        final Button prebuilt = (Button) findViewById(R.id.custom9_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom9_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure9Activity.this,Configure8Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		final Button next = (Button) findViewById(R.id.custom9_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		final Button view1 = (Button) findViewById(R.id.cust9img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust9img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust9img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("cooling", "LOLOL").equals("Zalman 2 Ball CPU Cooler"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust9rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cooling", "LOLOL").equals("Corsair CPU Cooler"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust9rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cooling", "LOLOL").equals("Corsair H100 Liquid CPU Cooler"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust9rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cooling", "LOLOL").equals("Cooling: None"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust9rad4);
			radGroup1.setChecked(true);
		}
	}
    
    private void openNext(){
    	SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust9rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust9rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust9rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust9rad4);

		
		if(getRate4.isChecked()){
			edit.putString("cooling","Cooling: None" );
			edit.commit();
			edit.putFloat("coolingPrice",(float)(0.0) );
			edit.commit();
			
		}
		else if(getRate.isChecked()){
			edit.putString("cooling","Zalman 2 Ball CPU Cooler" );
			edit.commit();
			edit.putFloat("coolingPrice",(float)47.99 );
			edit.commit();
		}
		else if(getRate2.isChecked()){
			edit.putString("cooling","Corsair CPU Cooler" );
			edit.commit();
			edit.putFloat("coolingPrice",(float)71.99 );
			edit.commit();

		}
		else if(getRate3.isChecked()){
			edit.putString("cooling","Corsair H100 Liquid CPU Cooler");
			edit.commit();
			edit.putFloat("coolingPrice",(float)119.99 );
			edit.commit();

		}

    	Intent intent = new Intent(Configure9Activity.this,Configure10Activity.class);
    	startActivity(intent);
    }
	
	private void openPopup(){
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom9help);
        dialog.setTitle("Why is Cooling Important?");
        dialog.setCancelable(true);

        //set up button
        Button button = (Button) dialog.findViewById(R.id.pop_close);
        
        button.setVisibility(View.VISIBLE);
        button.setBackgroundColor(Color.TRANSPARENT);
        
        button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
               dialog.dismiss();
            }
        }
        );
        
        dialog.show();
    }
	
	
	private void popImg1() {
		final Dialog dialog = new Dialog(this);
		Context mContext = getApplicationContext();

		dialog.setContentView(R.layout.custom9image1);
		dialog.setTitle("Zalman LED 2 Ball");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust9imgview1);
		image.setImageResource(R.drawable.cooler3);
		
        Button button = (Button) dialog.findViewById(R.id.cust9img1close);
        
        button.setVisibility(View.VISIBLE);
        button.setBackgroundColor(Color.TRANSPARENT);
        
        button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
               dialog.dismiss();
            }
        }
        );
		
        dialog.show();
	}
	private void popImg2() {
		final Dialog dialog = new Dialog(this);
		Context mContext = getApplicationContext();

		dialog.setContentView(R.layout.custom9image2);
		dialog.setTitle("Corsair High Performance");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust9imgview2);
		image.setImageResource(R.drawable.cooler4);
		
        Button button = (Button) dialog.findViewById(R.id.cust9img2close);
        
        button.setVisibility(View.VISIBLE);
        button.setBackgroundColor(Color.TRANSPARENT);
        
        button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
               dialog.dismiss();
            }
        }
        );
		
        dialog.show();
	}
	private void popImg3() {
		final Dialog dialog = new Dialog(this);
		Context mContext = getApplicationContext();

		dialog.setContentView(R.layout.custom9image3);
		dialog.setTitle("Corsair H100 Extreme Performance");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust9imgview3);
		image.setImageResource(R.drawable.cooler5);
		
        Button button = (Button) dialog.findViewById(R.id.cust9img3close);
        
        button.setVisibility(View.VISIBLE);
        button.setBackgroundColor(Color.TRANSPARENT);
        
        button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
               dialog.dismiss();
            }
        }
        );
		
        dialog.show();
	}

	
}

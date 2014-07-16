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


public class Configure7Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.custom7);
		
        final Button prebuilt = (Button) findViewById(R.id.custom7_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom7_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure7Activity.this,Configure6Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		final Button next = (Button) findViewById(R.id.custom7_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		final Button view1 = (Button) findViewById(R.id.cust7img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust7img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust7img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("ssd", "LOLOL").equals("OCZ Vertex 60GB SATA II"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust7rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("ssd", "LOLOL").equals("Intel 320 120GB SATA II"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust7rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("ssd", "LOLOL").equals("OCZ RevoDrive 3 960GB"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust7rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("ssd", "LOLOL").equals("SSD: None"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust7rad4);
			radGroup1.setChecked(true);
		}
		
	
		
		
	}
    
	
    private void openNext(){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust7rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust7rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust7rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust7rad4);

		
		if(getRate4.isChecked()){
			edit.putString("ssd","SSD: None" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(0.0) );
			edit.commit();
		}
		else if(getRate.isChecked()){
			edit.putString("ssd","OCZ Vertex 60GB SATA II" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(99.99) );
			edit.commit();
		}
		else if(getRate2.isChecked()){
			edit.putString("ssd","Intel 320 120GB SATA II" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(239.99) );
			edit.commit();
		}
		else if(getRate3.isChecked()){
			edit.putString("ssd","OCZ RevoDrive 3 960GB" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(3199.99) );
			edit.commit();
		}
		
    	Intent intent = new Intent(Configure7Activity.this,Configure8Activity.class);
    	startActivity(intent);
    }
		
	
	private void openPopup(){
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom7help);
        dialog.setTitle("Why is an SSD Important?");
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

		dialog.setContentView(R.layout.custom7image1);
		dialog.setTitle("OCZ Vertex 2 60GB ");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust7imgview1);
		image.setImageResource(R.drawable.ssd3);
		
        Button button = (Button) dialog.findViewById(R.id.cust7img1close);
        
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

		dialog.setContentView(R.layout.custom7image2);
		dialog.setTitle("Intel 320 Series 120GB");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust7imgview2);
		image.setImageResource(R.drawable.ssd4);
		
        Button button = (Button) dialog.findViewById(R.id.cust7img2close);
        
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

		dialog.setContentView(R.layout.custom7image3);
		dialog.setTitle("OCZ RevoDrive 3 X2 960GB");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust7imgview3);
		image.setImageResource(R.drawable.ssd5);
		
        Button button = (Button) dialog.findViewById(R.id.cust7img3close);
        
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

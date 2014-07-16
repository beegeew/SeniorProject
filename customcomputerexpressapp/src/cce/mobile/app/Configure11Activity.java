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


public class Configure11Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.custom11);
		
        final Button prebuilt = (Button) findViewById(R.id.custom11_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom11_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure11Activity.this,Configure10Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		final Button next = (Button) findViewById(R.id.custom11_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		final Button view1 = (Button) findViewById(R.id.cust11img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust11img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("os", "LOLOL").equals("Windows 7 Home Premium"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust11rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("os", "LOLOL").equals("Windows 7 Ultimate"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust11rad2);
			radGroup1.setChecked(true);
		}
	}
    
    private void openNext(){  
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust11rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust11rad2);

		
		if(getRate.isChecked()){
			edit.putString("os","Windows 7 Home Premium" );
			edit.commit();

			edit.putFloat("osPrice",(float)(99.99) );
			edit.commit();
		}
		else if(getRate2.isChecked()){
			edit.putString("os","Windows 7 Ultimate" );
			edit.commit();

			edit.putFloat("osPrice",(float)(189.99) );
			edit.commit();
		}
		
		
    	Intent intent = new Intent(Configure11Activity.this,QuestResultsActivity.class);
    	startActivity(intent);
    }
	
	private void openPopup(){
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom11help);
        dialog.setTitle("Why is an OS important?");
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

		dialog.setContentView(R.layout.custom11image1);
		dialog.setTitle("Windows 7 Home Premium");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust11imgview1);
		image.setImageResource(R.drawable.os1234);
		
        Button button = (Button) dialog.findViewById(R.id.cust11img1close);
        
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

		dialog.setContentView(R.layout.custom11image2);
		dialog.setTitle("Windows 7 Ultimate");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust11imgview2);
		image.setImageResource(R.drawable.os5);
		
        Button button = (Button) dialog.findViewById(R.id.cust11img2close);
        
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


package cce.mobile.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.app.AlertDialog.Builder;
import android.content.Context;


public class Configure2Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		
		super.onCreate(b);
		setContentView(R.layout.custom2);
		
        final Button prebuilt = (Button) findViewById(R.id.custom2_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom2_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure2Activity.this,Configure1Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		
		final Button next = (Button) findViewById(R.id.custom2_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		
		final Button view1 = (Button) findViewById(R.id.cust2img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust2img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust2img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		final Button view4 = (Button) findViewById(R.id.cust2img4);
		view4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg4();
			}
		});
		final Button view5 = (Button) findViewById(R.id.cust2img5);
		view5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg5();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("cpu", "LOLOL").equals("Intel Celeron 2.4Ghz Dual-Core"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust2rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cpu", "LOLOL").equals("Intel Core i5-2500 3.3 Ghz"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust2rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cpu", "LOLOL").equals("Intel Core i5-2500K 3.3GHz"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust2rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cpu", "LOLOL").equals("Intel Core i7-2600K 3.4GHz"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust2rad4);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cpu", "LOLOL").equals("Intel Core i7-2700K 3.5GHz"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust2rad5);
			radGroup1.setChecked(true);
		}
	
	}
    
    private void openNext(){
    	
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust2rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust2rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust2rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust2rad4);
		RadioButton getRate5 = (RadioButton) findViewById(R.id.cust2rad5);
		
		if(getRate.isChecked()){
			edit.putString("cpu","Intel Celeron 2.4Ghz Dual-Core" );
			edit.commit();
			edit.putFloat("cpuPrice",(float)(56.99) );
			edit.commit();
			
		}
		else if(getRate2.isChecked()){
			edit.putString("cpu","Intel Core i5-2500 3.3 Ghz" );
			edit.commit();
			edit.putFloat("cpuPrice",(float)209.99 );
			edit.commit();

		}
		else if(getRate3.isChecked()){
			edit.putString("cpu","Intel Core i5-2500K 3.3GHz" );
			edit.commit();
			edit.putFloat("cpuPrice",(float)224.99 );
			edit.commit();

		}
		else if(getRate4.isChecked()){
			edit.putString("cpu","Intel Core i7-2600K 3.4GHz" );
			edit.commit();
			edit.commit();
			edit.putFloat("cpuPrice",(float)319.99 );
			edit.commit();

		}
		else if(getRate5.isChecked()){
			edit.putString("cpu","Intel Core i7-2700K 3.5GHz" );
			edit.commit();
			edit.putFloat("cpuPrice",(float)369.99 );
			edit.commit();

		}
    	
    	Intent intent = new Intent(Configure2Activity.this,Configure3Activity.class);
    	startActivity(intent);
    }
    
    public void showAlert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("You must select a part before moving on.")
		       .setCancelable(false)
		       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	private void openPopup(){
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom2help);
        dialog.setTitle("Why is CPU Selection Important?");
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

		dialog.setContentView(R.layout.custom2image1);
		dialog.setTitle(" Intel Celeron 2.4 GHz");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust2imgview1);
		image.setImageResource(R.drawable.cpu1);
		
        Button button = (Button) dialog.findViewById(R.id.cust2img1close);
        
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

		dialog.setContentView(R.layout.custom2image2);
		dialog.setTitle("Intel i5-2500K 3.3 GHz");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust2imgview2);
		image.setImageResource(R.drawable.cpu23);
		
        Button button = (Button) dialog.findViewById(R.id.cust2img2close);
        
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

		dialog.setContentView(R.layout.custom2image3);
		dialog.setTitle("Intel i5-2500K 3.3 GHz");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust2imgview3);
		image.setImageResource(R.drawable.cpu23);
		
        Button button = (Button) dialog.findViewById(R.id.cust2img3close);
        
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
	private void popImg4() {
		final Dialog dialog = new Dialog(this);
		Context mContext = getApplicationContext();

		dialog.setContentView(R.layout.custom2image4);
		dialog.setTitle("Intel i7-2600K 3.4 GHz");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust2imgview4);
		image.setImageResource(R.drawable.cpu45);
		
        Button button = (Button) dialog.findViewById(R.id.cust2img4close);
        
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
	private void popImg5() {
		final Dialog dialog = new Dialog(this);
		Context mContext = getApplicationContext();

		dialog.setContentView(R.layout.custom2image5);
		dialog.setTitle("Intel i7-2600K 3.5 GHz");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust2imgview5);
		image.setImageResource(R.drawable.cpu45);
		
        Button button = (Button) dialog.findViewById(R.id.cust2img5close);
        
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

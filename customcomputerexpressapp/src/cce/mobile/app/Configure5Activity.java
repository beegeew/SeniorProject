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


public class Configure5Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		
		super.onCreate(b);
		setContentView(R.layout.custom5);
		
        final Button prebuilt = (Button) findViewById(R.id.custom5_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom5_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure5Activity.this,Configure4Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		
		final Button next = (Button) findViewById(R.id.custom5_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		
		final Button view1 = (Button) findViewById(R.id.cust5img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust5img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust5img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		final Button view4 = (Button) findViewById(R.id.cust5img4);
		view4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg4();
			}
		});

		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("videocard", "LOLOL").equals("MSI Cyclone GeForce GTX 550"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust5rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("videocard", "LOLOL").equals("EVGA GeForce GTX 570 HD"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust5rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("videocard", "LOLOL").equals("EVGA GeForce GTX 580"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust5rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("videocard", "LOLOL").equals("EVGA GeForce GTX 590"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust5rad4);
			radGroup1.setChecked(true);
		}
		else if((get.getString("videocard", "LOLOL").equals("GPU: None"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust5rad5);
			radGroup1.setChecked(true);
		}
	
	}
    
    private void openNext(){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust5rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust5rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust5rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust5rad4);
		RadioButton getRate5 = (RadioButton) findViewById(R.id.cust5rad5);
		
		if(getRate5.isChecked()){
			edit.putString("videocard","GPU: None" );
			edit.commit();

			edit.putFloat("gpuPrice",(float)(0.0) );
			edit.commit();
		}
		else if(getRate.isChecked()){
			edit.putString("videocard","MSI Cyclone GeForce GTX 550" );
			edit.commit();

			edit.putFloat("gpuPrice",(float)(139.99) );
			edit.commit();
		}
		else if(getRate2.isChecked()){
			edit.putString("videocard","EVGA GeForce GTX 570 HD" );
			edit.commit();

			edit.putFloat("gpuPrice",(float)(349.99) );
			edit.commit();
		}
		else if(getRate3.isChecked()){
			edit.putString("videocard","EVGA GeForce GTX 580" );
			edit.commit();

			edit.putFloat("gpuPrice",(float)(509.99) );
			edit.commit();
		}
		else if(getRate4.isChecked()){
			edit.putString("videocard","EVGA GeForce GTX 590" );
			edit.commit();

			edit.putFloat("gpuPrice",(float)(749.99) );
			edit.commit();
		}
		
    	Intent intent = new Intent(Configure5Activity.this,Configure6Activity.class);
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
        dialog.setContentView(R.layout.custom5help);
        dialog.setTitle("Why is GPU Selection Important?");
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

		dialog.setContentView(R.layout.custom5image1);
		dialog.setTitle("MSI Cyclone OC GeForce GTX 550 Ti");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust5imgview1);
		image.setImageResource(R.drawable.gpu2);
		
        Button button = (Button) dialog.findViewById(R.id.cust5img1close);
        
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

		dialog.setContentView(R.layout.custom5image2);
		dialog.setTitle("EVGA GeForce GTX 570 HD");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust5imgview2);
		image.setImageResource(R.drawable.gpu3);
		
        Button button = (Button) dialog.findViewById(R.id.cust5img2close);
        
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

		dialog.setContentView(R.layout.custom5image3);
		dialog.setTitle("EVGA SuperClocked GeForce GTX 580");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust5imgview3);
		image.setImageResource(R.drawable.gpu4);
		
        Button button = (Button) dialog.findViewById(R.id.cust5img3close);
        
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

		dialog.setContentView(R.layout.custom5image4);
		dialog.setTitle("EVGA GeForce GTX 590");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust5imgview4);
		image.setImageResource(R.drawable.gpu5);
		
        Button button = (Button) dialog.findViewById(R.id.cust5img4close);
        
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

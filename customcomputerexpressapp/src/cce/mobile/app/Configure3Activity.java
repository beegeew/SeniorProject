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


public class Configure3Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.custom3);
		
        final Button prebuilt = (Button) findViewById(R.id.custom3_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom3_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure3Activity.this,Configure2Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		final Button next = (Button) findViewById(R.id.custom3_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		final Button view1 = (Button) findViewById(R.id.cust3img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust3img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust3img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		final Button view4 = (Button) findViewById(R.id.cust3img4);
		view4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg4();
			}
		});
		final Button view5 = (Button) findViewById(R.id.cust3img5);
		view5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg5();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("motherboard", "LOLOL").equals("Biostar LGA 1155 ATX"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust3rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("motherboard", "LOLOL").equals("Gigabyte LGA 115 HDMI SATA"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust3rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("motherboard", "LOLOL").equals("Asus LGA 1155 HDMI SATA"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust3rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("motherboard", "LOLOL").equals("Gigabyte LGA 1155 Intel SATA 6Gb/s"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust3rad4);
			radGroup1.setChecked(true);
		}
		else if((get.getString("motherboard", "LOLOL").equals("Gigabyte LGA 1155 Intel Z68 SATA 6Gb/s"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust3rad5);
			radGroup1.setChecked(true);
		}
	}
    
    private void openNext(){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust3rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust3rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust3rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust3rad4);
		RadioButton getRate5 = (RadioButton) findViewById(R.id.cust3rad5);
		
		if(getRate.isChecked()){
			edit.putString("motherboard","Biostar LGA 1155 ATX" );
			edit.commit();
			edit.putFloat("moboPrice",(float)(49.99) );
			edit.commit();
			
		}
		else if(getRate2.isChecked()){
			edit.putString("motherboard","Gigabyte LGA 115 HDMI SATA" );
			edit.commit();
			edit.putFloat("moboPrice",(float)104.99 );
			edit.commit();
		}
		else if(getRate3.isChecked()){
			edit.putString("motherboard","Asus LGA 1155 HDMI SATA" );
			edit.commit();
			edit.putFloat("moboPrice",(float)209.99 );
			edit.commit();

		}
		else if(getRate4.isChecked()){
			edit.putString("motherboard","Gigabyte LGA 1155 Intel SATA 6Gb/s");
			edit.commit();
			edit.putFloat("moboPrice",(float)299.99 );
			edit.commit();

		}
		else if(getRate5.isChecked()){
			edit.putString("motherboard","Gigabyte LGA 1155 Intel Z68 SATA 6Gb/s" );
			edit.commit();
			edit.putFloat("moboPrice",(float)349.99 );
			edit.commit();
		}
    	
    	Intent intent = new Intent(Configure3Activity.this,Configure4Activity.class);
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
        dialog.setContentView(R.layout.custom3help);
        dialog.setTitle("Difference between motherboards?");
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

		dialog.setContentView(R.layout.custom3image1);
		dialog.setTitle("Biostar H61MGC");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust3imgview1);
		image.setImageResource(R.drawable.mobo1);
		
        Button button = (Button) dialog.findViewById(R.id.cust3img1close);
        
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

		dialog.setContentView(R.layout.custom3image2);
		dialog.setTitle("Gigabyte GZ-Z68M-D2H");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust3imgview2);
		image.setImageResource(R.drawable.mobo2);
		
        Button button = (Button) dialog.findViewById(R.id.cust3img2close);
        
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

		dialog.setContentView(R.layout.custom3image3);
		dialog.setTitle("ASUS P8Z68-V");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust3imgview3);
		image.setImageResource(R.drawable.mobo3);
		
        Button button = (Button) dialog.findViewById(R.id.cust3img3close);
        
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

		dialog.setContentView(R.layout.custom3image4);
		dialog.setTitle("Gigabyte GA-P67A");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust3imgview4);
		image.setImageResource(R.drawable.mobo4);
		
        Button button = (Button) dialog.findViewById(R.id.cust3img4close);
        
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

		dialog.setContentView(R.layout.custom3image5);
		dialog.setTitle("Gigabyte GA-Z68X");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust3imgview5);
		image.setImageResource(R.drawable.mobo5);
		
        Button button = (Button) dialog.findViewById(R.id.cust3img5close);
        
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

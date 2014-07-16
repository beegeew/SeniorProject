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


public class Configure8Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		
		super.onCreate(b);
		setContentView(R.layout.custom8);
		
        final Button prebuilt = (Button) findViewById(R.id.custom8_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom8_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure8Activity.this,Configure7Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		
		final Button next = (Button) findViewById(R.id.custom8_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		
		final Button view1 = (Button) findViewById(R.id.cust8img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust8img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust8img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		final Button view4 = (Button) findViewById(R.id.cust8img4);
		view4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg4();
			}
		});
		final Button view5 = (Button) findViewById(R.id.cust8img5);
		view5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg5();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("cd", "LOLOL").equals("Asus CD-ROM SATA DVD-ROM"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust8rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cd", "LOLOL").equals("LG Black DVD-ROM CD-ROM SATA"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust8rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cd", "LOLOL").equals("Sony Black CD-ROM SATA DVD-ROM"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust8rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cd", "LOLOL").equals("Asus Black BD-ROM CD-ROM SATA"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust8rad4);
			radGroup1.setChecked(true);
		}
		else if((get.getString("cd", "LOLOL").equals("Plextor DVD-ROM CD-ROM SATA"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust8rad5);
			radGroup1.setChecked(true);
		}
	
	}
    
    private void openNext(){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust8rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust8rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust8rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust8rad4);
		RadioButton getRate5 = (RadioButton) findViewById(R.id.cust8rad5);
		
		if(getRate.isChecked()){
			edit.putString("cd","Asus CD-ROM SATA DVD-ROM" );
			edit.commit();

			edit.putFloat("drivePrice",(float)(16.99) );
			edit.commit();
		}
		else if(getRate2.isChecked()){
			edit.putString("cd","LG Black DVD-ROM CD-ROM SATA" );
			edit.commit();
			edit.putFloat("drivePrice",(float)49.99 );
			edit.commit();
		}
		else if(getRate3.isChecked()){
			edit.putString("cd","Sony Black CD-ROM SATA DVD-ROM" );
			edit.commit();
			edit.putFloat("drivePrice",(float)51.99 );
			edit.commit();
		}
		else if(getRate4.isChecked()){
			edit.putString("cd","Asus Black BD-ROM CD-ROM SATA" );
			edit.commit();
			edit.putFloat("drivePrice",(float)57.99 );
			edit.commit();
		}
		else if(getRate5.isChecked()){
			edit.putString("cd","Plextor DVD-ROM CD-ROM SATA" );
			edit.commit();
			edit.putFloat("drivePrice",(float)109.99 );
			edit.commit();
		}
		
    	Intent intent = new Intent(Configure8Activity.this,Configure9Activity.class);
    	startActivity(intent);
    }
	
	private void openPopup(){
		final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom8help);
        dialog.setTitle("Difference between drives?");
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

		dialog.setContentView(R.layout.custom8image1);
		dialog.setTitle("ASUS 18xDVD-ROM 48xCD_ROM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust8imgview1);
		image.setImageResource(R.drawable.cd1);
		
        Button button = (Button) dialog.findViewById(R.id.cust8img1close);
        
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

		dialog.setContentView(R.layout.custom8image2);
		dialog.setTitle("LG 12xBD-ROM 16xDVD-ROM 48xCD-ROM Blu-Ray");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust8imgview2);
		image.setImageResource(R.drawable.cd2);
		
        Button button = (Button) dialog.findViewById(R.id.cust8img2close);
        
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

		dialog.setContentView(R.layout.custom8image3);
		dialog.setTitle("Sony 18x DVD-ROM 48xCD-ROM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust8imgview3);
		image.setImageResource(R.drawable.cd3);
		
        Button button = (Button) dialog.findViewById(R.id.cust8img3close);
        
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

		dialog.setContentView(R.layout.custom8image4);
		dialog.setTitle("Asus 12xBD-ROM 16xDVD-ROM 48xCD-ROM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust8imgview4);
		image.setImageResource(R.drawable.cd4);
		
        Button button = (Button) dialog.findViewById(R.id.cust8img4close);
        
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

		dialog.setContentView(R.layout.custom8image5);
		dialog.setTitle("Plextor 8xBD-ROM 16xDVD-ROM 48xCD-ROM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust8imgview5);
		image.setImageResource(R.drawable.cd5);
		
        Button button = (Button) dialog.findViewById(R.id.cust8img5close);
        
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

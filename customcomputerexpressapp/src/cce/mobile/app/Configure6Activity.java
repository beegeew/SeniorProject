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


public class Configure6Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		
		super.onCreate(b);
		setContentView(R.layout.custom6);
		
        final Button prebuilt = (Button) findViewById(R.id.custom6_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom6_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure6Activity.this,Configure5Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		
		final Button next = (Button) findViewById(R.id.custom6_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		
		final Button view1 = (Button) findViewById(R.id.cust6img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust6img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust6img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		final Button view4 = (Button) findViewById(R.id.cust6img4);
		view4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg4();
			}
		});
		final Button view5 = (Button) findViewById(R.id.cust6img5);
		view5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg5();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("harddrive", "LOLOL").equals("Seagate 320GB 7200 RPM"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust6rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("harddrive", "LOLOL").equals("Hitachi 500GB 7200 RPM"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust6rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("harddrive", "LOLOL").equals("Seagate 640GB 5400 RPM"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust6rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("harddrive", "LOLOL").equals("Seagate 1TB 7200 RPM"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust6rad4);
			radGroup1.setChecked(true);
		}
		else if((get.getString("harddrive", "LOLOL").equals("Seagate 3TB 7200 RPM"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust6rad5);
			radGroup1.setChecked(true);
		}
	
	}
    
    private void openNext(){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust6rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust6rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust6rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust6rad4);
		RadioButton getRate5 = (RadioButton) findViewById(R.id.cust6rad5);
		
		if(getRate.isChecked()){
			edit.putString("harddrive","Seagate 320GB 7200 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(95.99) );
			edit.commit();
		}
		else if(getRate2.isChecked()){
			edit.putString("harddrive","Hitachi 500GB 7200 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(99.99) );
			edit.commit();
		}
		else if(getRate3.isChecked()){
			edit.putString("harddrive","Seagate 640GB 5400 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(115.99) );
			edit.commit();
		}
		else if(getRate4.isChecked()){
			edit.putString("harddrive","Seagate 1TB 7200 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(219.99) );
			edit.commit();
		}
		else if(getRate5.isChecked()){
			edit.putString("harddrive","Seagate 3TB 7200 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(429.99) );
			edit.commit();
		}
		
    	Intent intent = new Intent(Configure6Activity.this,Configure7Activity.class);
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
        dialog.setContentView(R.layout.custom6help);
        dialog.setTitle("Why is HDD Selection Important?");
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

		dialog.setContentView(R.layout.custom6image1);
		dialog.setTitle("Seagate Barracuda 320GB 7200RPM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust6imgview1);
		image.setImageResource(R.drawable.hdd1);
		
        Button button = (Button) dialog.findViewById(R.id.cust6img1close);
        
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

		dialog.setContentView(R.layout.custom6image2);
		dialog.setTitle("Hitachi 500GB 7200RPM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust6imgview2);
		image.setImageResource(R.drawable.hdd2);
		
        Button button = (Button) dialog.findViewById(R.id.cust6img2close);
        
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

		dialog.setContentView(R.layout.custom6image3);
		dialog.setTitle("Seagate Momentus 640GB 5400RPM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust6imgview3);
		image.setImageResource(R.drawable.hdd3);
		
        Button button = (Button) dialog.findViewById(R.id.cust6img3close);
        
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

		dialog.setContentView(R.layout.custom6image4);
		dialog.setTitle("Seagate Constellation 1TB 7200RPM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust6imgview4);
		image.setImageResource(R.drawable.hdd4);
		
        Button button = (Button) dialog.findViewById(R.id.cust6img4close);
        
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

		dialog.setContentView(R.layout.custom6image5);
		dialog.setTitle("Seagate Barracuda 3TB XT 7200 RPM");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust6imgview5);
		image.setImageResource(R.drawable.hdd5);
		
        Button button = (Button) dialog.findViewById(R.id.cust6img5close);
        
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

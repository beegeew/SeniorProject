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


public class Configure10Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.custom10);
		
        final Button prebuilt = (Button) findViewById(R.id.custom10_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom10_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure10Activity.this,Configure9Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		final Button next = (Button) findViewById(R.id.custom10_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		final Button view1 = (Button) findViewById(R.id.cust10img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust10img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust10img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		final Button view4 = (Button) findViewById(R.id.cust10img4);
		view4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg4();
			}
		});
		final Button view5 = (Button) findViewById(R.id.cust10img5);
		view5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg5();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("powersupply", "LOLOL").equals("COOLMAX 650W ATX12V"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust10rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("powersupply", "LOLOL").equals("OCZ ModXStream Pro 700W"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust10rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("powersupply", "LOLOL").equals("Corsair CMPSU 750W"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust10rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("powersupply", "LOLOL").equals("Corsair Enthusiast 850W"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust10rad4);
			radGroup1.setChecked(true);
		}
		else if((get.getString("powersupply", "LOLOL").equals("PC Power-Turbo-Cool 1200W"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust10rad5);
			radGroup1.setChecked(true);
		}
	}
    
    private void openNext(){
    	SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust10rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust10rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust10rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust10rad4);
		RadioButton getRate5 = (RadioButton) findViewById(R.id.cust10rad5);
		
		if(getRate.isChecked()){
			edit.putString("powersupply","COOLMAX 650W ATX12V" );
			edit.commit();
			edit.putFloat("psuPrice",(float)(54.99) );
			edit.commit();
			
		}
		else if(getRate2.isChecked()){
			edit.putString("powersupply","OCZ ModXStream Pro 700W" );
			edit.commit();
			edit.putFloat("psuPrice",(float)89.99 );
			edit.commit();
		}
		else if(getRate3.isChecked()){
			edit.putString("powersupply","Corsair CMPSU 750W" );
			edit.commit();
			edit.putFloat("psuPrice",(float)129.99 );
			edit.commit();

		}
		else if(getRate4.isChecked()){
			edit.putString("powersupply","Corsair Enthusiast 850W");
			edit.commit();
			edit.putFloat("psuPrice",(float)149.99 );
			edit.commit();

		}
    	
		else if(getRate5.isChecked()){
			edit.putString("powersupply","PC Power-Turbo-Cool 1200W");
			edit.commit();
			edit.putFloat("psuPrice",(float)449.99 );
			edit.commit();

		}
    	Intent intent = new Intent(Configure10Activity.this,Configure11Activity.class);
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
        dialog.setContentView(R.layout.custom10help);
        dialog.setTitle("Why is a PSU important?");
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

		dialog.setContentView(R.layout.custom10image1);
		dialog.setTitle("Coolmax NW-650B 650W");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust10imgview1);
		image.setImageResource(R.drawable.psu1);
		
        Button button = (Button) dialog.findViewById(R.id.cust10img1close);
        
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

		dialog.setContentView(R.layout.custom10image2);
		dialog.setTitle("OCZ ModXStream 700W");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust10imgview2);
		image.setImageResource(R.drawable.psu2);
		
        Button button = (Button) dialog.findViewById(R.id.cust10img2close);
        
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

		dialog.setContentView(R.layout.custom10image3);
		dialog.setTitle("Corsair 750W");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust10imgview3);
		image.setImageResource(R.drawable.psu3);
		
        Button button = (Button) dialog.findViewById(R.id.cust10img3close);
        
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

		dialog.setContentView(R.layout.custom10image4);
		dialog.setTitle("Corsair 850TX 850W");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust10imgview4);
		image.setImageResource(R.drawable.psu4);
		
        Button button = (Button) dialog.findViewById(R.id.cust10img4close);
        
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

		dialog.setContentView(R.layout.custom10image5);
		dialog.setTitle("PC Power and Cooling Turbo-Cool 1200W");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust10imgview5);
		image.setImageResource(R.drawable.psu5);
		
        Button button = (Button) dialog.findViewById(R.id.cust10img5close);
        
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

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


public class Configure4Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.custom4);
		
        final Button prebuilt = (Button) findViewById(R.id.custom4_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom4_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(Configure4Activity.this,Configure3Activity.class);
            	startActivity(intent);
        		finish();
        	}
		});
		final Button next = (Button) findViewById(R.id.custom4_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openNext();
        		finish();
        	}   
        });
		final Button view1 = (Button) findViewById(R.id.cust4img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust4img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust4img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		final Button view4 = (Button) findViewById(R.id.cust4img4);
		view4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg4();
			}
		});
		final Button view5 = (Button) findViewById(R.id.cust4img5);
		view5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg5();
			}
		});
		
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("ram", "LOLOL").equals("G.skill 2GB DDR3 SDRAM DDR3"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust4rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("ram", "LOLOL").equals("G.skill 4GB SDRAM DDR3"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust4rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("ram", "LOLOL").equals("G.skill 8GB SDRAM DDR3"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust4rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("ram", "LOLOL").equals("G.skill 8GB SDRAM DDR3"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust4rad4);
			radGroup1.setChecked(true);
		}
		else if((get.getString("ram", "LOLOL").equals("G.skill 8GB SDRAM DDR3 800"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust4rad5);
			radGroup1.setChecked(true);
		}
	}
    
	
    private void openNext(){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RadioButton getRate = (RadioButton) findViewById(R.id.cust4rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust4rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust4rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust4rad4);
		RadioButton getRate5 = (RadioButton) findViewById(R.id.cust4rad5);
		
		if(getRate.isChecked()){
			edit.putString("ram","G.skill 2GB DDR3 SDRAM DDR3" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(24.99) );
			edit.commit();
		}
		else if(getRate2.isChecked()){
			edit.putString("ram","G.skill 4GB SDRAM DDR3" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(29.99) );
			edit.commit();
		}
		else if(getRate3.isChecked()){
			edit.putString("ram","G.skill 8GB SDRAM DDR3" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(42.99) );
			edit.commit();
		}
		else if(getRate4.isChecked()){
			edit.putString("ram","G.skill 8GB SDRAM DDR3" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(44.99) );
			edit.commit();
		}
		else if(getRate5.isChecked()){
			edit.putString("ram","G.skill 8GB SDRAM DDR3 800" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(159.99) );
			edit.commit();
		}
		
    	Intent intent = new Intent(Configure4Activity.this,Configure5Activity.class);
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
        dialog.setContentView(R.layout.custom4help);
        dialog.setTitle("Why is RAM Selection Important?");
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

		dialog.setContentView(R.layout.custom4image1);
		dialog.setTitle("G.SKILL 2GB (2x1GB) ");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust4imgview1);
		image.setImageResource(R.drawable.ram1);
		
        Button button = (Button) dialog.findViewById(R.id.cust4img1close);
        
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

		dialog.setContentView(R.layout.custom4image2);
		dialog.setTitle("G.SKILL Ripjaws 4GB (2x2GB)");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust4imgview2);
		image.setImageResource(R.drawable.ram2);
		
        Button button = (Button) dialog.findViewById(R.id.cust4img2close);
        
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

		dialog.setContentView(R.layout.custom4image3);
		dialog.setTitle("G.SKILL Sniper 8GB (2x4GB)");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust4imgview3);
		image.setImageResource(R.drawable.ram3);
		
        Button button = (Button) dialog.findViewById(R.id.cust4img3close);
        
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

		dialog.setContentView(R.layout.custom4image4);
		dialog.setTitle("G.SKILL Ripjaws 8GB (2x4GB)");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust4imgview4);
		image.setImageResource(R.drawable.ram4);
		
        Button button = (Button) dialog.findViewById(R.id.cust4img4close);
        
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

		dialog.setContentView(R.layout.custom4image5);
		dialog.setTitle("G.SKILL 8GB(2x4GB)");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust4imgview5);
		image.setImageResource(R.drawable.ram5);
		
        Button button = (Button) dialog.findViewById(R.id.cust4img5close);
        
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

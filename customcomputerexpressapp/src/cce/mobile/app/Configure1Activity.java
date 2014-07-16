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


public class Configure1Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.custom1);
		
		
		
        final Button prebuilt = (Button) findViewById(R.id.custom1_help);
        prebuilt.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		openPopup();
        	}   
        });
		
		final Button main = (Button) findViewById(R.id.custom1_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		
		final Button next = (Button) findViewById(R.id.custom1_next);
        next.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		RadioGroup radgroup1 = (RadioGroup) findViewById(R.id.custom1_rg);
        		if ((int)radgroup1.getCheckedRadioButtonId()==-1){
        			showAlert();
        		}
        		openNext();
        		finish();
        	}   
        });
		
		final Button view1 = (Button) findViewById(R.id.cust1img1);
		view1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg1();
			}
		});
		final Button view2 = (Button) findViewById(R.id.cust1img2);
		view2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg2();
			}
		});
		final Button view3 = (Button) findViewById(R.id.cust1img3);
		view3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg3();
			}
		});
		final Button view4 = (Button) findViewById(R.id.cust1img4);
		view4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg4();
			}
		});
		final Button view5 = (Button) findViewById(R.id.cust1img5);
		view5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popImg5();
			}
		});
		
		

		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		if((get.getString("case", "LOLOL").equals("APEX Vortex 3610"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust1rad1);
			radGroup1.setChecked(true);
		}
		else if((get.getString("case", "LOLOL").equals("Antec Three Hundred"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust1rad2);
			radGroup1.setChecked(true);
		}
		else if((get.getString("case", "LOLOL").equals("Antec Nine Hundred"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust1rad3);
			radGroup1.setChecked(true);
		}
		else if((get.getString("case", "LOLOL").equals("Antec Lanboy Metal"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust1rad4);
			radGroup1.setChecked(true);
		}
		else if((get.getString("case", "LOLOL").equals("Silverstone Fortress Series"))){
			RadioButton radGroup1 = (RadioButton) findViewById(R.id.cust1rad5);
			radGroup1.setChecked(true);
		}
	}
    
    private void openNext(){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		//RadioGroup getRate = (RadioGroup) findViewById(R.id.custom1_rg);
		RadioButton getRate = (RadioButton) findViewById(R.id.cust1rad1);
		RadioButton getRate2 = (RadioButton) findViewById(R.id.cust1rad2);
		RadioButton getRate3 = (RadioButton) findViewById(R.id.cust1rad3);
		RadioButton getRate4 = (RadioButton) findViewById(R.id.cust1rad4);
		RadioButton getRate5 = (RadioButton) findViewById(R.id.cust1rad5);
		
		if(getRate.isChecked()){
			edit.putString("case","APEX Vortex 3610" );
			edit.commit();

			edit.putFloat("casePrice",(float)(19.99) );
			edit.commit();
		}
		else if(getRate2.isChecked()){
			edit.putString("case","Antec Three Hundred" );
			edit.commit();

			edit.putFloat("casePrice",(float)(54.99) );
			edit.commit();
		}
		else if(getRate3.isChecked()){
			edit.putString("case","Antec Nine Hundred" );
			edit.commit();

			edit.putFloat("casePrice",(float)(99.99) );
			edit.commit();
		}
		else if(getRate4.isChecked()){
			edit.putString("case","Antec Lanboy Metal" );
			edit.commit();

			edit.putFloat("casePrice",(float)(179.99) );
			edit.commit();
		}
		else if(getRate5.isChecked()){
			edit.putString("case","Silverstone Fortress Series" );
			edit.commit();

			edit.putFloat("casePrice",(float)(249.99) );
			edit.commit();
		}
    	
    	
    	Intent intent = new Intent(Configure1Activity.this,Configure2Activity.class);
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
        dialog.setContentView(R.layout.custom1help);
        dialog.setTitle("Why is Case Selection Important?");
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

		dialog.setContentView(R.layout.custom1image1);
		dialog.setTitle("    APEX Vortex 3610 Black Metal");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust1imgview1);
		image.setImageResource(R.drawable.case1);
		
        Button button = (Button) dialog.findViewById(R.id.cust1img1close);
        
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

		dialog.setContentView(R.layout.custom1image2);
		dialog.setTitle(" Antec Three Hundred Black Steel");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust1imgview2);
		image.setImageResource(R.drawable.case2);
		
        Button button = (Button) dialog.findViewById(R.id.cust1img2close);
        
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

		dialog.setContentView(R.layout.custom1image3);
		dialog.setTitle(" Antec Nine Hundred Black Steel");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust1imgview3);
		image.setImageResource(R.drawable.case3);
		
        Button button = (Button) dialog.findViewById(R.id.cust1img3close);
        
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

		dialog.setContentView(R.layout.custom1image4);
		dialog.setTitle("     Antec Lanboy Air Red/Black");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust1imgview4);
		image.setImageResource(R.drawable.case4);
		
        Button button = (Button) dialog.findViewById(R.id.cust1img4close);
        
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

		dialog.setContentView(R.layout.custom1image5);
		dialog.setTitle("      Silverstone Fortress Series");
        dialog.setCancelable(true);

		ImageView image = (ImageView) dialog.findViewById(R.id.cust1imgview5);
		image.setImageResource(R.drawable.case5);
		
        Button button = (Button) dialog.findViewById(R.id.cust1img5close);
        
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

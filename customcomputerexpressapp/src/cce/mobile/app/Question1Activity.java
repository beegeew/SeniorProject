package cce.mobile.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Question1Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.quest1);
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		int rating = get.getInt("quest1", 0);
		setRating(rating);

		
		final Button main = (Button) findViewById(R.id.qs1_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		
		final Button next = (Button) findViewById(R.id.qs1_next);
		next.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				RatingBar getRate = (RatingBar) findViewById(R.id.qs1_rb);
				if ((int) getRate.getRating() == 0) {
					showAlert();
				} else {
					goNext();
					finish();
				}
			}
		});
	}

	public void goNext()
	{
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RatingBar getRate=(RatingBar)findViewById(R.id.qs1_rb);
		edit.putInt("quest1", (int) getRate.getRating());
		edit.commit();
		
		if(getRate.getRating()==1){
			edit.putString("cpu","Intel Celeron 2.4Ghz Dual-Core" );
			edit.commit();
			edit.putString("motherboard","Biostar LGA 1155 ATX" );
			edit.commit();
			edit.putFloat("moboPrice",(float)(49.99) );
			edit.commit();
			edit.putFloat("cpuPrice",(float)(56.99) );
			edit.commit();
			edit.putString("cooling","Cooling: None" );
			edit.commit();
			edit.putFloat("coolingPrice",(float)0.0 );
			edit.commit();
			
		}
		else if(getRate.getRating()==2){
			edit.putString("cpu","Intel Core i5-2500 3.3 Ghz" );
			edit.commit();
			edit.putString("motherboard","Gigabyte LGA 115 HDMI SATA" );
			edit.commit();
			edit.putFloat("moboPrice",(float)104.99 );
			edit.commit();
			edit.putFloat("cpuPrice",(float)209.99 );
			edit.commit();
			edit.putString("cooling","Cooling: None" );
			edit.commit();
			edit.putFloat("coolingPrice",(float)0.0 );
			edit.commit();
		}
		else if(getRate.getRating()==3){
			edit.putString("cpu","Intel Core i5-2500K 3.3GHz" );
			edit.commit();
			edit.putString("motherboard","Asus LGA 1155 HDMI SATA" );
			edit.commit();
			edit.putString("cooling","Zalman 2 Ball CPU Cooler" );
			edit.commit();
			edit.putFloat("moboPrice",(float)209.99 );
			edit.commit();
			edit.putFloat("cpuPrice",(float)224.99 );
			edit.commit();
			edit.putFloat("coolingPrice",(float)47.99 );
			edit.commit();

		}
		else if(getRate.getRating()==4){
			edit.putString("cpu","Intel Core i7-2600K 3.4GHz" );
			edit.commit();
			edit.putString("motherboard","Gigabyte LGA 1155 Intel SATA 6Gb/s");
			edit.commit();
			edit.putString("cooling","Corsair CPU Cooler" );
			edit.commit();
			edit.putFloat("moboPrice",(float)299.99 );
			edit.commit();
			edit.putFloat("cpuPrice",(float)319.99 );
			edit.commit();
			edit.putFloat("coolingPrice",(float)71.99 );
			edit.commit();
		}
		else if(getRate.getRating()==5){
			edit.putString("cpu","Intel Core i7-2700K 3.5GHz" );
			edit.commit();
			edit.putString("motherboard","Gigabyte LGA 1155 Intel Z68 SATA 6Gb/s" );
			edit.commit();
			edit.putString("cooling","Corsair H100 Liquid CPU Cooler" );
			edit.commit();
			edit.putFloat("moboPrice",(float)349.99 );
			edit.commit();
			edit.putFloat("cpuPrice",(float)369.99 );
			edit.commit();
			edit.putFloat("coolingPrice",(float)119.99 );
			edit.commit();
		}
		
		Intent intent = new Intent(Question1Activity.this,Question2Activity.class);
    	startActivity(intent);
	}
	
	public void setRating(int newRating) {
		RatingBar rate=(RatingBar)findViewById(R.id.qs1_rb);
		rate.setRating(newRating);		
	}
	
	public void showAlert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("You must select a rating before moving on.")
		       .setCancelable(false)
		       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
		AlertDialog alert = builder.create();
		alert.show();
	}
}

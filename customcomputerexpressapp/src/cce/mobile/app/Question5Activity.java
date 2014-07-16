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

public class Question5Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.quest5);
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		int rating = get.getInt("quest5", 5);
		setRating(rating);
		
		final Button main = (Button) findViewById(R.id.qs5_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
	
		final Button next = (Button) findViewById(R.id.qs5_next);
		next.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				RatingBar getRate = (RatingBar) findViewById(R.id.qs5_rb);
				if ((int) getRate.getRating() == 0) {
					showAlert();
				} else {
					goNext();
					finish();
				}
			}
		});
		
		final Button prev = (Button) findViewById(R.id.qs5_prev);
		prev.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goPrev();
				finish();
			}
		});
	}
	
	public void goNext()
	{
		newRating();
		
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RatingBar getRate=(RatingBar)findViewById(R.id.qs5_rb);
		edit.putInt("quest5", (int) getRate.getRating());
		edit.commit();
		
		if(getRate.getRating()==1){
			edit.putString("ssd","SSD: None" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(0.0) );
			edit.commit();
		}
		else if(getRate.getRating()==2){
			edit.putString("ssd","SSD: None" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(0.0) );
			edit.commit();
		}
		else if(getRate.getRating()==3){
			edit.putString("ssd","OCZ Vertex 60GB SATA II" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(99.99) );
			edit.commit();
		}
		else if(getRate.getRating()==4){
			edit.putString("ssd","Intel 320 120GB SATA II" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(239.99) );
			edit.commit();
		}
		else if(getRate.getRating()==5){
			edit.putString("ssd","OCZ RevoDrive 3 960GB" );
			edit.commit();

			edit.putFloat("ssdPrice",(float)(3199.99) );
			edit.commit();
		}
		
		Intent intent = new Intent(Question5Activity.this,Question6Activity.class);
		startActivity(intent);
	}
	
	public void goPrev()
	{
		newRating();
		Intent intent = new Intent(Question5Activity.this,Question4Activity.class);
		startActivity(intent);
	}
	
	public void setRating(int newRating) {
		RatingBar rate=(RatingBar)findViewById(R.id.qs5_rb);
		rate.setRating(newRating);		
	}
	
	public void newRating() {
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RatingBar getRate=(RatingBar)findViewById(R.id.qs5_rb);
		int newRate = (int) getRate.getRating();
		if (newRate > 0) {
			edit.putInt("quest5", newRate);
			edit.commit();
		}
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

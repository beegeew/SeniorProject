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

public class Question4Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.quest4);
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		int rating = get.getInt("quest4", 4);
		setRating(rating);
		
		final Button main = (Button) findViewById(R.id.qs4_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
	
		final Button next = (Button) findViewById(R.id.qs4_next);
		next.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				RatingBar getRate = (RatingBar) findViewById(R.id.qs4_rb);
				if ((int) getRate.getRating() == 0) {
					showAlert();
				} else {
					goNext();
					finish();
				}
			}
		});
		
		final Button prev = (Button) findViewById(R.id.qs4_prev);
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
		RatingBar getRate=(RatingBar)findViewById(R.id.qs4_rb);
		edit.putInt("quest4", (int) getRate.getRating());
		edit.commit();
		
		if(getRate.getRating()==1){
			edit.putString("harddrive","Seagate 320GB 7200 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(95.99) );
			edit.commit();
		}
		else if(getRate.getRating()==2){
			edit.putString("harddrive","Hitachi 500GB 7200 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(99.99) );
			edit.commit();
		}
		else if(getRate.getRating()==3){
			edit.putString("harddrive","Seagate 640GB 5400 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(115.99) );
			edit.commit();
		}
		else if(getRate.getRating()==4){
			edit.putString("harddrive","Seagate 1TB 7200 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(219.99) );
			edit.commit();
		}
		else if(getRate.getRating()==5){
			edit.putString("harddrive","Seagate 3TB 7200 RPM" );
			edit.commit();

			edit.putFloat("hddPrice",(float)(429.99) );
			edit.commit();
		}

		
		Intent intent = new Intent(Question4Activity.this,Question5Activity.class);
		startActivity(intent);
	}
	
	public void goPrev()
	{
		newRating();
		Intent intent = new Intent(Question4Activity.this,Question3Activity.class);
		startActivity(intent);
	}
	
	public void setRating(int newRating) {
		RatingBar rate=(RatingBar)findViewById(R.id.qs4_rb);
		rate.setRating(newRating);		
	}
	
	public void newRating() {
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RatingBar getRate=(RatingBar)findViewById(R.id.qs4_rb);
		int newRate = (int) getRate.getRating();
		if (newRate > 0) {
			edit.putInt("quest4", newRate);
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

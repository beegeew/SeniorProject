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

public class Question3Activity extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.quest3);
		SharedPreferences get = getSharedPreferences(PREFS_NAME,0);
		int rating = get.getInt("quest3", 3);
		setRating(rating);
		
		final Button main = (Button) findViewById(R.id.qs3_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
	
		final Button next = (Button) findViewById(R.id.qs3_next);
		next.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				RatingBar getRate = (RatingBar) findViewById(R.id.qs3_rb);
				if ((int) getRate.getRating() == 0) {
					showAlert();
				} else {
					goNext();
					finish();
				}
			}
		});
		
		final Button prev = (Button) findViewById(R.id.qs3_prev);
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
		RatingBar getRate=(RatingBar)findViewById(R.id.qs3_rb);
		edit.putInt("quest3", (int) getRate.getRating());
		edit.commit();
		
		if(getRate.getRating()==1){
			edit.putString("ram","G.skill 2GB DDR3 SDRAM DDR3" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(24.99) );
			edit.commit();
		}
		else if(getRate.getRating()==2){
			edit.putString("ram","G.skill 4GB SDRAM DDR3" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(29.99) );
			edit.commit();
		}
		else if(getRate.getRating()==3){
			edit.putString("ram","G.skill 8GB SDRAM DDR3" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(42.99) );
			edit.commit();
		}
		else if(getRate.getRating()==4){
			edit.putString("ram","G.skill 8GB SDRAM DDR3" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(44.99) );
			edit.commit();
		}
		else if(getRate.getRating()==5){
			edit.putString("ram","G.skill 8GB SDRAM DDR3 800" );
			edit.commit();

			edit.putFloat("ramPrice",(float)(159.99) );
			edit.commit();
		}
		Intent intent = new Intent(Question3Activity.this,Question4Activity.class);
		startActivity(intent);
	}
	
	public void goPrev()
	{
		newRating();
		Intent intent = new Intent(Question3Activity.this,Question2Activity.class);
		startActivity(intent);
	}
	
	public void setRating(int newRating) {
		RatingBar rate=(RatingBar)findViewById(R.id.qs3_rb);
		rate.setRating(newRating);		
	}
	
	public void newRating() {
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
		RatingBar getRate=(RatingBar)findViewById(R.id.qs3_rb);
		int newRate = (int) getRate.getRating();
		if (newRate > 0) {
			edit.putInt("quest3", newRate);
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

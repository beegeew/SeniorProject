package cce.mobile.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class PrebuiltMainActivity extends Activity {
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.prebuiltcomputers);
		
		final Button main = (Button) findViewById(R.id.pbm_main);
		main.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		finish();
        	}
		});
		final Button basic = (Button) findViewById(R.id.pbm_basic);
		basic.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				openBasic();
				finish();
			}
		});
		final Button media = (Button) findViewById(R.id.pbm_media);
		media.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				openMedia();
				finish();
			}
		});
		final Button gaming = (Button) findViewById(R.id.pbm_gaming);
		gaming.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				openGaming();
				finish();
			}
		});
		final Button highperformance = (Button) findViewById(R.id.pbm_highperformance);
		highperformance.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				openHighP();
				finish();
			}
		});
		final Button extreme = (Button) findViewById(R.id.pbm_extreme);
		extreme.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				openExtreme();
				finish();
			}
		});
	}
	public void openBasic() {
		Intent intent = new Intent(PrebuiltMainActivity.this,Prebuilt1Activity.class);
		startActivity(intent);
	}
	public void openMedia() {
		Intent intent = new Intent(PrebuiltMainActivity.this,Prebuilt2Activity.class);
		startActivity(intent);
	}
	public void openGaming() {
		Intent intent = new Intent(PrebuiltMainActivity.this,Prebuilt3Activity.class);
		startActivity(intent);
	}
	public void openHighP() {
		Intent intent = new Intent(PrebuiltMainActivity.this,Prebuilt4Activity.class);
		startActivity(intent);
	}
	public void openExtreme() {
		Intent intent = new Intent(PrebuiltMainActivity.this,Prebuilt5Activity.class);
		startActivity(intent);
	}
}

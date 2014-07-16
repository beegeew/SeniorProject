package cce.mobile.app;

import java.io.*;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.widget.RatingBar;

public class CCEApp extends Activity {
	public static final String PREFS_NAME = "CCEPrefsFile";
	//database parser use
	private String orderStatus;
	private String orderId;
	private String delims;
	private String[] data;
	private String strLine;
	
	CCEApp(){
		this.orderStatus="";
		this.orderId="";
		this.delims=",";
		this.data=null;	
		//this.setOrder("TESTING");
		//this.setStatus("TESTING");
	}
	
	public void openFile(String userOrder){
		
		 try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("database");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
				  
				  data = strLine.split(delims);
				  if(userOrder.equals(data[0])){
					orderId=userOrder;  
					orderStatus=data[1];
					this.setOrder(this.orderId);
					this.setStatus(this.orderStatus);
				  }
			  }
			  
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }	
		
		
	}
	
	public String getOrderId(){
		return this.orderId;
	}
	
	public String getorderStatus(){
		return this.orderStatus;		
	}
	
	public void setOrder(String newOrderId){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
			edit.putString("orderId", newOrderId);
			edit.commit();

	}
	
	public void setStatus(String newOrderStatus){
		SharedPreferences questVals = getSharedPreferences(PREFS_NAME,0);
		SharedPreferences.Editor edit = questVals.edit();
			edit.putString("statusId", newOrderStatus);
			edit.commit();
	}

}

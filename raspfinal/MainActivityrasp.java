package com.example.raspapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivityrasp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityrasp);
    new LongOperation().execute();
    }
    class LongOperation  extends AsyncTask<Void, Void, String>
	   {
    	InputStream is=null;String result=null;
private ProgressDialog Dialog = new ProgressDialog(MainActivityrasp.this);
	 protected void onPreExecute() {
       // NOTE: You can call UI Element here.
        
       //UI Element
      // uiUpdate.setText("Output : ");
       Dialog.setMessage("Downloading source..");
       Dialog.show();
   }
protected String doInBackground(Void... arg) 
	 {
try{
                HttpClient httpclient = new DefaultHttpClient();
                //Toast.makeText(getApplicationContext(), "s1",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "s1", Toast.LENGTH_SHORT).show();
               // HttpPost httppost = new HttpPost("http://kecitians.tk/sel2.php");
                HttpPost httppost = new HttpPost("http://10.0.2.2/Raspfin.php");
                //Toast.makeText(getApplicationContext(), "s2", Toast.LENGTH_SHORT).show();
                HttpResponse response = httpclient.execute(httppost);
                //Toast.makeText(getApplicationContext(), "s3", Toast.LENGTH_SHORT).show();
                HttpEntity entity = response.getEntity();
                is = entity.getContent();

                Log.e("log_tag", "connection success ");
             //   Toast.makeText(getApplicationContext(), "pass", Toast.LENGTH_SHORT).show();
        }
     catch(Exception e)
        {
                Log.e("log_tag", "Error in http connection "+e.toString());
                //Toast.makeText(getApplicationContext(), "Connection fail", Toast.LENGTH_SHORT).show();

        }
try
        {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null)
                {
                        sb.append(line + "\n");
                      //  Toast.makeText(getApplicationContext(), "Input Reading pass", Toast.LENGTH_SHORT).show();
                }
                is.close();

                result=sb.toString();
                //return result;
                //Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();

        }
        catch(Exception e)
        {
      	  
               Log.e("log_tag", "Error converting result "+e.toString());
           // Toast.makeText(getApplicationContext(), " Input reading fail", Toast.LENGTH_SHORT).show();

        }
			return result;

       
	 }
protected void onPostExecute(String result) 
	 {
		 //spinner.setOnItemSelectedListener(Coall.this);
	   //     int lt;
			//	int List = lt;Object String = get(); int categories = ArrayList&lt;String&get();();
		
		 Dialog.dismiss();
		 
	/*	 try
		 {
}
		 
		 catch(JSONException e)
       {
               Log.e("log_tag", "Error parsing data "+e.toString());
               Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
       }
       catch(NullPointerException e)
       {
       	
       }*/
}
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activityrasp, menu);
        return true;
    }
    
}

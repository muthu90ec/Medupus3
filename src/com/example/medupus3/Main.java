package com.example.medupus3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity  {

    EditText etUser, etPass;
    Button bLogin;
    int flag=0;

    //Create string variables that will have the input assigned to them
    String username, password,s;
    static String first_name, last_name;

    //Create a HTTPClient as the form container
    HttpClient httpclient;

    //Use HTTP POST method
    HttpPost httppost;

    //Create an array list for the input data to be sent
    ArrayList<NameValuePair> nameValuePairs;

    //Create a HTTP Response and HTTP Entity
    HttpResponse response;
    HttpEntity entity;
    

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

    }



    private void initialise() {
        etUser = (EditText) findViewById(R.id.userName);
        etPass = (EditText) findViewById(R.id.passWord);
        bLogin = (Button) findViewById(R.id.bSubmit);
        
        //Now to set an onClickListener
        //bLogin.setOnClickListener(this);
        bLogin.setOnClickListener(new View.OnClickListener() {
			 
            @Override
            public void onClick(View view) {
            	
            	
            	 new MyAsyncTask().execute();
            }
        });
	
        
            	
    }

   /* public void onClick(View v)  {
        // This is where we will be working now

        new MyAsyncTask().execute();

    }//END onClick()*/

    private static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }//END convertStreamToString()



    private class MyAsyncTask extends AsyncTask<Void, Void, Void>
{
        //ProgressDialog mProgressDialog;
    	String test,u,p,number;
    	int num=0;
        @Override
        
        protected void onPostExecute(Void result) {
            //mProgressDialog.dismiss();
        	etUser.setText("");
        	etPass.setText("");
        	if(num==1){
        		Toast.makeText(getBaseContext(), "Successful", Toast.LENGTH_SHORT).show();
        		homePageExecute();
        	}
        	else{
        		Toast.makeText(getBaseContext(), "Invalid Login Details", Toast.LENGTH_SHORT).show();
        	}
        	
        }

        @Override
        protected void onPreExecute() {
        	 username = etUser.getText().toString();
             password = etPass.getText().toString();

            //mProgressDialog = ProgressDialog.show(MainActivity.this, "Loading...", "Data is Loading...");
        }

        @Override
        protected Void doInBackground(Void... params) {
        	
            //Create new default HTTPClient
            httpclient = new DefaultHttpClient();

            //Create new HTTP POST with URL to php file as parameter
            httppost = new HttpPost("http://10.0.2.2/project_test/get_product_details3.php"); 
            
            //Assign input text to strings
           


            //Next block of code needs to be surrounded by try/catch block for it to work
            try {
            	flag=0;
            	num=0;
                //Create new Array List
                nameValuePairs = new ArrayList<NameValuePair>(2);

                //place them in an array list
                nameValuePairs.add(new BasicNameValuePair("username", username));
                nameValuePairs.add(new BasicNameValuePair("password", password));

                //Add array list to http post
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                
                //assign executed form container to response
                response = httpclient.execute(httppost); //response from the PHP file
               
                //check status code, need to check status code 200
                if(response.getStatusLine().getStatusCode() == 200){

                    //assign response entity to http entity
                    entity = response.getEntity();
                    String responseBody = EntityUtils.toString(response.getEntity());
                    test=responseBody;
                    
                   JSONObject obj = new JSONObject(responseBody);
                   num=obj.getInt("success");
                   number=Integer.toString(num);
                   JSONArray data = obj.getJSONArray("products");
                    for(int i=0;i<data.length();i++){
                    JSONObject eachData = data.getJSONObject(i);
                      first_name=eachData.getString("name");
                      last_name=eachData.getString("namelast");
                      u=eachData.getString("mail");
                      p=eachData.getString("class");
                    }
                                          

                }


            } catch(Exception e){
            	
            	Log.e("log_txt", "Error parsing data " + e.toString());
                
            }



           return null;
        }
    }



	public void homePageExecute() {
		// TODO Auto-generated method stub
		Intent i = new Intent(getApplicationContext(), Homepage.class);
		startActivity(i);
		
	}
}
	
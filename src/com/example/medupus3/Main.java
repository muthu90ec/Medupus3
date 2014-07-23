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
import android.widget.Toast;
/*
public class Main extends Activity{
	EditText etUser, etPass;
	Button bLogin;
	String s;
	
	String username, password;
	
	//creating a HTTPClient as the form container
	HttpClient httpclient;
	
	//using the post method
	HttpPost httppost;
	
	//create an array list for the input data to be sent
	ArrayList<NameValuePair> nameValuePairs;
	
	//create a HTTp Response and HTTP entity
	
	HttpResponse response;
	HttpEntity entity;	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initialise();
    }

	private void initialise() {
		// TODO Auto-generated method stub
		etUser = (EditText) findViewById(R.id.userName);
		etPass = (EditText) findViewById(R.id.passWord);
		bLogin = (Button) findViewById(R.id.bSubmit);
		//bLogin.setOnClickListener((android.view.View.OnClickListener) this);
		
		
		bLogin.setOnClickListener(new View.OnClickListener() {
			 
	            @Override
	            public void onClick(View view) {
	            	
	            	//etPass.setText((etUser.getText().toString()));
	                // Launching All products Activity
	               
	            	httpclient = new DefaultHttpClient();
	            	
	            	//create new http post with url to php file as parameter
	            	httppost = new HttpPost("http://10.0.2.2/project_test/get_product_details3.php");
	            	//assign input text to strings
	            	username = etUser.getText().toString();
	                password = etPass.getText().toString();
	                nameValuePairs = new ArrayList<NameValuePair>();
                	//place them in an array list
	                nameValuePairs.add(new BasicNameValuePair("username",username));
	                nameValuePairs.add(new BasicNameValuePair("password", password));
	               doIn
	                try{
	                	//create new array list
	                	
	                	//add array list to http post
	                	//httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                	//create new default httpclient
		            	
		            	
		            	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		            	
		            	//assign executed form container to response
	                	response = httpclient.execute(httppost);
	                	etPass.setText((etUser.getText().toString()));
	                	 
			             /*   
	                	//check status code, 200
	                	//if(response.getStatusLine().getStatusCode()==200){
	                		//assign response entity to http entity
	                		entity = response.getEntity();
	                		//check if entity is not null
	                		//if(entity!=null){
	                			//create new input stream with received datat assigned
	                			InputStream instream = entity.getContent();
	                			//create new JSON object converted data as param
	                			JSONObject jsonResponse = new JSONObject(convertStreamToString(instream));
	                			
	                			//assign json responses to local strings
	                			String retUser = jsonResponse.getString("mail");
	                			String retPass = jsonResponse.getString("class");
	                			s=retUser;
	                			etPass.setText((retUser));
	                			
	                			//validate login
	                			//if(retUser.equals("name0@gmail.com")&& retPass.equals("classa")){
	                				//create a shared preference
	                				SharedPreferences sp = getSharedPreferences("logindetails",0);
	                				//edit share prefe
	                				SharedPreferences.Editor spedit = sp.edit();
	                				
	                				//put the login details in strings
	                				spedit.putString("user",username);
	                				spedit.putString("pass", password);
	                				//close the editor
	                				spedit.commit();
	                				//Display a tost
	                				Toast.makeText(getBaseContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
	                				
	                			
	                			//} else{etPass.setText((retUser));
	                				//display tost saying failed
	                				//Toast.makeText(getBaseContext(),"wrong",Toast.LENGTH_SHORT).show();
	                			//}
	                			
	                		//}
	                	//}*/
	                	
	         /*       }catch(Exception e){
	                	e.printStackTrace();
	                	//display toast
	                	//etPass.setText((s));
	                	Toast.makeText(getBaseContext(),"UNSUCCESSFUL",Toast.LENGTH_SHORT).show();
	                }
	               
	            }
	        });
		
	}//initialise
	
	public class getinternetData extends AsyncTask<String, Void, String>{

	    @Override
	    public String doInBackground(String... params) {
	        HttpClient httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost("http://10.0.2.2/project_test/get_product_details3.php");
	        try{
	            //message.setText("333");
	            HttpResponse response = httpclient.execute(httppost);
	            //message.setText("444");
	            //StatusLine statusLine = response.getStatusLine();
	            //int statusCode = statusLine.getStatusCode();
	            /*if(statusCode == 200){
	                message.setText("Could connect");
	            }else
	                message.setText("Couldn't connect");*/
	 /*       }catch(Exception e){
	            //message.setText(e.toString());
	        }

	        //message.setText("555");
	        return null;
	    }}

	private String convertStreamToString(InputStream is){
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		
		try{
			while((line = reader.readLine())!=null){
				sb.append(line+"\n");
				
			}
		}catch(IOException e){
			e.printStackTrace();
		
		
	} finally{
		try{
			is.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	return sb.toString();
	

	}//End convert stream
	
}//main class
*/
public class Main extends Activity  {

    EditText etUser, etPass;
    Button bLogin;

    //Create string variables that will have the input assigned to them
    String username, password,s;

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
    	String test,u,p;
        @Override
        
        protected void onPostExecute(Void result) {
            //mProgressDialog.dismiss();
        	etUser.setText(u);
        	etPass.setText(p);
        	
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
                    ////Log.d("myApp", "no network");
                    ///u="notworking";
                   JSONObject obj = new JSONObject(responseBody);
                   JSONArray data = obj.getJSONArray("products");
                    for(int i=0;i<data.length();i++){
                    JSONObject eachData = data.getJSONObject(i);
                      u=eachData.getString("mail");
                      p=eachData.getString("class");
                    }
                    
                    //u="hello";
                    //p="world";
                    //JSONArray root = new JSONArray(responseBody);
                    //int x=root.length();
                    //u=responseBody;
                    //JSONArray sessions = root.getJSONArray("root");
                    //for(int i=0;i<root.length();i++){
                    	//HashMap<String,String> map2 = new HashMap<String, String>();
                    	//JSONObject e =root.getJSONObject(i);
                    	//u=e.getString("mail");
                    	//p=e.getString("class");
                    //}

                    //check if entity is not null
                    /*if(entity != null){


                        //Create new input stream with received data assigned
                        InputStream instream = entity.getContent();

                        //Create new JSON Object. assign converted data as parameter.
                        JSONObject jsonResponse = new JSONObject(responseBody/*convertStreamToString(instream)*///);

                        //assign json responses to local strings
                       // String retUser = jsonResponse.getString("mail");//mySQL table field
                       // String retPass = jsonResponse.getString("class");
                        //test=responseBody;
                        //Validate login
                       // if(username.equals(retUser)&& password.equals(retPass)){ //Check whether 'retUser' and 'retPass' matches username/password 

                            //Display a Toast saying login was a success
                            //Toast.makeText(getBaseContext(), "Successful", Toast.LENGTH_SHORT).show();


                        //} else {
                            //Display a Toast saying it failed.

                            //Toast.makeText(getBaseContext(), "Invalid Login Details", Toast.LENGTH_SHORT).show();
                       // }

                    //}*/


                }


            } catch(Exception e){
            	//u="working";

            	Log.e("log_txt", "Error parsing data " + e.toString());
                //Display toast when there is a connection error
                //Change message to something more friendly
              // Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_SHORT).show();
               //Toast.makeText(getBaseContext(), "Connection Error", Toast.LENGTH_SHORT).show();

              // return null;
            }



           return null;
        }
    }
}
	
package com.example.medupus3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity{
	EditText etUser, etPass;
	Button bLogin;
	
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
	               //create new default httpclient
	            	httpclient = new DefaultHttpClient();
	            	
	            	//create new http post with url to php file as parameter
	            	httppost = new HttpPost("http://localhost/project_test/get_product_details3.php");
	            	
	            	//assign input text to strings
	            	username = etUser.getText().toString();
	                password = etPass.getText().toString();
	                
	                
	                try{
	                	//create new array list
	                	nameValuePairs = new ArrayList<NameValuePair>();
	                	//place them in an array list
		                nameValuePairs.add(new BasicNameValuePair("uid",username));
		                nameValuePairs.add(new BasicNameValuePair("pwd", password));
		                
	                	//add array list to http post
	                	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                	
	                	//assign executed form container to response
	                	response = httpclient.execute(httppost);
	                	//check status code, 200
	                	if(response.getStatusLine().getStatusCode()==200){
	                		//assign response entity to http entity
	                		entity = response.getEntity();
	                		//check if entity is not null
	                		if(entity!=null){
	                			//create new input stream with received datat assigned
	                			InputStream instream = entity.getContent();
	                			//create new JSON object converted data as param
	                			JSONObject jsonResponse = new JSONObject(convertStreamToString(instream));
	                			//assign json responses to local strings
	                			String retUser = jsonResponse.getString("mail");
	                			String retPass = jsonResponse.getString("class");
	                			
	                			
	                			
	                			//validate login
	                			if(retUser.equals("name0@gmail.com")&& retPass.equals("classa")){
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
	                				
	                			
	                			} else{
	                				//display tost saying failed
	                				Toast.makeText(getBaseContext(),"wrong",Toast.LENGTH_SHORT).show();
	                			}
	                			
	                		}
	                	}
	                	
	                }catch(Exception e){
	                	e.printStackTrace();
	                	//display toast
	                	Toast.makeText(getBaseContext(),"UNSUCCESSFUL",Toast.LENGTH_SHORT).show();
	                }
	               
	            }
	        });
		
	}//initialise

	private static String convertStreamToString(InputStream is){
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
	
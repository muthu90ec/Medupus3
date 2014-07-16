package com.example.medupus3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity{
	EditText etUser, etPass;
	Button bLogin;
	
	
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
	                // Launching All products Activity
	               
	               
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
	

	}
}
	
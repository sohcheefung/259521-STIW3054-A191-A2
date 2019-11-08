
package com.mycompany;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

public class Json {  
public List<Define> Scrape(){
    
    List<Define> info = new ArrayList<Define>();
       
    try{
        
        JSONArray URL = File.array();
        
        int total = 0;
         
        for (int i=0; i<URL.length(); i++){
            JSONObject JObject = URL.getJSONObject(i);
            String followersurl = JObject.optString("url");
    
            JSONObject URL1 = UrlObject.UrlObject(followersurl+"?access_token=70f3c7b51b3f7d3ab2e3bed7fbfb77dd275f129e");  
            String loginId = URL1.optString("login");
            String totalrepos = URL1.optString("public_repos");
            String totalfollowers = URL1.optString("followers");
            String totalfollowings = URL1.optString("following");
            String totalgists = URL1.optString("public_gists");
            String type = URL1.optString("type");
             
            total++;
            System.out.printf("| %-5s",total);
            Thread run = new Thread(new Thread() {
            @Override
            public void run() {
    
                System.out.printf("| %-19s| %-25s| %-25s| %-25s| %-25s| %-10s| %-15s|\n",loginId,totalrepos,totalfollowers,totalfollowings,totalgists,type,Thread.currentThread().getName());
                info.add(new Define(loginId,totalrepos,totalfollowers,totalfollowings,totalgists,type));
                }
            });
               run.start();
               
            try{
             
                run.join();
                run.sleep(500);
                
            }catch (InterruptedException e){
             e.printStackTrace();
            }
         }
         return info;
         
    }catch (IOException e) {
        
        System.out.println(" ");
        e.printStackTrace();
        
        }
         return null;
  
    }
}
     

 

        


  

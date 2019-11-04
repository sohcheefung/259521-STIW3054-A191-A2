
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
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s| %-15s| %-25s| %-25s| %-25s| %-25s| %-10s| %-15s|\n", "No.","Login ID","Number of Repository","Number of Followers","Number of followings","Number of Gists","Type","Thread Name");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
        
    try{
        
        JSONArray URL = UrlArray.UrlArray("https://api.github.com/users/zhamri/followers");
        int total = 0;
         
        if(URL.length() > 30){
             total = 30;
        }else{
             total = URL.length();
        }
        for (int i=0; i<total; i++){
            JSONObject JObject = URL.getJSONObject(i);
            String followersurl = JObject.optString("url");
    
            JSONObject URL1 = UrlObject.UrlObject(followersurl);
               
            String loginId = URL1.optString("login");
            String totalrepos = URL1.optString("public_repos");
            String totalfollowers = URL1.optString("followers");
            String totalfollowings = URL1.optString("following");
            String totalgists = URL1.optString("public_gists");
            String type = URL1.optString("type");
             
           
            System.out.printf("| %-5s",i);
            Thread run = new Thread(new Runnable() {
            @Override
            public void run() {
    
                System.out.printf("| %-15s| %-25s| %-25s| %-25s| %-25s| %-10s| %-15s|\n",loginId,totalrepos,totalfollowers,totalfollowings,totalgists,type,Thread.currentThread().getName());
                info.add(new Define(loginId,totalrepos,totalfollowers,totalfollowings,totalgists,type));
                }
            });
               run.start();
               
            try{
             
                run.join();
                run.sleep(1000);
                
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
     

 

        


  

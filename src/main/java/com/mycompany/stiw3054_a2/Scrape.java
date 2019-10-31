
package com.mycompany.stiw3054_a2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class Scrape {
 
    public static void main(String[] args) throws ParseException {
        JSONParser parser = new JSONParser();
        try {        
            URL link = new URL("https://api.github.com/users/zhamri/followers"); // URL to Parse
            URLConnection y = link.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(y.getInputStream()));
           
            String inputLine;
            String inputLine1;
            
            while ((inputLine = in.readLine()) != null) {              
                JSONArray o = (JSONArray) parser.parse(inputLine);
               
                // Loop through each item
                for (Object a : o) {
                    JSONObject tutorials = (JSONObject) a;
                    
                     String id = (String) tutorials.get("login");
                     System.out.println("login: "+ id);
                     String followerslink = (String) tutorials.get("url");
                     
                    URL oracle = new URL(followerslink); // URL to Parse
                    URLConnection c  = oracle.openConnection();
                    BufferedReader in1 = new BufferedReader(new InputStreamReader(c.getInputStream()));
                     
                    while ((inputLine1 = in1.readLine()) != null){
                        JSONArray z = (JSONArray) parser.parse(inputLine1);
                         for (Object b : z){
                             JSONObject follower = (JSONObject) b;
                             
                             String followers = (String) follower.get("followers");
                             System.out.println("followers :"+ followers);
                         }
                     }
                         
                    }
                
            } 
           
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
       }
        
    }  
}
        

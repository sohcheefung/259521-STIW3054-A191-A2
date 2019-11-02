
package com.mycompany.stiw3054_a2;

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

    private static String readUrl(Reader read) throws IOException {
        StringBuilder string = new StringBuilder();
        int cp;
        while ((cp = read.read()) != -1) {
            string.append((char) cp);
        }
            return string.toString();
        }

    public static JSONArray readLinkData(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String Text = readUrl(reader);
     
        JSONArray json = new JSONArray(Text);
        return json;
        }   
        finally 
        {
           is.close();
        }
    }

  public List<Data> Scrape() {
      
  try{
        //variable decalration
        int totalrepos = 0;
        int totalfollowers = 0;
        int totalevents = 0;
        int totalsubscriptions = 0;
        
        //url link to scrape data
        JSONArray URL = readLinkData("https://api.github.com/users/jasonway96/followers");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s| %-15s| %-25s| %-25s| %-25s| %-30s| %-15s|\n", "No.","Login ID","Number of Repository","Number of Followers","Number of Events","Number of Subscriptions","Type");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Data> info = new ArrayList<Data>();
    
    for (int i = 0; i <URL.length(); i++){
        
        //get data using specifc key string
        JSONObject JSONObject = URL.getJSONObject(i);
        String followersId = JSONObject.optString("login");
        String reposlink = JSONObject.optString("repos_url");
        String followerslink = JSONObject.optString("followers_url");
        String eventlink = JSONObject.optString("received_events_url");
        String subscriptionslink = JSONObject.optString("subscriptions_url");
        String type = JSONObject.optString("type");
        
        //get data from above link
        JSONArray URL1 = readLinkData(reposlink);
        JSONArray URL2 = readLinkData(followerslink);
        JSONArray URL3 = readLinkData(eventlink);
        JSONArray URL4 = readLinkData(subscriptionslink);
        
        for(int j=0; j<URL1.length(); j++){
            
            JSONObject JSONObject1 = URL1.getJSONObject(j);
            String repos = JSONObject1.optString("id");
            totalrepos = 1 + j++;
        }
        
        for(int k=0; k<URL2.length(); k++){
            
            JSONObject JSONObject2 = URL2.getJSONObject(k);
            String followers = JSONObject2.optString("login");
            totalfollowers = 1 + k++;  
        }
        
         for(int l=0; l<URL3.length(); l++){
             
            JSONObject JSONObject3 = URL3.getJSONObject(l);
            String events = JSONObject3.optString("id");
            totalevents = 1 + l++;  
        }
         
          for(int m=0; m<URL4.length(); m++){
              
            JSONObject JSONObject4 = URL4.getJSONObject(m);
            String subscriptions = JSONObject4.optString("id");
            totalsubscriptions = 1 + m++;  
        }
          
          
          System.out.printf("| %-5s| %-15s| %-25s| %-25s| %-25s| %-30s| %-15s|\n",i,followersId,totalrepos,totalfollowers,totalevents,totalsubscriptions,type);
          
          //add info into array
          info.add(new Data(followersId,totalrepos,totalfollowers,totalevents,totalsubscriptions,type));
        }
        
    return info;
    
   }catch (JSONException e) {
    System.out.println(" ");
    e.printStackTrace();
            }
   catch (IOException e) {
     System.out.println(" ");
    e.printStackTrace();
            
        }
        return null;
    }
}
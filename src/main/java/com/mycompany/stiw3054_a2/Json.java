
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

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
     
      JSONArray json = new JSONArray(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public List<Data> Scrape() {
   try{
    int totalrepos = 0;
    int totalfollowers = 0;
    int totalevents = 0;
    int totalsubscriptions = 0;
    JSONArray json = readJsonFromUrl("https://api.github.com/users/ChanJunLiang/followers");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("| %-5s| %-15s| %-30s| %-25s| %-30s| %-30s| %-15s|\n", "No.","Login ID","Number of Repository","Number of Followers","Number of Events","Number of Subscriptions","Type");
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    List<Data> info = new ArrayList<Data>();
    
    for (int i = 0; i <json.length(); i++){
        JSONObject JSONObject = json.getJSONObject(i);
        String followersId = JSONObject.optString("login");
        String reposlink = JSONObject.optString("repos_url");
        String followerslink = JSONObject.optString("followers_url");
        String eventlink = JSONObject.optString("received_events_url");
        String subscriptionslink = JSONObject.optString("subscriptions_url");
        String type = JSONObject.optString("type");
        
        JSONArray json1 = readJsonFromUrl(reposlink);
        JSONArray json2 = readJsonFromUrl(followerslink);
        JSONArray json3 = readJsonFromUrl(eventlink);
        JSONArray json4 = readJsonFromUrl(subscriptionslink);
        
        for(int j=1; j<json1.length(); j++){
            JSONObject JSONObject1 = json1.getJSONObject(j);
            String repos = JSONObject1.optString("id");
            totalrepos = 1 + j++;
        }
        
        for(int k=1; k<json2.length(); k++){
            JSONObject JSONObject2 = json2.getJSONObject(k);
            String followers = JSONObject2.optString("login");
            totalfollowers = 1 + k++;  
        }
        
         for(int l=1; l<json3.length(); l++){
            JSONObject JSONObject3 = json3.getJSONObject(l);
            String events = JSONObject3.optString("id");
            totalevents = 1 + l++;  
        }
         
          for(int m=1; m<json4.length(); m++){
            JSONObject JSONObject4 = json4.getJSONObject(m);
            String subscriptions = JSONObject4.optString("id");
            totalsubscriptions = 1 + m++;  
        }
          
          
          System.out.printf("| %-5s| %-15s| %-30s| %-25s| %-30s| %-30s| %-15s|\n",i,followersId,totalrepos,totalfollowers,totalevents,totalsubscriptions,type);
          
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
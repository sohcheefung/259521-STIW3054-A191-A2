
package com.mycompany;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Url {
    public static String Url(Reader read) throws IOException {
        StringBuilder string = new StringBuilder();
        int value;
        while ((value = read.read()) != -1) {
            string.append((char) value);
        }
            return string.toString();
        }
    
    
    
   
    
}

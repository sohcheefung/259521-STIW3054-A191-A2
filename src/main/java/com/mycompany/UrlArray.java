
package com.mycompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;


public class UrlArray {
    public static JSONArray UrlArray(String url) throws IOException, JSONException {
        
        InputStream input = new URL(url).openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            String Text = Url.Url(reader);
            JSONArray data = new JSONArray(Text);
            return data;
            }   
            finally 
            {
            input.close();
            }
        }
    }


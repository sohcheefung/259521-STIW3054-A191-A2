
package com.mycompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;


public class UrlObject {
     public static JSONObject UrlObject(String url) throws IOException, JSONException {
    InputStream input = new URL(url).openStream();
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
        String Text = Url.Url(reader);
        JSONObject data1 = new JSONObject(Text);
        return data1;
        }   
        finally 
        {
           input.close();
        }
    }
}

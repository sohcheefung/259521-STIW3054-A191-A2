
package com.mycompany;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.json.JSONArray;

public class File {
    public static JSONArray array() throws IOException{
        
        
        JSONArray URL = UrlArray.UrlArray("https://api.github.com/users/zhamri/followers?access_token=70f3c7b51b3f7d3ab2e3bed7fbfb77dd275f129e");
        return URL;
    
    }
                
}

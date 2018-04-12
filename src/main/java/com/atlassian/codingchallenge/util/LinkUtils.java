/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlassian.codingchallenge.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * //TODO complete this 
 * @author Sanjeev
 * @version 1.0
 */
public class LinkUtils {
    
    public String getTitle(String link){
        
        try{
            URL url = new URL(link);
            URLConnection urlConnection = url.openConnection();
            
            InputStream in = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.defaultCharset()));
            int n = 0, totalRead = 0;
            char[] buf = new char[1024];
            StringBuilder content = new StringBuilder();
 
            // read until EOF or first 8192 characters
            while (totalRead < 8192 && (n = reader.read(buf, 0, buf.length)) != -1) {
                content.append(buf, 0, n);
                totalRead += n;
            }
            reader.close();
        
				Pattern p = Pattern.compile("<title>(.*?)</title>",Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
				        Matcher m = p.matcher(content);
        if(m.find() == true) {
          return m.group(1).replaceAll("[\\s\\<>]+", " ").trim();
        }else
            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }    
}

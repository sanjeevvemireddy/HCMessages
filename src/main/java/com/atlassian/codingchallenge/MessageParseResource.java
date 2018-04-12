/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlassian.codingchallenge;

import com.atlassian.codingchallenge.model.RequestModel;
import com.atlassian.codingchallenge.util.MessageParser;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 * 
 * This resource has PUT method that accepts a text input string 
 * and returns a parsed json string. 
 *
 * @author Sanjeev
 * @version 1.0
 */
@Path("parse")
public class MessageParseResource {

    /**
     * PUT method accepts a input string, creates instance of parser object and Invokes parse method on parser. 
     * Converts the parsed response into json using Gson library. 
     * Json String is then returned to client.
     * 
     * @param content input string 
     * @return return a json string
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String  putXml(String content) {
       
        Gson objGson = new Gson();
        
        RequestModel request = objGson.fromJson(content, RequestModel.class);
        
        List<String> texts = request.getTexts();
        
        // validate request
        MessageParser parser = new MessageParser();
        
        return objGson.toJson(parser.parse(content));
        
    }
}

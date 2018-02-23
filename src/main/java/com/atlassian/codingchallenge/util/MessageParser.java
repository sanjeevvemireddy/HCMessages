/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlassian.codingchallenge.util;

import com.atlassian.codingchallenge.model.Link;
import com.atlassian.codingchallenge.model.ParsedResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MessageParser.java - This class has a method for parsing a string and 
 * java regex patterns as constants.
 * 
 * @author Sanjeev
 * @version 1.0
 */
public class MessageParser {

    public static final String MENTION_MATCHER = "(\\@[a-zA-Z0-9_]+)";
    public static final String EMOTICON_MATCHER = "\\((.*?)\\)";
    public static final String LINK_MATCHER = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    
    /**
     * This builds parsed response for each of the pattern matcher
     * by invoking findMatche method.
     * 
     * Below matchers are performed and response is built. 
     * mentions - matched for "starts with an '@' and ends when hitting a non-word character."
     * Emoticons - alphanumeric strings, no longer than 15 characters, contained in parenthesis
     * Links - Any URLs contained in the message, along with the page's title.
     * 
     * Note: This method can be improved with design patterns to have 
     *        each pattern matcher in its own class.
     * 
     * @param input - String input that need to be parsed
     * @return PrasedResponse
     */
    public ParsedResponse parse(String input){
        ParsedResponse response = new ParsedResponse();
        
        List<String> mentions = findMatches(MENTION_MATCHER, input);
        for(String mention:mentions){
            response.addMention(mention);
        }
        
        List<String> emoticons = findMatches(EMOTICON_MATCHER, input); // TODO check for alphanumeric and length of emoticons
        for(String emoticon:emoticons){
            response.addEmoticon(emoticon);
        }
        
        List<String> links = findMatches(LINK_MATCHER, input); 
        LinkUtils utils = new LinkUtils();
        
        for(String link :links){
            String title = utils.getTitle(link); //TODO implement the getTitle Method in LinkUtils class
            response.addLink(new Link(link,title));
        }
        
        return response;
    }
    
    /**
     * This method matches regex expression on the given input string
     *  and returns list of matched Strings.
     * 
     * @param regex - regular expression that needs to be matched
     * @param input - input string on which matching is performed
     * @return  - returns a list of matched strings.
     */
    
    public List<String> findMatches(String regex, String input){
        
        List<String> returnList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            returnList.add(matcher.group());
        }
        return returnList;
    }
}
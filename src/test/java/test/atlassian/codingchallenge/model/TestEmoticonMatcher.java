/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.atlassian.codingchallenge.model;

import com.atlassian.codingchallenge.util.MessageParser;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Sanjeev
 */
public class TestEmoticonMatcher {
 
      public static final String EMOTICON_MATCHER = "\\((.*?)\\)";

    @Test
    public void testEmoticonMatch1(){
        
        String input = "Good morning! (megusta) (coffee)";
        MessageParser parser = new MessageParser();
        List<String> matches = parser.findMatches(EMOTICON_MATCHER, input);
        Assert.assertEquals(matches.size(),2);
    }
    
    @Test
    public void testEmoticonMatch2(){
        
        String input = "Good morning! (coffee)";
        MessageParser parser = new MessageParser();
        List<String> matches = parser.findMatches(EMOTICON_MATCHER, input);
        Assert.assertEquals(matches.size(),1);
    }
    
    //TODO add negative tests
    
}

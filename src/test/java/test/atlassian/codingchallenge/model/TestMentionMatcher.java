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
public class TestMentionMatcher {

    public static final String MENTION_MATCHER = "(\\@[a-zA-Z0-9_]+)";

    @Test
    public void testMentionMatch1(){
        
        String input = "@chris you around?";
        MessageParser parser = new MessageParser();
        List<String> matches = parser.findMatches(MENTION_MATCHER, input);
        Assert.assertEquals(matches.size(),1);
    }
    
    @Test
    public void testMentionMatch2(){
        
        String input = "@chris @sanjeev you around?";
        MessageParser parser = new MessageParser();
        List<String> matches = parser.findMatches(MENTION_MATCHER, input);
        Assert.assertEquals(matches.size(),2);
    }
    
    //TODO add negative tests
    
}

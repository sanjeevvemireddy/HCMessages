/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.atlassian.codingchallenge.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * This is Test Suite which is used to run all tests.
 * @author Sanjeev
 */

    
//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   TestEmoticonMatcher.class ,TestMentionMatcher.class
})

public class JunitTestSuite {
        
    
}

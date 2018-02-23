/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlassian.codingchallenge.model;

import java.util.ArrayList;
import java.util.List;

/**
 *Model class for Response Object. This object is built by parser 
 * and converted to json by REST resource and returned to client.
 * 
 * @author Sanjeev
 * @version 1.0
 */
public class ParsedResponse {

    private List<String> mentions;
    
    private List<String> emoticons;
    
    private List<Link> links;
    
    public void addMention(String mention){        
        if(mentions == null){            
            mentions = new ArrayList<>();            
        }
        mentions.add(mention.replace("@", ""));
    }

    public void addEmoticon(String emoticon){        
        if(emoticons == null){            
            emoticons = new ArrayList<>();            
        }
        emoticons.add(emoticon.replaceAll("[\\(\\)]", ""));
    }

    public void addLink(Link link){        
        if(links  == null){            
            links = new ArrayList<>();            
        }
        links.add(link);
    }    

    public List<String> getMentions() {
        return mentions;
    }

    public void setMentions(List<String> mentions) {
        this.mentions = mentions;
    }

    public List<String> getEmoticons() {
        return emoticons;
    }

    public void setEmoticons(List<String> emoticons) {
        this.emoticons = emoticons;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

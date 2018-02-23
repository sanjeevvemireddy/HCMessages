/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atlassian.codingchallenge.model;

/**
 * Model class for links represents the properties of a URL like title, url etc.
 * @author Sanjeev
 */
public class Link {
    
    private String url;
    private String title;

    public Link(String url,String title){
        super();
        this.url = url;
        this.title = title;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}

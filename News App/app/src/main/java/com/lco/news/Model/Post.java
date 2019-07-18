package com.lco.news.Model;

public class Post {

    public String Title;
    public String Description;

    public String getTitle(){
        return Title;
    }

    public String getDescription(){
        return Description;
    }
    public void setTitle(String title){
        Title = title;
    }
    public void setDescription(String description){
        Description = description;
    }
    public Post(){
        // Default
    }
    public Post(String Title,String Description){
        this.Title = Title;
        this.Description = Description;
    }
}

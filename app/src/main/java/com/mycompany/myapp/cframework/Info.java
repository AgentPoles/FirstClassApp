package com.mycompany.myapp.cframework;

/**
 * Created by Paul on 11/29/2017.
 */
public class Info {
    public String title, authority;
    public Info(){

    }
    public Info(String title, String authority){
        this.authority = authority;
        this.title = title;
    }
    public String getAuthority(){
        return  authority;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle (String title){
        this.title = title;
    }
    public void setAuthority (String authority){
        this.authority = authority;
    }
}

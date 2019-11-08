
package com.mycompany;


import java.util.*;

public class Define {
    public String loginId, totalrepos, totalfollowers,totalfollowings,totalgists,type;
    
    public Define (String loginId, String totalrepos, String totalfollowers, String totalfollowings, String totalgists, String type) {
        //super();
        this.loginId = loginId;
        this.totalrepos = totalrepos;
        this.totalfollowers = totalfollowers;
        this.totalfollowings = totalfollowings;
        this.totalgists = totalgists;
        this.type = type;
    }
    
    public String getloginId(){
        return loginId;
    }
    
    public void setloginId(String loginId){
        this.loginId = loginId;
    }  
    
    public String gettotalrepos(){
        return totalrepos;
    }
    
    public void settotalrepos(String totalrepos){
        this.totalrepos = totalrepos;
    }
    public String gettotalfollowers(){
        return totalfollowers;
    }
    
    public void settotalfollowers(String totalfollowers){
        this.totalfollowers = totalfollowers;
    }
    public String gettotalfollowings(){
        return totalfollowings;
    }
    
    public void settotalfollowings(String totalfollowings){
        this.totalfollowings = totalfollowings;
    }
    public String gettotalgists(){
        return totalgists;
    }
    
    public void settotalgists(String totalgists){
        this.totalgists = totalgists;
    }
    public String getType(){
        return type;
    }
    
     public void setType(String type){
        this.type = type;
    }
}

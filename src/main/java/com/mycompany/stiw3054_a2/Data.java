
package com.mycompany.stiw3054_a2;

/**
 *
 * @author Chee Fung
 */

import java.util.*;

public class Data {
    private String followersId, Type;
    private int totalrepos, totalfollowers, totalevents, totalsubscriptions;
    
    public Data(String followersId, int totalrepos, int totalfollowers, int totalevents, int totalsubscriptions, String Type) {
        super();
        this.followersId = followersId;
        this.totalrepos = totalrepos;
        this.totalfollowers = totalfollowers;
        this.totalevents = totalevents;
        this.totalsubscriptions = totalsubscriptions;
        this.Type = Type;
    }

    
    
    public String getfollowersId(){
        return followersId;
    }
    
    public void setfollowersId(String FollowersId){
        this.followersId = FollowersId;
    }
    
    public int gettotalrepos(){
        return totalrepos;
    }
    
    public void settotalrepos(int totalrepos){
        this.totalrepos = totalrepos;
    }
    public int gettotalfollowers(){
        return totalfollowers;
    }
    
    public void settotalfollowers(int totalfollowers){
        this.totalfollowers = totalfollowers;
    }
    public int gettotalevents(){
        return totalevents;
    }
    
    public void settotalevents(int totalevents){
        this.totalevents = totalevents;
    }
    public int gettotalsubscriptions(){
        return totalsubscriptions;
    }
    
    public void settotalsubscriptions(int totalsubscriptions){
        this.totalsubscriptions = totalsubscriptions;
    }
    public String getType(){
        return Type;
    }
    
    public void setType(String Type){
        this.Type = Type;
    }
}

package com.mycompany;

public class Application {
    public void display(){
        try{
            
            Interface run = new Interface();
            run.Format();
        
        }catch(Exception e)
        {
            System.out.println("Unable to display interface...");
        }
    }
}   

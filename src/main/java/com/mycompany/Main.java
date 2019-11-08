
package com.mycompany;


public class Main {
    public static void main(String[] args){
        try{
            Application out = new Application();
            out.display();
            
            savetoexcel start = new savetoexcel();
            start.writeData();
            System.out.println("Writing to excel");
            System.out.println("saving");
            System.out.println("done");
    
        }catch(Exception e)
        {
            System.out.println("Program execution failed...");
        }
    }
}


package com.mycompany.stiw3054_a2;

/**
 *
 * @author Chee Fung
 */
public class Main {
    public static void main(String[] args){
    try{
        
    savetoexcel start = new savetoexcel();
    start.writeData();
    
    }catch(Exception e){
           System.out.println("Program execution failed...");
        }
}
}
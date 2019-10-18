/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.util.*;
import java.io.*;
/**
 *
 * @author ahmed
 */

public class restaurant 
{
    private String name;
    public int restaurantId;
    private static int restaurantRating;
    
    
    
    public restaurant(String n,int rr)
    {
        name =n;
        restaurantId = 0;
        restaurantRating = rr;
    }
    
    public void writeToRestaurant() throws IOException
    {
        FileWriter res = new FileWriter("restaurant.txt");

        BufferedWriter writer = new BufferedWriter(res);
        
        writer.write(this.toString());
        writer.close();
    }
    
    
    public void Readrestaurant() throws IOException
    {
        BufferedReader readRestaurant = new BufferedReader(new FileReader("restaurant.txt"));
        String S;
        
        while ((S = readRestaurant.readLine()) != null)
        {
            System.out.println(S+"\n");
            
        }
        
    }
    
    
    //over riding
    public String toString()
    {
        return String.format("%s,%s,%s", 
                restaurantId,name,restaurantRating);
    }
    
    
}

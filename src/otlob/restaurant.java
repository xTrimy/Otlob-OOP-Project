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
    private int restaurantId;
    private static int restaurantRating;
    
    public restaurant()
    {name = " ";
        restaurantId =0;
        restaurantRating =0;
    }
    
    
    public restaurant(String n)throws IOException
    {
        name =n;
        assistingClass obj = new assistingClass();
        restaurantId = obj.getId("restaurant.txt") + 1;
        restaurantRating = 0;
    }
    
    
    public void setRestaurant(String n,int rr)
    { 
        name =n;
        restaurantId = 0;
        restaurantRating = rr;
    }
    
    public String getRestaurant()
    {
        return this.toString();
    }
    
    public int getRestaurantid()
    {
        return restaurantId;
    }
    
    public String getRestaurantRating()
    {
        return " ";
    }
    
    public String getRestaurantName()
    {
        return name;
    }
    
    
    
    public String[] Readrestaurant() throws IOException
    {
        BufferedReader readRestaurant = new BufferedReader(new FileReader("restaurant.txt"));
        String S;
        String adminId;
        String content = "";
            while ((S = readRestaurant.readLine()) != null)
            {
                try
                {
                   // String [] list = S.split(",");
                    content = content + S + System.lineSeparator();
                    
                   // System.out.println(list[2] + " rating : " + list[3]);
                  
                }
                catch(ArrayIndexOutOfBoundsException exception)
                {
                 continue;   
                }
            }
        readRestaurant.close();
        
       String [] list  = content.split(System.lineSeparator());
        return list;
        
    }
    
    
    //overriding
    public String toString()
    {
        return String.format("%d,%s,%d\n", 
                restaurantId ,name,restaurantRating);
    }
    
    
}

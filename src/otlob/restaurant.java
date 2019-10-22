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
        name = n;
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
    
    
    
    public String[][] Readrestaurant() throws IOException
    {
        File restaurants = new File("restaurant.txt");
        String fileData = "";
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(restaurants));
            String line = reader.readLine();
            while (line != null) 
            {
                fileData = fileData + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        String [] list = null;
        String [][] result = null;
        try
        {
            list = fileData.split(System.lineSeparator());
            int size = list.length;
            result = new String [size][]; 
            int count = 0;
            for (String line : list)
            {
                result [count] = line.split (",");
                ++count;
            }
        }catch(Exception e){
            System.out.print(e);
            return null;
        }
        return result;
    }
    
    
    //overriding
    public String toString()
    {
        return String.format("%d,%s,%d\n", 
                restaurantId ,name,restaurantRating);
    }
    
    
}

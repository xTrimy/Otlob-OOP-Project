
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
        restaurantId = 0;
        restaurantRating =0;
    }
    
    
    public restaurant(String n)throws IOException
    {
        name = n;
        assistingClass obj = new assistingClass();
        restaurantId = obj.getId("restaurant.txt") + 1;
        restaurantRating = 0;
    }
    public void setID(String ID)
    {
        this.restaurantId = Integer.parseInt(ID);
    }
    
    public void setRestaurant(String n,int rr)throws IOException
    { 
        name =n;
        restaurantId = this.getRestaurantid();
        restaurantRating = rr;
    }
    
    public String getRestaurant()
    {
        return this.toString();
    }
    
    public int getRestaurantid()throws IOException
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
    public void getRestaurantFromAdmin(int adminId)
    {

        //returns restaurant name and restuarant ID
    }
    @Override
    public String toString()
    {
        return String.format("%d,%s,%d\n", 
                restaurantId ,name,restaurantRating);
    }    
}

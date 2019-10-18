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
public class meal 
{
    
    private String mealName;
    private String mealType;
    private int productId;
    private float price;
    private static int quantity;
    
    
    //parametric constructor
    public meal(String N,String T,float pr,int quan)
    {
        mealName = N;
        mealType = T;
        productId= 0;
        price = pr;
        quantity = quan;
    }
    
    public void writeToMeals() throws IOException
    {
        FileWriter res = new FileWriter("meal.txt");

        BufferedWriter writer = new BufferedWriter(res);
        
        writer.write(this.toString());
        writer.close();
    }
    
    
    //overRiding to return the meal details 
     public String toString()
    {
        return String.format("%s,%s,%s,%s\n", 
                mealName,mealType,price,quantity);
    }
    
}

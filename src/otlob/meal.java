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
    private int mealId;
    private float price;
    private static int quantity;
    private int restaurantId;
    
    public meal(){
        this.mealName = " ";
        this.mealType = " ";
        this.mealId = 0;
        this.price = 0;
        this.quantity = 0;
        this.restaurantId = 0;
    }
    
    
    //parametric constructor
    public meal(String N,String T,float pr,int quan)throws IOException
    {
        assistingClass obj = new assistingClass();
        
        mealName = N;
        mealType = T;
        mealId= obj.getId("meal.txt") +1;
        price = pr;
        quantity = quan;
    }
    
    
    public void displayMeals()
    {
        System.out.printf("%s,%s,%s\n",mealName,mealType,price);
    }
    
    public void writeToMeals(String adminId) throws IOException
    {
        assistingClass obj = new assistingClass();

        FileWriter res = new FileWriter("meal.txt",true);

        BufferedWriter writer = new BufferedWriter(res);

        writer.write(adminId + "," + this.toString());
        obj.modifyFile("meal.txt",Integer.toString(mealId -1), Integer.toString(mealId ));
        writer.close();

    }

    
    
    //overRiding to return the meal details 
     public String toString()
    {
        return String.format("%s,%s,%s,%s,%s\n", 
                mealId,mealName,mealType,price,quantity);
    }
    
}

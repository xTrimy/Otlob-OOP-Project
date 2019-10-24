/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author ahmed
 */
public class prodcutList 
{
    int requestedQuantity ;
    float totalPrice;
    
    meal  mealList[] = new meal[20];
    
    prodcutList()
    {
        
    }
    prodcutList(String [] id)throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("meal.txt"));
        String [] list ;
        String S;
        //id iterator
        int i=0;
        //mealList iterator
        int j=0;
        totalPrice =0;
        while((S = r.readLine()) != null)
        {
            list = S.split(",");
            try {
                if(list[1].equals(id[i])){
                    mealList[i] = new meal(list[2],list[3],Float.parseFloat(list[4]),
                    Integer.parseInt(list[5]));
                    totalPrice += Float.parseFloat(list[4]);   
                    i++;
                    r = new BufferedReader(new FileReader("meal.txt"));
                }     
            }catch(Exception e){}           
        }
        requestedQuantity = i;
    }
    
    
    public void display()
    {
        try
        {
        int i = 1;
        for(meal m : mealList)
        {
            System.out.print(i++ + ")");
            m.displayMeals();
        }
        }catch(java.lang.NullPointerException exception){}
        System.out.println("--Requested Quantity: "+ requestedQuantity+"--");
        System.out.println("--Total Price: "+ totalPrice+"--");
    }
    
    public float getTotalPrice()
    {
        return totalPrice;
    }
    
    public void addMeal()
    {
        
        
    }
    
    public void removeMeal()
    {
        
    }
    
    public void writemeal()throws IOException
    {
        assistingClass obj = new assistingClass();
        obj.writeFile(this.toString(), "requestedProducts.txt",false);
        
    }
    
    
    @Override
    public String toString(){
        String s = String.format("%s|%s\n",requestedQuantity,totalPrice);
        for(int i=0;i < requestedQuantity;i++)
        {
            s +=  mealList[i].toString();
        }
        return s;
    }
}

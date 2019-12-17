/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.DataVisualiztaion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ahmed
 */
public class filterData 
{
    
    public ArrayList<String> getMealIds(String restaurantID) throws  IOException
    {
        ArrayList<String> stat = new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(new File("orders.txt")));
        String line;
        
        while((line = reader.readLine()) != null)
        {
            String list[] = line.split(",");
            if(list[1].equals(restaurantID))
            {
                stat.add(list[2]);
            }
        }
        
        return stat;
    }
    
    public HashMap<String,Integer> countIt(ArrayList <String> ls)
    {
        HashMap<String,Integer> counted = new HashMap();
        int count = 0;
        for(String x :ls)
        {
            count = 0;
            for(String j :ls)
            {
               // System.out.println(x + "  " + j);
                if(x.equals(j))
                    count++;
                
            }
            counted.put(x,count);
        }
        
        return counted;
    }
    
    
    
    
    
}

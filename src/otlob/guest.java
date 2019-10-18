/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ahmed
 */
public class guest 
{
    
    guest(){}
    
    //user passes the type userName pass the id
    public void signUp(String Type,String userName,String pass,int userId,String userEmail) throws IOException
    {
        if("customer".equals(Type))
        {
            assistingClass obj = new assistingClass();
            int size = obj.getId("customer.txt");
            FileWriter c = new FileWriter("customer.txt",true);
            BufferedWriter writer = new BufferedWriter(c);
            writer.write(String.format("%s,%s,%s,%s \n"
                    ,size + 1,pass,userName,userEmail));
            
            writer.close();
            
            obj.modifyFile("customer.txt",Integer.toString(size), Integer.toString(size +1));
        }
        else if(Type == "admin")
        { 
            FileWriter ad = new FileWriter("admin.txt");
            BufferedWriter writer = new BufferedWriter(ad);
            writer.write("under development ");
            writer.close();
        }
        
    }
    public void view()
    {
        
    }
    
    
    
    
    
}

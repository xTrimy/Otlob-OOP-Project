/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.*;
import java.util.*;
/**
 *
 * @author ahmed
 */
public class guest 
{
    
    guest(){}
    
    
    public void LogIn(int option) throws IOException
    {
        //customer 
        if(option == 1)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("enter userName: ");
                String u = input.next();
            System.out.println("enter password: ");
                String p = input.next();
                
             BufferedReader readobj = new BufferedReader(new FileReader("customer.txt"));
                                 boolean match = false;

             String s;
             while((s = readobj.readLine()) != null)
             {
               try
               {
                    // StringTokenizer tokens = new StringTokenizer(s,",");
                    String [] list = s.split(",");
                     if(list[1].equals(p) && list[2].equals(u))
                     {
                         match = true;
                         System.out.println("matched :)");
                         break;
                     }
                 
                }
                catch(ArrayIndexOutOfBoundsException exception) 
                {
                continue;
                }
                 
             }
             if(match == false)
             System.out.println("wrong password or user name :(");

        }
        //admin
        else if(option == 2)
        {
            return;
        }
    }
    
    
    
    //user passes the type userName pass the id
    public void signUp(String Type,String userName,String pass,int userId,String userEmail,Address location) throws IOException
    {
        if("customer".equals(Type))
        {
            
            assistingClass obj = new assistingClass();
            int size = obj.getId("customer.txt");
            FileWriter c = new FileWriter("customer.txt",true);
            FileWriter c1 = new FileWriter("address.txt",true);
            BufferedWriter Buffaddress = new BufferedWriter(c1);
            BufferedWriter writer = new BufferedWriter(c);
            
            writer.write(String.format("%s,%s,%s,%s \n"
                    ,size + 1,pass,userName,userEmail));
            Buffaddress.write((size +1) +","+location.toString());
            
            writer.close();
            Buffaddress.close();
            obj.modifyFile("customer.txt",Integer.toString(size), Integer.toString(size +1));
            obj.modifyFile("address.txt",Integer.toString(size), Integer.toString(size +1));

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
/**
 *
 * @author ahmed
 */
public class guest 
{
    
    guest(){}
    
    
    public void LogIn(byte option) throws IOException
    {
        //customer 
        
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
    
    
    
  /*  public void signUp(User u) throws IOException
    {
        if(type == 2)
        {
            u = new Customer(userName,userEmail,phoneNumber,location,pass,userName,LocalDate.now());
            u.writeUser();
        }
        else if(type == 1)
        { 
            u = new Admin(userName,userEmail,pass,userName);          
            u.writeUser();
        }
        else 
            return;
        
    }*/
    public void view()
    {
        
    }
    
    
    
    
    
}

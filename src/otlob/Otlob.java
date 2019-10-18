/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.io.*;
/**
 *
 * @author PC
 */
import java.io.IOException;
import java.util.*;
import java.time.LocalDate;

public class Otlob {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args)throws IOException 
    {
        
        System.out.println("please choose which type of customer you are");
        System.out.println("1)admin \n2)customer");
        Scanner input = new Scanner(System.in);
        int x;
        x = input.nextInt();
        
        if(x == 1)
        {
            System.out.println("please enter the retaurants name: ");
            String RName = input.next();
            Admin a = new Admin(0,"ahmed","ahmed180123@gmail.com"
                    ,"pass","3adel",5,LocalDate.now());
            a.initializeRestaurant(RName);
            a.writeToRestaurant();
        }
        else
        {
            String Type,name,pass,mail;
            System.out.print("enter customer or admin: ");
            Type = input.next();
            System.out.print("enter username: ");
            name = input.next();
            System.out.print("enter  pass: ");
            pass = input.next();
            System.out.print("enter  mail: ");
            mail = input.next();

            guest g = new guest();
            g.signUp(Type, name, pass, 0, mail);
        }
        
        

    }
    
}

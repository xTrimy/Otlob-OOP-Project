/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
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
        String s = "1,password,ahmed,smth@domain.com";
        String [] list = s.split(",");
        System.out.println(list[1]);
        
        if(list[1].equals("password") && list[2].equals("ahmed"))
            System.out.println("pci");
        
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
            
            char ch ;
            System.out.println("enter 1 for login and 2 for sign up");
            ch = input.next().charAt(0);

            if(ch == '2')
            {
                //prompt for user information
                String Type,name,pass,mail;
                System.out.print("enter customer or admin: ");
                Type = input.next();
                System.out.print("enter username: ");
                name = input.next();
                System.out.print("enter  pass: ");
                pass = input.next();
                System.out.print("enter  mail: ");
                mail = input.next();

                //prompt for address
                String aN,aD,aL,bN,Ln;
                System.out.print("enter appartment number: ");
                aN = input.next();
                System.out.print("enter appartment description(optional): ");
                aD = input.nextLine();
                System.out.print("enter appartment location: ");
                aL = input.nextLine();
                System.out.print("enter building number: ");
                bN = input.next();
                System.out.print("enter landLine number: ");
                Ln = input.nextLine();

                //sign up !
                Address location = new Address(aN,aD,aL,bN,Ln);
                guest g = new guest();
                g.signUp(Type, name, pass, 0, mail,location);
            }
            else if(ch == '1')
            {
                guest g = new guest();
                g.LogIn(1);
                
            }
            
        }
        
    }
    
}

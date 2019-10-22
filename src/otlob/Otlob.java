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
        assistingClass obj = new assistingClass();
        String searching = obj.search("smth","customer.txt");
        System.out.print(searching);
        
        
        
        User user;
        System.out.println("please choose which type of user you are");
        System.out.println("1)admin\n2)customer");
        Scanner input = new Scanner(System.in);
        
       
        byte type,ch;
        type = input.nextByte();
        
        if(type == 1)
        {
            
            //the admin section
            System.out.println("enter 1 for login and 2 for sign up");
            ch = input.nextByte();
            if(ch == 1)
            {
                System.out.println("enter userName: ");
                String userName = input.next();
                System.out.println("enter password: ");
                String password = input.next();
                
               user = new Admin();
               String searchedId = user.LogIn("admin.txt", userName, password);
               //if matched returns the id else returns the following message
               if(searchedId.equals("incorrect userName or password"))
               {
                   System.out.println(searchedId);
               }
               else
               {
                   user = user.getUser(searchedId);
                   System.out.println("welcome " + user.getUserName());
                   System.out.printf("here you can manage your restaurant\n1)view restaurant products\n2)add restaurant products  " );
                   ch = input.nextByte();
                   
                   if(ch == 1)
                   {
                       return;
                   }
                   else if(ch == 2)
                   {
                       String mealName,mealType;
                       float price;
                       int quantity;
                       System.out.println("enter mealname: ");
                       mealName = input.next();
                       System.out.println("enter meal Type: ");
                       mealType = input.next();
                       System.out.println("enter meal price: ");
                       price = input.nextFloat();
                       System.out.println("enter mea; quantity: ");
                       quantity = input.nextInt();
                       
                        meal m = new meal(mealName,mealType,price,quantity);
                        m.writeToMeals(Integer.toString(user.getUserId()));
                   }
                   
               }

            }     
            else if(ch == 2)
            {
                //prompt for user information
               String name,pass,mail,phoneNumber;
               String resName;
               System.out.print("enter username: ");
               name = input.next();
               System.out.print("enter  pass: ");
               pass = input.next();
               System.out.print("enter  mail: ");
               mail = input.next();
               System.out.print("enter phoneNumber: ");
               phoneNumber = input.next();
               System.out.print("enter restaurant name: ");
               resName = input.next();
               
               
                  user = new Admin(name,mail,
                        pass,name,resName);
                user.writeUser();
               
            }
        }
        else if(type == 2)
        {          
            System.out.println("enter 1 for signup and 2 for login");
            ch = input.nextByte();

            if(ch == 1)
            {
                Scanner scan = new Scanner (new File("customer.txt"));
                //prompting with spaces please!
                //prompt for user information
                String name,FandLname,pass,mail,phoneNumber;
                mail = " ";
                String aN,aD,aL,bN,Ln;
                
                System.out.print("enter username: ");
                name = input.next();
                System.out.print("enter  pass: ");
                pass = input.next();
                System.out.print("Enter First and Last name: ");
                FandLname = input.next();
                while (mail.equals(" ")) {
                    System.out.print("enter  mail: ");
                    mail = input.next();
                    String existingEmail = scan.nextLine();
                     if (mail.equals(existingEmail)) {
                         System.err.println("Username already exists! Try Again.\n");
                         mail = " ";
                         break;
                         }
                }


                System.out.print("enter phoneNumber: ");
                phoneNumber = input.next();

                //prompt for address
                System.out.print("enter your address: ");
                aL = input.next();
                //  System.out.print("enter appartment description(optional): ");
                //   aD = input.nextLine();
                System.out.print("enter appartment number: ");
                aN = input.next();
                System.out.print("enter building number: ");
                bN = input.next();
                System.out.print("enter landLine number: ");
                Ln = input.next();

                //sign up !
                Address location = new Address(aL,"test",aN,bN,Ln);
                

                  user = new Customer(name,mail,phoneNumber
                        ,location,pass,FandLname,LocalDate.now());
                user.writeUser();
                
                //after sign up customer must be re-directed to login
            }
            else if(ch == 2)
            {
                System.out.println("enter userName: ");
                String userName = input.next();
                System.out.println("enter password: ");
                String password = input.next();
                
                user = new Customer();
               String id =  user.LogIn("customer.txt", userName, password);
                
                user = user.getUser(id);
                if(id.equals("incorrect userName or password"))
               {
                   System.out.println(id);
               }
               else
               {
                   user = user.getUser(id);
                   System.out.println("welcome, "+user.getUserName());
                   System.out.println("1)to view products\n2)to search restaurants");
                   ch = input.nextByte();
                   
                   if(ch == 1)
                   {
                        restaurant res = new restaurant();
                        res.Readrestaurant();
                    }
                   else if(ch ==2)
                   {
                       
                       
                   }
                }
                   
            }

        }
        
        }   
    }
    


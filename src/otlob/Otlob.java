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
                   
                   
                   System.out.println("please select from the following restaurants");
                   if(ch == 1)
                   {
                        assistingClass obj = new assistingClass();
                     String[][] list = obj.ReadFile("restaurant.txt");
                        for(String[] line:list)
                        {
                            try
                            {
                            System.out.print(line[1]+")"+line[2]);
//                            for(String line2: line){
//                                System.out.print(line2);
//                            }
                            }
                            catch(Exception e)
                            {continue ;}
                            System.out.print("\n");
                            //prompt for choice 
                            
                            
                            
                        }
                        Byte choice ;
                        choice = input.nextByte();
                        String adminId = list[choice +1][0];                        

                        System.out.println("choose the meals which you "
                                + "would like to add to cart\n to go to cart enter -1");
                        int goTo = 0;
                        String choosenMeals = "" ;
                        String[][] listMeals = obj.ReadFile("meal.txt");
                                                            int i=0;

                                for(String[] x : listMeals)
                                {
                                    try
                                    {
    //                                    System.out.println(x[0]);

                                        if(x[0].equals(adminId))
                                        {
                                            System.out.println(i +")"+x[2]+" price: "+ x[4]);
                                            i++;
                                        }

                                    }
                                    catch(Exception e){continue;}
                                    
                                }
                                goTo = input.nextInt();
                                i=0;
                        while(goTo != -1)
                        {
                                    try
                                    {
                                        choosenMeals += listMeals[goTo + 1][1] + ",";
                                    }catch(Exception e){System.out.println("out of bounds");}
                                    goTo = input.nextInt();
                                   
                        }
                        
                        String [] choosenIds = choosenMeals.split(",");
                        
                       // for(String x : choosenIds)
                       //     System.out.println(x);
                        
                        prodcutList L = new prodcutList(choosenIds);
                        L.display();
                        
                        byte x;
                        System.out.println("1)checkOut\n2)removeProduct\n?");
                        x = input.nextByte();
                        
                        if(x == 1)
                        {
                            
                        }
                        else 
                        {
                            
                        }
                    }
                }

            }
                   else if(ch ==2)
                   {
                       
                       
                   }
        }
                   
    }

}
       
    


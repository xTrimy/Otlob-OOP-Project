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
        System.out.println("==== Please choose which type of user you are ====");
        System.out.println("1)Admin\n2)Customer");
        Scanner input = new Scanner(System.in);
        assistingClass obj = new assistingClass();
        byte type,ch;
        System.out.print(">");
        type = input.nextByte();
        
        if(type == 1)
        {
            
            //the admin section
            System.out.println("1)Login\n2)Sign Up");
            System.out.print(">");
            ch = input.nextByte();
            if(ch == 1)
            {
                System.out.println("Enter Username: ");
                String userName = input.next();
                System.out.println("Enter Password: ");
                String password = input.next();
                
               user = new Admin();
               String searchedId = user.LogIn("admin.txt", userName, password);
               //if matched returns the id else returns the following message
               if(searchedId.equals(""))
               {
                   System.out.println("==== Incorrect Username or Password ====");
               }
               else
               {
                   user = user.getUser(searchedId);
                   System.out.println("==== Welcome " + user.getUserName() + " =====");
                   System.out.println("==== Here you can manage your restaurant ====\n1)View Restaurant Products\n2)Add Restaurant Products  " );
                   System.out.print(">");
                   ch = input.nextByte();
                   while(true){
                        if(ch == 1)
                        {
                            int i=0;
                            String [][] res = obj.ReadFile("restaurant.txt");
                            String [][] meals = obj.ReadFile("meal.txt");
                            int adminId = user.getUserId();
                            System.out.println("====== Restaurant's Name: " + res[adminId - 1][2]+" ======");
                            System.out.println("====== Restaurant Products: ======");
                            for(String[] x : meals)
                                     {
                                         try
                                         {

                                             if(Integer.parseInt(x[0]) == adminId)
                                             {
                                                 System.out.println(i +"- "+x[2]+" | price: "+ x[4]);
                                                 i++;
                                             }

                                         }
                                         catch(Exception e){
                                         }
                                     }
                        }
                        else if(ch == 2)
                        {
                            String mealName,mealType;
                            float price;
                            int quantity;
                            System.out.println("Enter Meal Name: ");
                            mealName = input.next();
                            System.out.println("Enter Meal Type: ");
                            mealType = input.next();
                            System.out.println("Enter Meal Price: ");
                            price = input.nextFloat();
                            System.out.println("Enter Meal quantity: ");
                            quantity = input.nextInt();

                             meal m = new meal(mealName,mealType,price,quantity);
                             m.writeToMeals(Integer.toString(user.getUserId()));
                         }
                    System.out.println("1)View Restaurant Products\n2)Add Restaurant Products  " );
                    System.out.print(">");
                    ch = input.nextByte();
                    }
                   
               }

            }     
            else if(ch == 2)
            {
                //prompt for user information
               String name,pass,mail,phoneNumber;
               String resName;
               System.out.print("Enter Username: ");
               name = input.next();
               System.out.print("Enter  Pass: ");
               pass = input.next();
               System.out.print("Enter  Mail: ");
               mail = input.next();
               System.out.print("Enter Phone Number: ");
               phoneNumber = input.next();
               System.out.print("Enter Restaurant Name: ");
               resName = input.next();
               
               
                  user = new Admin(name,mail,
                        pass,name,resName);
                user.writeUser();
               
            }
        }
        else if(type == 2)
        {          
            System.out.println("1) Sign Up\n2) Login");
            System.out.print(">");
            ch = input.nextByte();

            if(ch == 1)
            {
                Scanner scan = new Scanner (new File("customer.txt"));
                //prompting with spaces please!
                //prompt for user information
                String name,FandLname,pass,mail,phoneNumber;
                mail = " ";
                String aN,aD,aL,bN,Ln;
                
                System.out.print("Enter Username: ");
                name = input.next();
                System.out.print("Enter  Password: ");
                pass = input.next();
                System.out.print("Enter First and Last name: ");
                FandLname = input.next();
                System.out.print("Enter Email: ");
                mail = input.next();
                while(obj.search(mail, "customer.txt").equals(mail)){
                    System.out.println("email is taken please choose another: ");
                    mail = input.next();
               }
                System.out.print("Enter Phone Number: ");
                phoneNumber = input.next();

                //prompt for address
                System.out.print("Enter Your Address: ");
                aL = input.next();
                //  System.out.print("enter appartment description(optional): ");
                //   aD = input.nextLine();
                System.out.print("Enter Appartment Number: ");
                aN = input.next();
                System.out.print("Enter Building Number: ");
                bN = input.next();
                System.out.print("Enter Landline Number: ");
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
                System.out.println("Enter Username: ");
                String userName = input.next();
                System.out.println("Enter Password: ");
                String password = input.next();
                
                user = new Customer();
               String id =  user.LogIn("customer.txt", userName, password);
                
                user = user.getUser(id);
                if(id.equals(""))
               {
                   System.out.println("==== Incorrect Username or Password ====");
               }
               else
               {
                   user = user.getUser(id);
                   System.out.println("welcome, "+user.getUserName());
                   System.out.println("1)View Restaurants");
                   System.out.print(">");
                   ch = input.nextByte();
                   System.out.println("====== Please select from the following restaurants =====");
                   if(ch == 1)
                   {
                    
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
                        System.out.print(">");
                        choice = input.nextByte();
                        String adminId="";
                        try{
                            adminId = list[choice +1][0];  
                        }catch(Exception e){
                            
                        }                    

                        System.out.println("===== Choose the meals which you "
                                + "would like to add to cart ====\n===== To go to cart enter (-1) =====");
                        int goTo = 0;
                        String choosenMeals = "" ;
                        String[][] listMeals = obj.ReadFile("meal.txt");
                        String restaurantMeals = "";
                        int i=0;

                                for(String[] x : listMeals)
                                {
                                    try
                                    {
    //                                    System.out.println(x[0]);

                                        if(x[0].equals(adminId))
                                        {
                                            restaurantMeals = restaurantMeals+ x[1]+",";
                                            System.out.println(i +")"+x[2]+" | price: "+ x[4]);
                                            i++;
                                        }

                                    }
                                    catch(Exception e){
                                    }
                                }
                                String[] restaurantMealsIds = restaurantMeals.split(",");
                                System.out.print(">");
                                goTo = input.nextInt();
                                i=0;
                        while(goTo != -1)
                        {
                                    try
                                    {
                                        choosenMeals += restaurantMealsIds[goTo] + ",";
                                    }catch(Exception e){}
                                    System.out.print(">");
                                    goTo = input.nextInt();
                                   
                        }
                        String [] choosenIds = choosenMeals.split(",");
                        prodcutList L = new prodcutList(choosenIds);
                        L.display();
                        byte x;
                        System.out.println("1)Check Out\n2)Remove Product\n");
                        System.out.print(">");
                        x = input.nextByte();
                        while(x == 2){
                            if(x == 1)
                            {
                                //checkout code here
                            }
                            else if(x == 2) 
                            {
                                byte y;
                                System.out.println("===== Please choose what you want to remove: =====");
                                System.out.println("(enter -1 to exit)");
                                System.out.print(">");
                                y = input.nextByte();
                                while(y != -1){
                                    try{
                                        choosenMeals = choosenMeals.replaceFirst((choosenIds[y-1]+","), "");
                                    }catch(Exception e){
                                    }
                                    System.out.print(">");
                                    y = input.nextByte();
                                }
                                choosenIds = choosenMeals.split(",");
                                L = new prodcutList(choosenIds);
                                L.display();
                            }
                            System.out.println("1)Check Out\n2)Remove Product\n");
                            System.out.print(">");
                            x = input.nextByte();
                        }
                    }
                }
            }
        }
    }
}
       
    


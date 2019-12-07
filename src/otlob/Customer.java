/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;



/**
 *
 * @author Zeina Ayman
 */
public class Customer extends User{
    private String customerName;
    private int customerId;
    private String email;
    private String phoneNum;
    private Address location;
    
    
    public void report(){
        
    }
    
    public Customer()
    {
        this.customerName = "";
        this.customerId = 0;
        this.email = "";
    }
    
    public void Signup() throws IOException
    {
        User user;
        assistingClass obj = new assistingClass();
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner (new File("customer.txt"));
                //prompting with spaces please!
                //prompt for user information
                String name,FandLname,pass,mail,phoneNumber;
                String aN,aD,aL,bN,Ln;
                
                System.out.print("Enter Username: ");
                name = input.next();
                System.out.print("Enter  Password: ");
                pass = input.next();
                System.out.print("Enter First and Last name: ");
                input.nextLine(); 
                FandLname = input.nextLine();
                System.out.print("Enter Email: ");
                mail = input.nextLine();
                while(obj.search(mail, "customer.txt").equals(mail)){
                    System.out.println("email is taken please choose another: ");
                    mail = input.nextLine();
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
    }
    
    public User getUser(String id) throws IOException
    {
        //customer 
        BufferedReader readobj = new BufferedReader(new FileReader("customer.txt"));

        String s;
        while((s = readobj.readLine()) != null)
        {
            //try because the first iteration iterates over the first line which is the size
          try
          {
               // StringTokenizer tokens = new StringTokenizer(s,",");
               String [] list = s.split(",");
                if(list[0].equals(id))
                {
                    this.password = list[2];
                    this.username = list[1];
                    this.customerName = list[4];
                    this.customerId = Integer.parseInt(id);
                    this.email       = list[5];
                    this.phoneNum  = list[6];
                    this.date = LocalDate.parse(list[3]);
                    return this;
                }

           }
           catch(ArrayIndexOutOfBoundsException exception) 
           {
                continue;
           }

        }
        
        return null;
    }
    
    
    public int getUserId()
    {
        return customerId;
    }
     public Customer(String uname, String email, String phonNum,
             Address loc,String pass, String cusname, LocalDate myObj) throws IOException
    {
        super(pass, uname, myObj);
        this.customerName = cusname;
        assistingClass obj = new assistingClass();
        //+1 for the printing
        this.customerId  =  obj.getId("customer.txt")+1;
        this.email       = email;
        this.phoneNum  = phonNum;
        this.location = loc;
    }
     
     
     public String getUserName()
     {
       return username;   
     }
     
     public void writedetails()throws IOException {
    
        BufferedWriter writer = new BufferedWriter(new FileWriter("Customer.txt"));
        writer.write(this.toString());
    }
     public void Readdetails() throws IOException
    {
        BufferedReader read = new BufferedReader(new FileReader("Customer.txt"));
        String S;
        
        while ((S = read.readLine()) != null)
        {
            System.out.println(S+"\n");
            
        }
        
    }
    public void SetName(String name){
        name = customerName;
    }
    
    public String GetName(){
        return customerName;
    }
    
       //overriding
    //this one is used mainly in printing the file so it creates a new id
    public String toString()
    {
        //super has userName, password, userId, date
        return String.format("%s,%s,%s,%s,%s\n", 
                customerId,super.toString(),customerName,email,phoneNum);
    }
    
    
    
public void writeUser() throws IOException
{
   assistingClass obj = new assistingClass();
   
   obj.writeFile(this.toString(), "customer.txt");
   obj.writeFile((customerId ) +","+location.toString(),"address.txt");
   
   obj.modifyFile("customer.txt",Integer.toString(customerId -1), Integer.toString(customerId ));
   obj.modifyFile("address.txt",Integer.toString(customerId -1), Integer.toString(customerId ));

}
   

    
}

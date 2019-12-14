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
public class Admin extends User 
{
    private int adminId;
    private String adminName;
    private String adminEmail;
    private restaurant R ;
    final String adminFile = "admin.txt";
    
    public Admin(){}
    
    public void Signup() throws IOException
    {
        User user;
        assistingClass obj = new assistingClass();
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner (new File("admin.txt"));
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
    
    
    public User getUser(String id) throws IOException
    {
        
        
        //customer 
        //------Reading from file (START)------
        BufferedReader readObj = new BufferedReader(new FileReader(adminFile));
        String s;
        while((s = readObj.readLine()) != null)
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
                    this.adminName = list[4];
                    this.adminId = Integer.parseInt(id);
                    this.adminEmail  = list[5];
                    this.date = LocalDate.parse(list[3]);
                    return this;
                }

           }
           catch(ArrayIndexOutOfBoundsException exception) 
           {
                continue;
           }

        }
        //-------Reading from file (END)------
        
        return null;
    }

 
public Admin(String aN/*Admin Name*/, String aE/*Admin Email*/, String pass
        , String uname,String resName/*Restaurant Name*/)throws IOException
{
    super(pass, uname, LocalDate.now());
    //getting the Id of the admin and adding one to print in a file
    assistingClass obj = new assistingClass();
    this.adminId  =  obj.getId(adminFile) +1;

    adminEmail = aE;
    adminName = aN;

       R = new restaurant(resName);


}



public void writeUser() throws IOException
{
    
    assistingClass obj = new assistingClass();
    obj.writeFile(this.toString(), adminFile);
    writeToRestaurant();
    //previous admin id replace with the new incremented one in the constructor
    obj.modifyFile(adminFile,Integer.toString(adminId -1), Integer.toString(adminId));

}


public void writeToRestaurant() throws IOException
{
    assistingClass obj = new assistingClass();
    int rId = R.getRestaurantid();
    //second parameter true for appending
    obj.writeFile(Integer.toString(adminId)+"," + R.toString(),"restaurant.txt");
    obj.modifyFile("restaurant.txt",Integer.toString(rId -1), Integer.toString(rId));
}

public int getUserId()
{
    return adminId;
}
        




public void Readadmin() throws IOException
{
        BufferedReader read = new BufferedReader(new FileReader("admin.txt"));
        String S;

        while ((S = read.readLine()) != null)
        {
            System.out.println(S+"\n");
            
        }

}
//private int adminId;
//    private String adminName;
//    private String adminEmail;
//    private restaurant R ;
//    final String adminFile = "admin.txt";

public String getmail()
{
    return adminEmail;
}


public String getUserName()
{
    return adminName;
}

public String toString()
{
    //after overRiding the restaurant the toString restaurant function returns string
    return String.format("%s,%s,%s,%s\n", 
            adminId,super.toString(),adminName,adminEmail);
}

}

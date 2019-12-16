/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
                        pass,name,resName,"sometest");
                user.writeUser();
    }
    
    
    public User getUser(String id) throws IOException
    {
        
        
        //customer 
        //------Reading from file (START)------
        BufferedReader readObj = new BufferedReader(new FileReader(adminFile));
        String s;int i=0;
        while((s = readObj.readLine()) != null)
        {
            //try because the first iteration iterates over the first line which is the size
          try
          {
               // StringTokenizer tokens = new StringTokenizer(s,",");
              if(i == 0)
              {
                i++;
                continue;
              }
               String [] list = s.split(",");
                if(list[0].equals(id))
                {
                    this.password = list[2];
                    this.phoneNum = list[4];
                    this.username = list[1];
                    this.adminName = list[5];
                    this.adminId = Integer.parseInt(id);
                    this.adminEmail  = list[6];
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
        , String uname,String resName/*Restaurant Name*/,String ph)throws IOException
{
    super(pass, uname, LocalDate.now(),ph);
    //getting the Id of the admin and adding one to print in a file
    assistingClass obj = new assistingClass();
    this.adminId  =  obj.getId(adminFile) +1;

    adminEmail = aE;
    adminName = aN;

       R = new restaurant(resName);

}

public void setRes(String resName)throws IOException
{
    R.setRestaurant(resName, 0);
}


//didnt test it yet
public void addAdmin(Admin addedAdmin,String resId,String resName,String rating)throws IOException
{
    
    assistingClass obj = new assistingClass();
    addedAdmin.adminId = obj.getId(adminFile)+1;
        addedAdmin.R.setRestaurant(resName, 0);
        addedAdmin.R.setID(resId);
    addedAdmin.writeUser();
   

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
    int rId = obj.getId("restaurant.txt") + 1;
    //second parameter true for appending
    obj.writeFile(Integer.toString(adminId)+"," + R.toString(),"restaurant.txt");
    obj.modifyFile("restaurant.txt",Integer.toString(rId -1)
            , Integer.toString(rId));
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

public void modifyFile(String fileName,String newName,String newPass,String newMail,String newphoneNumber) throws  IOException
{
    File readerFile = new File("admin.txt");
    File writerFile = new File("admin.txt");
    BufferedReader reader = null;
    FileWriter writer = null;
    String line;
    String [] arr;
    int i =0;
    String newData = "";
    try
    {
        reader = new BufferedReader(new FileReader(readerFile));
    while((line = reader.readLine()) != null)
    {
        arr = line.split(",");
        
        if(arr[0].equals(Integer.toString(this.adminId)))
        {
           //write new shit
            //writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\n",
            //        Integer.toString(this.adminId),newName,newPass,arr[3],newphoneNumber,newName,newMail));
            String modified = Integer.toString(this.adminId)+ "," +
                    newName+ "," +newPass+ ","+ arr[3] + ","+ newphoneNumber+"," +newName+ ","+newMail;
            newData = newData + modified + System.lineSeparator();
        }
        else
        {
            newData = newData + line + " " + System.lineSeparator();
           
        }
        writer = (new FileWriter(writerFile,false));
        writer.write(newData);
        
    }
    }catch(IOException E){}
    finally
        {
            try
            {
                //Closing the resources
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    
    
    writer.close();

}

public ArrayList<String> getDuplicated(String id) throws IOException
{
    ArrayList <String>duplicates = new ArrayList();
    File restaurants = new File("restaurant.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader("restaurant.txt")); 
        String l;
        String list[];
        String saveID = "-1";
        int i=0;
        while((l = reader.readLine()) != null)
        {
            list = l.split(",");
            if(i == 0)
            {
                i++;
                continue;
            }
            if(list[0].equals(id))
            {
                saveID = list[1];
                break;
            }
        }
        reader.close();
        String list2[];
        i=0;
        BufferedReader reader1= new BufferedReader(new FileReader(new File("restaurant.txt")));
        while((l = reader1.readLine()) != null)
        {
            list2 = l.split(",");
            if(i == 0)
            {
             i++;
             continue;
            }
            if(list2[1].equals(saveID))
                duplicates.add(list2[0]);
        }
    return duplicates;
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

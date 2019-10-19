/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.io.*;
import java.time.LocalDate;
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


    
    public Admin(){}
    
    public   User getUser(String id) throws IOException
    {
        
        
        //customer 
        BufferedReader readobj = new BufferedReader(new FileReader("admin.txt"));

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
        
        return null;
    }
    
public Admin(String aN, String aE, String pass
        , String uname,String resName)throws IOException
{
    super(pass, uname, LocalDate.now());
    //getting the Id of the admin and adding one to print in a file
    assistingClass obj = new assistingClass();
    this.adminId  =  obj.getId("admin.txt") +1;

    adminEmail = aE;
    adminName = aN;

       R = new restaurant(resName);


}


public void writeUser() throws IOException
{
    
    assistingClass obj = new assistingClass();
    //create the writing objects
    FileWriter c = new FileWriter("admin.txt",true);

    BufferedWriter adminWriter = new BufferedWriter(c);

    adminWriter.write(this.toString());
    writeToRestaurant();
    adminWriter.close();
    //previous admin id replace with the new incremented one in the ocnstructor
    obj.modifyFile("admin.txt",Integer.toString(adminId -1), Integer.toString(adminId));

}

public void writeToRestaurant() throws IOException
{
    assistingClass obj = new assistingClass();
    int rId = R.getRestaurantid();
    //second parameter true for appending
    FileWriter res = new FileWriter("restaurant.txt",true);

    BufferedWriter writer = new BufferedWriter(res);

    writer.write(Integer.toString(adminId)+"," + R.toString());
    obj.modifyFile("restaurant.txt",Integer.toString(rId -1), Integer.toString(rId));

    writer.close();
}

//should probably move this one to the guest class    
public void Writeadmin()throws IOException
{

        BufferedWriter out = new BufferedWriter(new FileWriter("admin.txt"));
        out.write(this.toString());
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

public String toString()
{
    //after overRiding the restaurant the toString restaurant function returns string
    return String.format("%s,%s,%s,%s\n", 
            adminId,super.toString(),adminName,adminEmail);
}

}

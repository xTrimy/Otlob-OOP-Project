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
    final String adminFile = "admin.txt";
    
    public Admin(){}
    

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

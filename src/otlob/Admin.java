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

    
    public Admin(int aId, String aN, String aE, String pass, String uname, int uId, LocalDate myObj)
    {
       super(pass, uname, uId, myObj);
       adminId = aId;
       adminEmail = aE;
       adminName = aN;

    }
    public void initializeRestaurant(String name)
    {
        R = new restaurant(name);
    }
      
    public void writeToRestaurant() throws IOException
    {
        FileWriter res = new FileWriter("restaurant.txt");

        BufferedWriter writer = new BufferedWriter(res);
        
        writer.write(this.toString());
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
        return String.format("%s,%s,%s,%s", 
                R.getRestaurant(),adminId,username,adminEmail);
    }
    
}

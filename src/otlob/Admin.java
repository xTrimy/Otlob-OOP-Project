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
    
    
    public Admin(int aId, String aN, String aE, String pass, String uname, int uId, LocalDate myObj)
    {
       super(pass, uname, uId, myObj);
       this.adminId = aId;
       this.adminEmail = aE;
       this.adminName = aN;

    }
    
        public void Writeadmin()throws IOException {
    
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
        return String.format("%s,%s,%s,%s,%s,%s", 
                adminId,adminName,adminEmail,password,userId,myObj);
    }
    
}

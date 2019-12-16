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
public abstract class User {
    protected String password;
    protected String username;
    LocalDate date = LocalDate.now();
   protected String phoneNum;
    //you need the same contructor header style in the super class
    public User()
    {
        
    }
    
    public User(String pass, String uname, LocalDate myDate,String ph)
    {
        password = pass;
        username = uname;
        phoneNum = ph;
        
        this.date = myDate;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getphoneNumber()
    {
        return phoneNum;
    }
    
    public abstract User getUser(String id) throws IOException;
    
    public abstract String getUserName();
    public abstract int getUserId();
    //declared abstract for overRiding only
    public abstract void writeUser() throws IOException;
    public abstract void Signup() throws IOException;
    
    
    @Override
    public String toString()
    {
        return String.format("%s,%s,%s,%s",username,password,date,phoneNum);
    }
    
    
    public int changePassword(){
        return 0;
    }
    
    public  String LogIn(String fileName,String userName,String password) throws IOException
    {
        //customer 
        BufferedReader readobj = new BufferedReader(new FileReader(fileName));
        boolean match = false;

        String s;
        //assistingClass obj = new assistingClass();
        //obj.passwordDecryption(arg)
        while((s = readobj.readLine()) != null)
        {
            //try because the first iteration iterates over the first line which is the size
          try
          {
               // StringTokenizer tokens = new StringTokenizer(s,",");
               String [] list = s.split(",");
                if(list[1].equals(userName) && list[2].equals(password))
                {
                    return list[0];
                    
                }

           }
           catch(ArrayIndexOutOfBoundsException exception) 
           {
           continue;
           }

        }
        return "";
        
    }
    
    
    
}

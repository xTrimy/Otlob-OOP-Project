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
    
    //you need the same contructor header style in the super class
    public User()
    {
        
    }
    
    public User(String pass, String uname, LocalDate myObj)
    {
        password = pass;
        username = uname;
        
        
        this.date = myObj;
    }
    
    public abstract User getUser(String id) throws IOException;
    
    public abstract String getUserName();
    public abstract int getUserId();
    //declared abstract for overRiding only
    public abstract void writeUser() throws IOException;
    
    
    public String toString()
    {
        return String.format("%s,%s,%s",username,password,date);
    }
    
    public Boolean verifylogin(){
        return true;
    }
    
    public int changePassword(){
        return 0;
    }
    
    public String LogIn(String fileName,String userName,String password) throws IOException
    {
        //customer 
        BufferedReader readobj = new BufferedReader(new FileReader(fileName));
                            boolean match = false;

        String s;
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
        return "incorrect userName or password";
        
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

/**
 *
 * @author ahmed
 */
public class User 
{
    protected String firstName;
    protected String lastName;
    protected int userId;
    protected dateOfBirth birthday;
    
   /* public User(String f,String l,dateOfBirth b)
    {
        firstName = f;
        lastName = l;
        birthday = b;
        
      //  System.out.printf("user is: %s",this);
    }*/
    public void iam()
    {
        System.out.println("i am some user");
    }
    public String toString()
    {
        return String.format("%s %s born in %s\n", firstName,lastName,birthday);
    }
    
}

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
public class customer extends User
{
    
    public customer(String f,String l,dateOfBirth b)
    {
        firstName = f;
        lastName = l;
        birthday = b;
    }
    public void iam()
    {
        System.out.println("i am the customer");
    }
    
    public String toString()
    {
        return String.format("%s %s born in %s customer\n", firstName,lastName,birthday);
    }
}

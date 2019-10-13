/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

/**
 *
 * @author PC
 */
public class Otlob {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
           dateOfBirth b = new dateOfBirth(26,10,2000);
       // User person = new User("ahmed","adel",b);
       // System.out.println(person);
       dateOfBirth b2 = new dateOfBirth(30,2,2019);
       dateOfBirth b3 = new dateOfBirth(20,5,30);
       
       User users[] = new User[3];
       users[0] = new customer("ahmed","adel",b);
       users[1] = new admin("hossam","mostafa",b2);
       users[2] = new customer("haada","hussein",b3);
       
       //for x in users
       for(User x: users)
       {
           System.out.print(x);  
       }
    }
    
}

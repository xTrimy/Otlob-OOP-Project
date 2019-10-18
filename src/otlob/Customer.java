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
public class Customer extends User{
    private String customerName;
    private int customerId;
    private String email;
    private String phoneNum;
    
    private Address location;
    
    
    public void report(){
        
    }
    
    
     public Customer(String cusname, int cusId, String email, String phonNum, Address loc,String pass, String uname, int uId, LocalDate myObj){
        super(pass, uname, uId, myObj);
        this.customerName = cusname;
        this.customerId  = cusId;
        this.email       = email;
        this.phoneNum  = phonNum;
        this.location = loc;

    }
     public void writedetails()throws IOException {
    
        BufferedWriter out = new BufferedWriter(new FileWriter("Customer.txt"));
        out.write(this.toString());
    }
    
    public void SetName(String name){
        name = customerName;
    }
    
    public String GetName(){
        return customerName;
    }
    
       //overriding
    public String toString()
    {
        return String.format("%s,%s,%s,%s,%s", 
                customerName,customerId,email,phoneNum,location);
    }
}

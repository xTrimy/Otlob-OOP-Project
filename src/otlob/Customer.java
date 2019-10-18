/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;


/**
 *
 * @author Zeina Ayman
 */
public class Customer extends User{
    private String customerName;
    private int customerId;
    private String email;
    private String phoneNum;
    
    private Address address;
    
    public void report(){
        
    }
    
    public void SetName(String name){
        name = customerName;
    }
    
    public String GetName(){
        return customerName;
    }
    
    
}

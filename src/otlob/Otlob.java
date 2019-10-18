/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.IOException;

/**
 *
 * @author PC
 */
public class Otlob {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
      
        restaurant r = new restaurant("mac",4);
        
        r.writeToRestaurant();
                r.Readrestaurant();

        meal m = new meal("burger","onions blah blah",(float)55.5,5);
        m.writeToMeals();
        
    }
    
}

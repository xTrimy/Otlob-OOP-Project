/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

/**
 *
 * @author AdhamHamzawy
 */
public class Rating {
  
    protected String rateId;
    protected String restaurantId;
    protected int deliveryTime; //inseconds
    protected double money;  
    protected int foodQuality;
    public void Rating(String rateId){
        // get rating info
    }
    public String toString(){
        return String.format("%s,%s,%s,%s,%s",
                rateId,restaurantId,deliveryTime,money,foodQuality);
    }
   
   
}

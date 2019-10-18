/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.time.*;
/**
 *
 * @author PC
 */

//InoviceType
public class Invoice {
    private float subTotal;
    private float deliveryFee;
    private String paymentMethod;
    private LocalDate date;    
    private LocalTime time;
    public String getData(){
        return subTotal+","+deliveryFee+","+paymentMethod+","+date+","+time;
    }
}

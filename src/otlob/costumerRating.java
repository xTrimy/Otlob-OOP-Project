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
public class costumerRating extends Rating {
    private int costumerId;
    private int restaurantId;
    private String message;
    public void cosutemerRating(int costumerId, int restaurantId, String message){
        this.costumerId = costumerId;
        this.restaurantId = restaurantId;
        this.message = message;
    }
    public void setRating(){
        //Add rating to file
    }
}

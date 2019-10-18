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
public class OffersInbox extends Inbox {
    private int restaurantId;
    private float percentage;
    private String content;
    @Override
    public String readMessages(){
        return content;
    }
}

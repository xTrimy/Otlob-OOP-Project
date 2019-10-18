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
public class Address {
    protected String appartmentNumber;
    protected String appartmentDescription;
    protected String appartmentLocation;
    protected String buildingNumber;
    protected String landlineNumber;
    
    public Address(String aN, String aD, String aL, String bN, String Ln){
        this.appartmentNumber = aN;
        this.appartmentDescription = aD;
        this.appartmentLocation = aL;
        this.buildingNumber = bN;
        this.landlineNumber = Ln;
    }
    
}

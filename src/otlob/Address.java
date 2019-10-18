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
    private String appartmentNumber;
    private String appartmentDescription;
    private String appartmentLocation;
    private String buildingNumber;
    private String landlineNumber;
    
    public Address(String aN, String aD, String aL, String bN, String Ln){
        this.appartmentNumber = aN;
        this.appartmentDescription = aD;
        this.appartmentLocation = aL;
        this.buildingNumber = bN;
        this.landlineNumber = Ln;
    }
    
    public String toString()
    {
      return String.format("%s,%s,%s,%s,%s"
              ,appartmentNumber,appartmentDescription,appartmentLocation
                ,buildingNumber,landlineNumber);
              
    }
    
}

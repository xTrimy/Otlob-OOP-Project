/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

/**
 *
 * @author ahmed
 */
public class dateOfBirth
{
    private int year;
    private int month;
    private int day;
    
    public dateOfBirth(int d,int m,int y)
    {
        year = y;
        month = m;
        day = d;
        
    }
    
    public String toString()
    {
        return String.format("%d/%d/%d",day,month,year);
    }
}

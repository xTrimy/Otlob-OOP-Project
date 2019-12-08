/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.io.*;
/**
 *
 * @author PC
 */
import java.io.IOException;
import java.util.*;
import java.time.LocalDate;
import javax.swing.JFrame;

public class Otlob {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args)throws IOException 
    {
        LogInGUI d = new LogInGUI();
        d.setVisible(true);
        
       d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
       
    

}
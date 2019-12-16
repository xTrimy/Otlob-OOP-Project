/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.Admingui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.accessibility.*;
import javax.swing.filechooser.*;
import java.text.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import otlob.Admin;
import otlob.assistingClass;
/**
 *
 * @author ahmed
 */
public class adminPanel extends JPanel
{
    
    adminPanel(){
    //headers for the table
        String[] columns = new String[] {
            "username", "date",  "mobile","Email"
        };
         
        
        //create table with data
        Admin a = new Admin();
       ArrayList<String> duplicates = null;
        try {
            duplicates = a.getDuplicated(Integer.toString(6));
        } catch (IOException ex) {
            Logger.getLogger(adminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       assistingClass obj = new assistingClass();
       String[][] arr = null;
        try {
            arr = obj.ReadFile("admin.txt", duplicates);
        } catch (IOException ex) {
            Logger.getLogger(adminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        String dropped0[][] = obj.removeCol(arr, 0);
        String droppedPass[][] = obj.removeCol(dropped0,1);
        String droppedduplicaes[][] = obj.removeCol(droppedPass, 3);
       // obj.removeCol(arr,3);
       
       
        JTable table = new JTable(droppedduplicaes, columns);
        table.setEnabled(false);
        JScrollPane p = new JScrollPane(table);
        p.setBackground(Color.WHITE);
        p.getViewport().setBackground(Color.WHITE);
        this.add(p);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        this.setBackground(Color.WHITE);
    }
}

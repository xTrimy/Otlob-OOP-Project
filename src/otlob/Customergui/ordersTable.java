/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.Customergui;
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
import javax.swing.table.DefaultTableModel;
import otlob.assistingClass;
/**
 *
 * @author ahmed
 */
public class ordersTable  extends JPanel
{
    ordersTable() throws IOException{
        assistingClass helper = new assistingClass();
        
    //headers for the table
        String[] columns = new String[] {
            "id", "uname", "pass", "date","name","mail"
        };
         
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "John", 40.0, false },
            {2, "Rambo", 70.0, false },
            {3, "Zorro", 60.0, true },
        };
        
        //will raise an out of bounds exception for the first index 
        //becuase of the first line!!!
       String [][] o = (String[][])helper.ReadFile("admin.txt");
        //create table with data

        JTable table = new JTable(o, columns);
        JScrollPane p = new JScrollPane(table);
       p.setBackground(Color.WHITE);
        p.getViewport().setBackground(Color.WHITE);
        this.add(p);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
       this.setBackground(Color.WHITE);
        
    }

    
}

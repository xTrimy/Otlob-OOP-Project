/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.*;
import java.util.Set;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import javax.swing.border.CompoundBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.accessibility.*;
import javax.swing.filechooser.*;
import java.text.*;
/**
 *
 * @author ahmed
 */
public class cart extends JPanel
{
    private String[][] data;

  public cart (String[][] data) throws FileNotFoundException, IOException{
        
        Container cp = this;
        cp.setLayout(null);
        
        JLabel label;
        this.data = data;
        String str = "";
        String name = "";
        String price = "";
        int x = 220;
        int x2 = 220;
        int x3 =220;
        int y = 70;
        int y2 = 70;
        int y3 = 70;
        
        int i =0;
        int j =0;
        int z = 0;
        
        for(int k=0; k<data.length;k++)
        {
            String[] words = str.split(",");
        
        label = new JLabel(words[1]);
        cp.add(label);
        i++;
        label.setBounds(x,y,100,50);
        y+=20;
        if (y > 280){
            break;
        }
        String []names = name.split(",");
        label = new JLabel(words[2]);
        cp.add(label);
        j++;
        label.setBounds(x2+80 , y2, 100,50);
        y2+=20;
        if (y2 > 280){
            break;
        }
        String[]prices = price.split(",");
        label = new JLabel(words[3]);
        cp.add(label);
        z++;
        label.setBounds(x3+160,y3,100,50);
        y3+=20;
        if (y3 > 280){
            break;
        }
        
        }
        
        
        
        
//        while((str=reader.readLine())!=null)
//        {
//           
//            String[] words1 = str.split(",");
//        
//        label = new JLabel(words1[2]);
//        cp.add(label);
//        label.setBounds(x+80,y,100,50);
//        y+=20;
//        }
//        
//        for (int i = 0;i<100;i++){
//            label = new JLabel(System.out.println(words[]));
//        }
    
    JButton B1 = new JButton("CLEAR CART");
    JButton B2 = new JButton("PLACE ORDER");
    JLabel L1 = new JLabel ("MY CART");
    JLabel L2 = new JLabel ("How would you like to pay?");
    JLabel L3 = new JLabel ("TOTAL");
    JLabel L4 = new JLabel ("Product");
    JLabel L5 = new JLabel ("Quatity");
    JLabel L6 = new JLabel ("Price");
    
    
    JRadioButton cash = new JRadioButton("Cash" , true);
    JRadioButton credit = new JRadioButton("Credit Card" , false);
    ButtonGroup Payment = new ButtonGroup();
    cp.add(cash);
    cp.add(credit);
    Payment.add(cash);
    Payment.add(credit);
    cp.add(B1);
    cp.add(B2);
    cp.add(L1);
    cp.add(L2);
    cp.add(L3);
    cp.add(L4);
    cp.add(L5);
    cp.add(L6);
    
    cash.setBounds(380, 350, 70, 50);
    credit.setBounds(450,350,90,50);
    L1.setBounds(300,5,80,50);
    L2.setBounds(200,350,170,50);
    L3.setBounds(230,300,50,50);
    L4.setBounds(220,50,50,15);
    L5.setBounds(300,50,50,15);
    L6.setBounds(380,50,50,15);
    B1.setBounds(370,420,200,60);
    B1.setBackground(Color.WHITE);
    
        
    B2.setBounds(150,420,200,60);
    B2.setBackground(Color.RED);
    
    
    }
    
}

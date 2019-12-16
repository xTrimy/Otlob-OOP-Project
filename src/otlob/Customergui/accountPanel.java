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
import otlob.Admin;
import otlob.Customer;
import otlob.assistingClass;
/**
 *
 * @author ahmed
 */
public class accountPanel extends JPanel
{
    //for the my account panel
    JTextField profileTypeT = new JTextField(10);
    JTextField NameT = new JTextField(10);
    JTextField EmailT = new JTextField(30);
    JTextField passwordT = new JTextField(30);
    JTextField addressT = new JTextField(15);
    JButton EditB = createSimpleButton("Edit");
    JButton submitEdit = createSimpleButton("submit");
    
    private String oldname ;
    private String oldMail;
    
    accountPanel(Customer current) 
    {
        profileTypeT.setEnabled(false);
        NameT.setEnabled(false);
        EmailT.setEnabled(false);
        passwordT.setEnabled(false);
        addressT.setEnabled(false);
        
        oldname = current.getUserName();
        oldMail = current.getmail();
        //String oldAdd = current.getAdress();
        profileTypeT.setText("Customer");
        NameT.setText(current.getUserName());
        EmailT.setText(current.getmail());
       // resNameT.setText(current.getResName());
           this.setLayout(null);
        //for the y between labels and fields
        //leave a difference of 40 y axis points
        JLabel pL = new JLabel("ProfileType");
        pL.setBounds(70, 30, 70, 30);
        profileTypeT.setBounds(70, 60, 150, 30);
        this.add(pL);
        this.add(profileTypeT);
        
        JLabel NL = new JLabel("Name");
        NL.setBounds(0,100,50,50);
        NameT.setBounds(0,140,150,30);
        this.add(NL);
        this.add(NameT);
        
        JLabel EL = new JLabel("Email");
        EL.setBounds(170,100,50,50);
        EmailT.setBounds(170,140,150,30);
        this.add(EL);
        this.add(EmailT);
        
        JLabel AL = new JLabel("password");
        AL.setBounds(0,180,50,50);
        passwordT.setBounds(0,220,150,30);
        this.add(AL);
        this.add(passwordT);
        
        JLabel PL = new JLabel("Address");
        PL.setBounds(170,180,100,50);
        addressT.setBounds(170,220,150,30);
        this.add(PL);
        this.add(addressT);
        
        EditB.setBounds(120,350,70,30);
        this.add(EditB);
        submitEdit.setBounds(200,350,70,30);
        this.add(submitEdit);
        EditB.addActionListener(new action());
        submitEdit.addActionListener(new action());
    }
    
    
    class action implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Object obj = e.getSource();
            if(obj.equals(EditB))
            {
                
                NameT.setEnabled(true);
                EmailT.setEnabled(true);
                passwordT.setEnabled(true);
                
                
            }
            else if(obj.equals(submitEdit))
            {
                String newName = NameT.getText();
                String newmail =  EmailT.getText();
                String newpass = passwordT.getText();
                //String loc = addressT.getText();
                assistingClass helper = new assistingClass();
                helper.modifyFile("customer.txt",oldname,newName);
                helper.modifyFile("customer.txt",oldMail,newmail);
                //helper.modifyFile("customer.txt",,newpass);
                
            }
        }
        
    }
    
    private static JButton createSimpleButton(String text) {
  JButton button = new JButton(text);
  button.setBorderPainted(true);
  button.setForeground(Color.WHITE);
  button.setBackground(Color.RED);
  Border line = new LineBorder(Color.BLACK);
  Border margin = new EmptyBorder(5, 15, 5, 15);
  Border compound = new CompoundBorder(line, margin);
  button.setBorder(compound);
  return button;
}
}

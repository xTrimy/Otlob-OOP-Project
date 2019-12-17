/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * @author ahmed
 */
public class chooseType extends JFrame
{
    private JRadioButton typeAdmin = new JRadioButton();
    private JLabel adminL = new JLabel("admin type");
    private JLabel cusL = new JLabel("customer type");
    private JLabel suppL = new JLabel("Support Admin type");
    private JRadioButton typeCustomer = new JRadioButton();
    private JRadioButton typeSupport = new JRadioButton();
    private ButtonGroup bg = new    ButtonGroup();
    
    private JButton b = new JButton("RUN");
    chooseType()
    {
        setSize(300,400);
        setLayout(null);
        bg.add(typeAdmin);
        bg.add(typeCustomer);
        bg.add(typeSupport);
        typeAdmin.setBounds(100, 100, 30, 30);
        adminL.setBounds(30,90,100,40);
        cusL.setBounds(20,150,100,40);
        typeCustomer.setBounds(100,160,30,30);
        typeSupport.setBounds(150,210,30,30);
        suppL.setBounds(30,190,150,50);
        Container cp = getContentPane();
        cp.add(typeAdmin);
        cp.add(adminL);
        cp.add(typeCustomer);
        cp.add(typeAdmin);
        cp.add(cusL);
        cp.add(typeSupport);
        cp.add(suppL);
        
        b.setBounds(200,260,60,30);
       
        cp.add(b);
        
        b.addActionListener(new run());
    }
    
    
    class run implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean customer = typeCustomer.isSelected();
            boolean admin = typeAdmin.isSelected();
            boolean supp = typeSupport.isSelected();
            System.out.println(admin);
            System.out.println(customer);
            if(admin)
            {
                try{
                LogInGUI obj = new LogInGUI(0);
                obj.setVisible(true);
                dispose();
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }catch(IOException E){}
            }
            else if(customer)
            {
                try{
                LogInGUI obj = new LogInGUI(1);
                obj.setVisible(true);
                dispose();
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }catch(IOException E){}
            }
            else if(supp)
            {
                try{
                LogInGUI obj = new LogInGUI(2);
                obj.setVisible(true);
                dispose();
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }catch(IOException E){}
                        
            }
            if(admin == false && customer == false && supp == false)
            {
                JOptionPane.showMessageDialog(null,"please choose one of the options", "please choose",JOptionPane.INFORMATION_MESSAGE);
            }

            }
    }
}

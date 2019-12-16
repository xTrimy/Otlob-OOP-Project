/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.Admingui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTextField.*;
import javax.swing.border.*;
import otlob.Address;
import otlob.Admin;
import otlob.Customer;
import otlob.SignupGUI;
import otlob.User;
import otlob.assistingClass;
/**
 *
 * @author ahmed
 */
public class AddAdminsPanel extends JPanel
{
    
    private JTextField user,email,res,phoneNum;
    JPasswordField pass;
    private JLabel luser,lpass,lemail,lres,lphoneNum;
   
    private JButton save = createSimpleButton("Add Admin");
    
    private Admin current;
    AddAdminsPanel(Admin current)
    {
        this.current = current; 
        setLayout(null);
        setBackground(Color.WHITE);
        luser = new JLabel("userName");
        luser.setBounds(65,70,70,70);
        user = new JTextField();
        user.setBounds(65,120,150,30);
        this.add(luser);
        this.add(user);
        
        lpass = new JLabel("password");
        lpass.setBounds(65,120,70,70);
        pass = new JPasswordField();
        pass.setEchoChar('*');
        pass.setBounds(65,170,150,30);
        this.add(lpass);
        this.add(pass);
        
        lemail = new JLabel("email");
        lemail.setBounds(65,180,70,70);
        email = new JTextField();
        email.setBounds(65,230,150,30);
        this.add(lemail);
        this.add(email);
        
        lphoneNum = new JLabel("phone number");
        lphoneNum.setBounds(65,230,100,100);
        phoneNum = new JTextField();
        phoneNum.setBounds(65,290,150,30);
        this.add(lphoneNum);
        this.add(phoneNum);
        
        save.setBounds(250,400,70,30);
        this.add(save);
        save.addActionListener(new action());
        
    }
    
    
    
    public class action implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {   assistingClass obj = new assistingClass();
            String Tmail = email.getText();
            String Tpass = pass.getText();
            String TphoneNum = phoneNum.getText();
            String Tname = user.getText();
            System.out.println(Tmail);
            if(Tmail.equals("") || Tpass.equals("") ||Tname.equals("") || TphoneNum.equals(""))
            {
                
                 JOptionPane.showMessageDialog(null, "one of the fields was left empty ", 
                            "InfoBox: " + "invalid", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                if(obj.validateMail(Tmail).equals("valid"))
                {
                    if(obj.validateMobile(TphoneNum).equals("valid"))
                    {
                        Object[] options = { "YES", "NO" };
                       int n= JOptionPane.showOptionDialog(null, "Are you sure you want to save?", "Warning",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                        HashMap <String,String[]>content = obj.readFiletoHashMap("restaurant.txt");
                        String []resData = content.get(Integer.toString(current.getUserId()));
                        System.out.println(current.getUserId());
                        if(n == JOptionPane.YES_OPTION)
                        {
                            System.out.println("said yes");
                            try {
                                System.out.println(resData[0]);
                                System.out.println(resData[1]);
                                System.out.println(resData[2]);
                                Admin newAdmin = new Admin(Tname,Tmail,Tpass,Tname,resData[0],TphoneNum);
                                newAdmin.addAdmin(newAdmin, resData[0],resData[1],resData[2]);
                            } catch (IOException ex) {
                                Logger.getLogger(AddAdminsPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        else if(n == JOptionPane.NO_OPTION)
                        {
                            System.out.println("said no");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "invalid phone Number", 
                            "InfoBox: " + "invalid mobile", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "invalid email", 
                            "InfoBox: " + "invalidmail", JOptionPane.INFORMATION_MESSAGE);

                }

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

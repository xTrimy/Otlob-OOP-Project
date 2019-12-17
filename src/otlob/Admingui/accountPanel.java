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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import otlob.Admin;
import otlob.DataVisualiztaion.PieChart;
import otlob.DataVisualiztaion.filterData;
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
    JTextField resNameT = new JTextField(15);
    JButton EditB = createSimpleButton("Edit");
    JButton submitEdit = createSimpleButton("submit");
    JButton statB = createSimpleButton("see statistics");
    private String oldname ;
    private String oldMail;
    Admin current;
    accountPanel(Admin current)
    {
        statB.setBounds(200,250,150,30);
        this.current = current;
        this.add(statB);
        profileTypeT.setEnabled(false);
        NameT.setEnabled(false);
        EmailT.setEnabled(false);
        passwordT.setEnabled(false);
        //restaurant stuff is for the phone number
        resNameT.setEnabled(false);
        resNameT.setText(current.getphoneNumber());
        passwordT.setText(current.getPassword());
        System.out.println(current.getUserName());
        oldname = current.getUserName();
        oldMail = current.getmail();
        profileTypeT.setText("Admin");
        NameT.setText(current.getUserName());
        EmailT.setText(current.getmail());
//        resNameT.setText(current.getResName());
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
        
        JLabel PL = new JLabel("phone Number");
        PL.setBounds(170,180,100,50);
        resNameT.setBounds(170,220,150,30);
        this.add(PL);
        this.add(resNameT);
        
        EditB.setBounds(120,350,70,30);
        this.add(EditB);
        submitEdit.setBounds(200,350,70,30);
        this.add(submitEdit);
        EditB.addActionListener(new action());
        submitEdit.addActionListener(new action());
                statB.addActionListener(new action());

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
                resNameT.setEnabled(true);
                
            }
            else if(obj.equals(submitEdit))
            {
                Object[] options = { "YES", "NO" };
                   int n= JOptionPane.showOptionDialog(null, "Are you sure you want to save?", "Warning",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);

                    if(n == JOptionPane.YES_OPTION)
                    {
                        System.out.println("said yes");
                       // Admin newAdmin = new Admin();
                       String newName = NameT.getText();
                        String newmail =  EmailT.getText();
                        String newpass = passwordT.getText();
                        String newphoneNumber = resNameT.getText();
                    try {
                        current.modifyFile("admin.txt",newName,newpass,newmail,newphoneNumber);
                        
                    } catch (IOException ex) {
                        Logger.getLogger(accountPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                        assistingClass helper = new assistingClass();
//                        helper.modifyFile("admin.txt",oldname,newName);
//                        helper.modifyFile("admin.txt",oldMail,newmail);
                       // helper.modifyFile("admin.txt",,newpass);

                    }
                    else if(n == JOptionPane.NO_OPTION)
                    {
                        System.out.println("said no");
                    }
                    
                
                
            }
            if(obj.equals(statB))
                    {
                    try {
                        assistingClass o = new assistingClass();
                            HashMap<String,String[]> read = o.readFiletoHashMap("restaurant.txt");
                            
                            String[] resID = (read.get(Integer.toString(current.getUserId())));
                            filterData helper = new filterData();
                            System.out.println(resID[0]);
                            ArrayList<String> ids = helper.getMealIds(resID[0]);
                            HashMap<String,Integer> count = helper.countIt(ids);
                            int i =0;
                            String IDS[] = new String[count.size()];
                            int numberoftimes[] = new int[count.size()];
                                 for (String name: count.keySet()){
                                                String key = name.toString();
                                                int value = count.get(name); 
                                                IDS[i] = key;
                                                numberoftimes[i] = value;
                                                i++;
                                                System.out.println(key + " " + value);  
                                    }
                                 JFrame f = new JFrame();
                                 f.setSize(500,500);
                                 f.setResizable(false);
                                 f.setVisible(true);
                                 PieChart pie = new PieChart(200,150,0,numberoftimes,IDS,true,f);
                                 f.add(pie.draw());
                        } catch (IOException ex) {
                            Logger.getLogger(accountPanel.class.getName()).log(Level.SEVERE, null, ex);
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

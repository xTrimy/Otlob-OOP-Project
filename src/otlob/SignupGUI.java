/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Zeina Ayman
 */
public class SignupGUI extends JFrame{
    
    private JTextField user,pass,fnamelname,email,phone,add,apparnumber,builnumber,landnumber;
    private JLabel luser,lpass,lfnamelname,lemail,lphone,ladd,lapparnumber,lbuilnumber,llandnumber;
    private JPanel SignupPanel;
    private JButton save;
    
    public SignupGUI() throws IOException
    {
       
         setSize(500,750);
        save = new JButton("         Save         ");
        user = new RoundJTextField(21);
        pass = new RoundJTextField(21);
        fnamelname = new RoundJTextField(21);
        phone = new RoundJTextField(21);
        add = new RoundJTextField(21);
        apparnumber = new RoundJTextField(21);
        builnumber = new RoundJTextField(21);
        landnumber = new RoundJTextField(21);
        email = new RoundJTextField(21);
        luser = new JLabel("Username");
        lpass = new JLabel("Password");
        lfnamelname = new JLabel("First and Last name");
        lemail = new JLabel("Email");
        lphone = new JLabel("Phone");
        ladd = new JLabel("Address");
        lapparnumber = new JLabel("Appartment number");
        lbuilnumber = new JLabel("Building Number");
        llandnumber = new JLabel("LandLine number");
        
        SignupPanel = new JPanel();
        JPanel LogoPanel = new JPanel();
        SignupPanel.setLayout(new FlowLayout());
        JPanel twoPanelContainer = new JPanel();
        //twoPanelContainer = new JPanel(new GridLayout(2,1));
        twoPanelContainer.setLayout(null);

        twoPanelContainer.add(LogoPanel);
        LogoPanel.setBounds(0, 0, 250, 250);
        twoPanelContainer.add(SignupPanel);


        SignupPanel.setBounds(0, 250, 250, 500);
        
        JPanel allThree = new JPanel(new GridLayout(1,2));
        allThree.add(twoPanelContainer);
        allThree.add(new imagePanel());
        
        BufferedImage img = ImageIO.read(new File("logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(img));
        LogoPanel.setLayout(new BorderLayout());
        LogoPanel.add(picLabel,BorderLayout.CENTER);

        SignupPanel.add(luser);
        SignupPanel.add(user);
        SignupPanel.add(lpass);
        SignupPanel.add(pass);
        SignupPanel.add(lfnamelname);
        SignupPanel.add(fnamelname);;
        SignupPanel.add(lemail);
        SignupPanel.add(email);
        SignupPanel.add(lphone);
        SignupPanel.add(phone);
        SignupPanel.add(ladd);
        SignupPanel.add(add);
        SignupPanel.add(lapparnumber);
        SignupPanel.add(apparnumber);
        SignupPanel.add(lbuilnumber);
        SignupPanel.add(builnumber);
        SignupPanel.add(llandnumber);
        SignupPanel.add(landnumber);
        SignupPanel.add(save);
        SignupPanel.setBackground(Color.white);
        LogoPanel.setBackground(Color.white);
        //JScrollPane scrollPane = new JScrollPane(allThree);
        //cp.add(panel2, "East");
        save.addActionListener(new ButtonWatcher());
        
        getContentPane().add(allThree);
        //getContentPane().add(scrollPane, "South");
       // JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300);

        
        
    }
    
    public class imagePanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            this.setBackground(Color.gray);
            BufferedImage img = null;
            try{
             img = ImageIO.read(new File("img1.png"));}
            catch(IOException e){System.out.println("error");}
           
           
            //g.drawImage(img, 0, 0, null);
            g.drawImage(img, 0, 0, 500, 750, null);
         
  
        }
        
        
    }
    
    
    private class ButtonWatcher implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent a)
        {
            Object buttonPressed = a.getSource();
            assistingClass obj = new assistingClass();
            if(buttonPressed == save)
            {
                if("".equals(user.getText()) || "".equals(pass.getText()) || "".equals(fnamelname.getText())|| "".equals(email.getText())|| "".equals(phone.getText())|| "".equals(add.getText())|| "".equals(apparnumber.getText())|| "".equals(builnumber.getText())|| "".equals(landnumber.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Please enter missing fields. ", "ERROR" , JOptionPane.ERROR_MESSAGE);
                }
                else if(user.getText().length() < 3)
                {
                    JOptionPane.showMessageDialog(null, "Name must be at least 3 characters", "ERROR" , JOptionPane.ERROR_MESSAGE);
                }
                else {
                        
                        try {
                            User signup;
                            Address location = new Address(add.getText(),"test",apparnumber.getText(),builnumber.getText(),landnumber.getText());
                            signup = new Customer(user.getText(),email.getText(),phone.getText()
                                    ,location,pass.getText(),fnamelname.getText(),LocalDate.now());
                            signup.writeUser();
                            LogInGUI log = new LogInGUI(1);
                            dispose();
                            log.setVisible(true);
                            
                        } catch (IOException ex) {
                            Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

            }
        }
    }
    
    
        public class RoundJTextField extends JTextField 
    {
        private Shape shape;
        public RoundJTextField(String text,int size) {
            super(text,size);
            setOpaque(false); // As suggested by @AVD in comment.
        }
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false); // As suggested by @AVD in comment.
        }

        protected void paintComponent(Graphics g) {
             g.setColor(getBackground());
             g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
             super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
             g.setColor(getForeground());
             g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        public boolean contains(int x, int y) {
             if (shape == null || !shape.getBounds().equals(getBounds())) {
                 shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
             }
             return shape.contains(x, y);
        }
    }

}

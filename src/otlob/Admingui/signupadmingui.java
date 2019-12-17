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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import otlob.Address;
import otlob.Admin;
import static otlob.Admingui.adminFrame.imageIoWrite;
import otlob.Customer;
import otlob.LogInGUI;
import otlob.SignupGUI;
import otlob.User;
import otlob.assistingClass;
import otlob.guiassets.ToastMessage;
/**
 *
 * @author ahmed
 */
public class signupadmingui extends JFrame{
    private JTextField user,pass,email,res,phoneNum;
    private JLabel luser,lpass,lemail,lres;
    private JPanel SignupPanel;
    private JButton save;

    private JButton uploadPicture;
    signupadmingui actualPanel = this;
     private File choosenPic ;

    public signupadmingui()throws IOException
    {
        
        setSize(500,750);
        uploadPicture = new JButton("upload picture");
        save = new JButton("         Save         ");
        user = new RoundJTextField(21);
        pass = new RoundJTextField(21);
        res = new RoundJTextField(21);
        email = new RoundJTextField(21);
        luser = new JLabel("Username");
        lpass = new JLabel("Password");
        lemail = new JLabel("Email");
        lres = new JLabel("restaurantName");
        phoneNum = new RoundJTextField(21);

        uploadPicture.addActionListener(new ButtonWatcher());
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
        SignupPanel.add(new JLabel("Phone Number"));
        SignupPanel.add(phoneNum);
        SignupPanel.add(lemail);
        SignupPanel.add(email);
        SignupPanel.add(lres);
        
        SignupPanel.add(res);
        SignupPanel.add(uploadPicture);
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
            if(buttonPressed.equals(save))
            {
                User signup;
                String userName = user.getText();
                String mail = email.getText();
                String password = pass.getText();
                String resName = res.getText();
                String phoneNumber = phoneNum.getText();
                if(userName.equals("")|| mail.equals("")||password.equals("")||resName.equals("")||phoneNumber.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "one of the fields was left empty ", 
                            "InfoBox: " + "invalid", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    assistingClass validate = new assistingClass();
                    if(validate.validateMail(mail).equals("valid"))
                    {
                        if(validate.validateMobile(phoneNumber).equals("valid"))
                        {
                            try {
                                //    private JTextField user,pass,email,res;

                                signup = new Admin(user.getText(),email.getText(),
                                        pass.getText(),user.getText(),res.getText(),phoneNum.getText());
                                signup.writeUser();
                                JOptionPane.showMessageDialog(null,"All set!", "please choose",JOptionPane.INFORMATION_MESSAGE);
                                actualPanel.dispose();
                               LogInGUI obj = new LogInGUI(0);
                               obj.setVisible(true);

                            } catch (IOException ex) {
                                Logger.getLogger(SignupGUI.class.getName()).log(Level.SEVERE, null, ex);
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
            if(buttonPressed.equals(uploadPicture))
            {
                // picchooser 
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
               "JPG & GIF Images", "jpg", "gif");
               chooser.setFileFilter(filter);

               chooser.setBounds(30,350,300,300);

               JPanel p = new JPanel();
               p.setSize(300,300);
                p.setVisible(true);
               int returnVal = chooser.showOpenDialog(p);
        
                if(returnVal == JFileChooser.APPROVE_OPTION) 
                {
                 choosenPic = chooser.getSelectedFile();
                    System.out.println(choosenPic);
                  BufferedImage img = null;
                     try{
                      img = ImageIO.read(choosenPic);
                      assistingClass o = new assistingClass();
                     imageIoWrite(choosenPic, ".//logos//"+(o.getId("restaurant.txt")+1) + ".jpg");
                     ToastMessage t = new ToastMessage("picture selected");
                     t.display();
                     }
                     catch(IOException ee){System.out.println("something with iamges");}    
                  //System.out.println("getSelectedFile() : " + );
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

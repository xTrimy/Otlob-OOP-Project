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
import otlob.Admin;
/**
 *
 * @author ahmed
 */
public class adminFrame extends JFrame  implements Accessible
{
    JLabel AccountL = new JLabel("Account");
    JLabel AdminsL = new JLabel("Admins");
    JLabel HomeL = new JLabel("Home");
    
        JPanel current = new JPanel();
    JPanel AccountP;
    JPanel HomeP = new adminHome();
    //JPanel AdminsP = new JPanel();
    JPanel AdminsP = new adminPanel();

    Container cp = getContentPane();
    JPanel dashBoardP ;
    dashBoard d = new dashBoard(0,100);
    
    Admin currentA;
    
    public adminFrame(Admin currentA) throws IOException
    {
        
        this.currentA = currentA;
        AccountP = new accountPanel(currentA);
        setSize(790,500);
        current = HomeP;
       
       
        dashBoardP = d;
        //dashboard panel
        dashBoardP.add(HomeL);
        dashBoardP.add(Box.createRigidArea(new Dimension(0, 20)));
        dashBoardP.add(AccountL);
        dashBoardP.add(Box.createRigidArea(new Dimension(0,20)));
        dashBoardP.add(AdminsL);
        dashBoardP.add(Box.createRigidArea(new Dimension(0,this.getHeight()-300)));
        setFont(AdminsL);
        setFont(HomeL);
        setFont(AccountL); 
        HomeL.setForeground(Color.WHITE);

     
        current.setBackground(Color.WHITE);
        this.setTitle("admin view");
        cp.setLayout(new GridLayout(1,2));
        //changes te color of the dashboard someHow !!
        cp.setBackground(Color.WHITE);
        cp.add(dashBoardP);
        cp.add(current);
       
        HomeL.addMouseListener(new RectListener());
        AccountL.addMouseListener(new RectListener());
        AdminsL.addMouseListener(new RectListener());
    
    }
 
 
    private  void setFont(JLabel label)
    {
        int area = this.getWidth() * this.getHeight();
        System.out.println(area);
        label.setFont(new Font("Courier New", Font.BOLD, 30));
        label.setForeground(Color.BLACK);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
    }
    
    //listener for the labels
    public class RectListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
                //System.out.println(e.getX() + ", " + e.getY());
                Object obj = e.getSource();
                if(obj.equals(AccountL))
                {                     
                    cp.remove(current);
                    current = null;
                    
                    current = AccountP;
                    cp.add(current);
                     current.setBackground(Color.WHITE);
                    getContentPane().repaint();
                    getContentPane().validate();
                }
                if(obj.equals(HomeL))
                {
                    cp.remove(current);
                    current = null;
                    //JPanel ad = new JPanel();
                    //setHomePage(ad);
                    current = HomeP;
                    cp.add(current);
                    current.setBackground(Color.WHITE);
                    getContentPane().repaint();
                                        getContentPane().validate();

                }
                if(obj.equals(AdminsL))
                {
                    cp.remove(current);
                    current = null;
                    //JPanel ad = new JPanel();
                    //setAdminPanel(ad);
                    current = AdminsP;
                    cp.add(current);
                     current.setBackground(Color.WHITE);
                    getContentPane().repaint();
                    getContentPane().validate();

                }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }
    
  public static void imageIoWrite(File i) {
         BufferedImage bImage = null;
         try {
             //File initialImage = new File("C://Users/Rou/Desktop/image.jpg");
             bImage = ImageIO.read(i);
 
             ImageIO.write(bImage, "jpg", new File("iii.jpg"));
            
 
         } catch (IOException e) {
               System.out.println("Exception occured :" + e.getMessage());
         }
         System.out.println("Images were written succesfully.");
    }
    
}

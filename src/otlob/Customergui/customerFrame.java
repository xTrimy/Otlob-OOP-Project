/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.Customergui;
import otlob.guiassets.dashBoard;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import otlob.ChattingSystem.ClientChattingSystem;
import otlob.Customer;
import otlob.cart;
/**
 *
 * @author ahmed
 */
public class customerFrame extends JFrame
{
    JLabel AccountL = new JLabel("Account");
    JPanel AccountLPanel = new JPanel();
    //should be replaced with orders
    JLabel AdminsL = new JLabel("orders");
    JPanel AdminsLPanel = new JPanel();
    JLabel HomeL = new JLabel("Home");
    JLabel CartL = new JLabel("My Cart");
    JPanel HomeLPanel = new JPanel();
    JPanel CartPanel = new JPanel();
    JLabel[] myLabels = {AccountL, AdminsL, HomeL, CartL};    
    JPanel[] myLabelPanels = {AccountLPanel, AdminsLPanel, HomeLPanel, CartPanel};
    JPanel current = new JPanel();
    JPanel AccountP;
    JPanel HomeP = new customerHome();
    //JPanel AdminsP = new JPanel();
    JPanel orders = new ordersTable();
    JPanel CartP = new JPanel();
    JButton customerService = new JButton("Customer Service");

    Container cp = getContentPane();
    JPanel dashBoardP ;
    dashBoard d = new dashBoard(0,100);
    

    public customerFrame(Customer currentC) throws IOException
    {
        for(int i = 0; i<myLabels.length;i++){
            myLabelPanels[i].setMinimumSize(new Dimension(512,100));
            myLabelPanels[i].setAlignmentX(RIGHT_ALIGNMENT);
            myLabelPanels[i].setMaximumSize(new Dimension(1000,100));
            myLabelPanels[i].add(myLabels[i]);
            myLabelPanels[i].setBackground(Color.WHITE);
            myLabels[i].setForeground(Color.BLACK);
        }
        AccountP = new accountPanel(currentC);
        setSize(790,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setResizable(false);
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        current = HomeP;
        dashBoardP = d;
        //dashboard panel
        dashBoardP.add(HomeLPanel);
        dashBoardP.add(Box.createRigidArea(new Dimension(0, 0)));
        dashBoardP.add(AccountLPanel);
        dashBoardP.add(Box.createRigidArea(new Dimension(0,0)));
        dashBoardP.add(AdminsLPanel);
        dashBoardP.add(CartPanel);
        dashBoardP.add(Box.createRigidArea(new Dimension(200,this.getHeight()-280)));
        dashBoardP.add(customerService);
        setFont(AdminsL);
        setFont(CartL);
        setFont(HomeL);
        setFont(AccountL); 
        HomeL.setForeground(Color.WHITE);
        HomeLPanel.setBackground(Color.red);
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
        customerService.addMouseListener(new RectListener());
        CartL.addMouseListener(new RectListener());
    
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
                if(obj.equals(customerService))
                {
                    ClientChattingSystem client;
                    try {
                        client = new ClientChattingSystem("Client");
                        client.setVisible(true);
                        client.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    } catch (IOException ex) {
                        Logger.getLogger(customerFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
                if(obj.equals(CartL))
                {
                    cp.remove(current);
                    current = null;
                    getContentPane().repaint();
                    getContentPane().validate();
                    
                }
                if(obj.equals(AccountL))
                {                     
                    cp.remove(current);
                    current = null;
                    current = AccountP;
                    cp.add(current);
                    current.setBackground(Color.WHITE);
                    changeSelection(AccountL,AccountLPanel);
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
                    changeSelection(HomeL,HomeLPanel);
                    getContentPane().repaint();
                    getContentPane().validate();

                }
                if(obj.equals(AdminsL))
                {
                    cp.remove(current);
                    current = null;
                    //JPanel ad = new JPanel();
                    //setAdminPanel(ad);
                    current = orders;
                    cp.add(current);
                    current.setBackground(Color.WHITE);
                    changeSelection(AdminsL,AdminsLPanel);
                    
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
    private void changeSelection(JLabel x,JPanel y){
        for(int i = 0; i<myLabels.length; i++){
            myLabelPanels[i].setBackground(Color.WHITE);
            myLabels[i].setForeground(Color.BLACK);
        }
        y.setBackground(Color.RED);
        x.setForeground(Color.WHITE);
    }


    
}

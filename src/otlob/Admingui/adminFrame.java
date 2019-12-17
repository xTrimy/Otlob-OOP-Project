/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.Admingui;
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
import otlob.Admin;
import otlob.LogInGUI;
/**
 *
 * @author ahmed
 */
public class adminFrame extends JFrame  implements Accessible
{
    
    JLabel AccountL = new JLabel("Account");
    JPanel AccountLPanel = new JPanel();
    JLabel AdminsL = new JLabel("Admins");
    JPanel AdminsLPanel = new JPanel();
    JLabel HomeL = new JLabel("Home");
    
    JLabel AddAdminL = new JLabel("Add Admins");
    JPanel AddAdminLP = new JPanel();
    JLabel logout = new JLabel("Log Out");
    JPanel LogOutP = new JPanel();

    JPanel HomeLPanel = new JPanel();
    JLabel[] myLabels = {AccountL, AdminsL, HomeL,AddAdminL,logout};    
    JPanel[] myLabelPanels = {AccountLPanel, AdminsLPanel, HomeLPanel,AddAdminLP,LogOutP};
    
    JPanel current = new JPanel();
    JPanel AccountP;
    JPanel HomeP ;
    //JPanel AdminsP = new JPanel();
    JPanel AdminsP = new adminPanel();
    Container cp = getContentPane();
    JPanel dashBoardP ;
    dashBoard d = new dashBoard(0,100);
    JPanel addAdminP;
    Admin currentA;
    JFrame disposed = this;
    public adminFrame(Admin currentA) throws IOException
    {
        for(int i = 0; i<myLabels.length;i++){
            myLabelPanels[i].setMinimumSize(new Dimension(512,100));
            myLabelPanels[i].setAlignmentX(RIGHT_ALIGNMENT);
            myLabelPanels[i].setMaximumSize(new Dimension(1000,100));
            myLabelPanels[i].add(myLabels[i]);
            myLabelPanels[i].setBackground(Color.WHITE);
            myLabels[i].setForeground(Color.BLACK);
        }

        HomeP = new adminHome(currentA);
        addAdminP = new AddAdminsPanel(currentA);
        this.currentA = currentA;
        AccountP = new accountPanel(currentA);
        setSize(790,650);
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
        dashBoardP.add(Box.createRigidArea(new Dimension(0,0)));
        dashBoardP.add(AddAdminLP);
        dashBoardP.add(Box.createRigidArea(new Dimension(0,0)));
        dashBoardP.add(LogOutP);
        dashBoardP.add(Box.createRigidArea(new Dimension(200,this.getHeight()-320)));
        setFont(AdminsL);
        setFont(HomeL);
        setFont(AccountL); 
        setFont(AddAdminL);
        setFont(logout);
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
        AddAdminL.addMouseListener(new RectListener());
        logout.addMouseListener(new RectListener());
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
                    current = AdminsP;
                    cp.add(current);
                    current.setBackground(Color.WHITE);
                    changeSelection(AdminsL,AdminsLPanel);
                    getContentPane().repaint();
                    getContentPane().validate();

                }
                if(obj.equals(AddAdminL))
                {
                    cp.remove(current);
                    current = null;
                    current = addAdminP;
                    cp.add(current);
                    changeSelection(AddAdminL,AddAdminLP);
                    getContentPane().repaint();
                    getContentPane().validate();
                }
                if(obj.equals(logout))
                {
                    try {
                        disposed.dispose();
                        LogInGUI l = new LogInGUI(0);
                        l.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
    
  public static void imageIoWrite(File i,String picName) {
         BufferedImage bImage = null;
         try {
             //File initialImage = new File("C://Users/Rou/Desktop/image.jpg");
             bImage = ImageIO.read(i);
 
             ImageIO.write(bImage, "jpg", new File(picName));
            
 
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

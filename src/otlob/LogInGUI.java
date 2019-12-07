/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.*;


/**
 *
 * @author ahmed
 */
public class LogInGUI extends JFrame
{
    JLabel hyperLink = new JLabel("Dont have an account? SignUp");
    JLabel signinU = new JLabel("Username");
    JLabel signinP = new JLabel("password");
    JButton BSignIn = new JButton("Sign In");
    String userNameIn;
    String passIn;
    JTextField logInUName = new RoundJTextField(20);
    JTextField LogInPassword = new RoundJTextField(20);
    public LogInGUI()throws IOException
    {
//        UIManager.put("TextField.background", Color.WHITE);
//        UIManager.put("TextField.border", BorderFactory.createCompoundBorder(
//            new CustomBorder(), 
//            new EmptyBorder(new Insets(4,4,4,4))));
        
    
        
        this.setSize(500,500);
        setTitle("Food Atlas");
         
        //BSignIn.setBounds(20, 20, 10, 40);
        //BSignIn.setBackground(Color.red.darker());
        //BSignIn.setForeground(Color.WHITE);
        
        JPanel signinPanel = new JPanel(new FlowLayout()); 
        JPanel LogoPanel = new JPanel();
        
        LogoPanel.setBackground(Color.white);
        signinPanel.setBackground(Color.white);

        //adding the signup and the logo panels into a horizontal grid
        JPanel twoPanelContainer = new JPanel();
        twoPanelContainer = new JPanel(new GridLayout(2,1));
        twoPanelContainer.add(LogoPanel);
        twoPanelContainer.add(signinPanel);
        
        
        //put all of the panels in one container which is allthree
        //into a vertical grid
        JPanel allThree = new JPanel(new GridLayout(1,2));
        allThree.add(twoPanelContainer);
        allThree.add(new imagePanel());
       
        //read the image as an icon
        //add it to the top
        BufferedImage img = ImageIO.read(new File("logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(img));
        LogoPanel.setLayout(new BorderLayout());
        LogoPanel.add(picLabel,BorderLayout.CENTER);
        
       
         
      
        //add text fields to sign in
        signinPanel.add(signinU);
        signinPanel.add(logInUName);
        signinPanel.add(signinP);
        signinPanel.add(LogInPassword);
        signinPanel.add(BSignIn);
        BSignIn.addActionListener(new actions());
        //add the clickable text and
        //set its color to dark red
        signinPanel.add(hyperLink);
        hyperLink.setForeground(Color.RED.darker());
        //to turn the cursor into a hand
        hyperLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        //instead of making a class for only one function
        //this mouse listener opens the signup panel
        hyperLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // the user clicks on the label
            //    anotherPanel obj = new anotherPanel();
            //obj.setVisible(true);
            }
        });
        
        
        getContentPane().add(allThree);
        
    }
    
    //image panel drawing images using graphics
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
           
           
            g.drawImage(img, 0, 0, null);
         
  
        }
        
        
    }

//  action here is sign in
    public class actions implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
            Customer current = new Customer();
            userNameIn = logInUName.getText();          
            passIn = LogInPassword.getText();
            
            String id;
            try{
                id = current.LogIn("customer.txt",userNameIn,passIn);}
            catch(IOException E){id = "";}
            if(id.equals(""))
                JOptionPane.showMessageDialog(null, "incorrect username or password"
                        , "incorrect" , JOptionPane.INFORMATION_MESSAGE);        
            else
            {
                try{
                current = (Customer)current.getUser(id);}
                catch(IOException E){System.out.println("error getting customer");}
                System.out.println("succeeded");
            }
            
        }
        
    }
    

/*
    (simpler but the edges are white and mostly overwrites on all 
    texfields after calling) can call insets which changes the size of the 
    text field which could be useful
    can be a problem cause the edges have some white 
    
    */    
        @SuppressWarnings("serial")
    public class CustomBorder extends AbstractBorder
    {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y,
                int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            Paint COLOR_BORDE_SIMPLE = null;
            g2d.setPaint(COLOR_BORDE_SIMPLE);
            Shape shape = new RoundRectangle2D.Float(0, 0, c.getWidth()-1,
                    c.getHeight()-1,20, 20);
            g2d.draw(shape);
        }
    }
    
    /*
        this code here overRides the paint methods them sleves for the text fields
        its less simple but can be more customizable 
    */

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
    
    public class roundJButton extends JButton
    {
        private Shape shape;
        public roundJButton()
        {
            super();
        }
        public roundJButton(String text)
        {
            super(text);
        }
        @Override
        protected void paintComponent(Graphics g) {
             g.setColor(getBackground());
             g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
             super.paintComponent(g);
        }
        @Override
        protected void paintBorder(Graphics g) {
             g.setColor(getForeground());
             g.drawRoundRect(5, 5, getWidth()-5, getHeight()-5, 20, 20);
        }
        @Override
        public boolean contains(int x, int y) {
             if (shape == null || !shape.getBounds().equals(getBounds())) {
                 shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
             }
             return shape.contains(x, y);
        }
    }
    

    
}

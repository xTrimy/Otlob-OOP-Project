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
import java.util.logging.Level;
import java.util.logging.Logger;
import otlob.Admin;
import static otlob.Admingui.adminFrame.imageIoWrite;
import otlob.assistingClass;
import otlob.guiassets.ToastMessage;
import otlob.meal;
/**
 *
 * @author ahmed
 */
public class adminHome extends JPanel
{
      //for the home page
    JButton addMealB = new JButton("add meal");
    JTextField mealNameT = new JTextField(15);
    JTextField mealTypeT = new JTextField(15);
    private NumberFormat amountFormat;
    private JFormattedTextField amountField;
    JButton uploadPicture = createSimpleButton("upload Picture");
    private int count =0;
    private JButton increaseB = createSimpleButton("<");
    private JButton decreaseB = createSimpleButton(">");
    private JLabel controlable = new JLabel("0");
    private File choosenPic ;
    BufferedImage img = null;
    Admin current;
    adminHome(Admin current)
    {
        this.current = current;
        this.setLayout(null);
        //inisializing labels
        JLabel pL = new JLabel("price");
        JLabel mealNL = new JLabel("meal Name");
        JLabel mealTL = new JLabel("meal type");
        JLabel quantityL = new JLabel("quantity");
        controlable.setBounds(330,100,50,50);
        quantityL.setBounds(300,70,50,50);
        increaseB.setBounds(280,110,40,30);
        decreaseB.setBounds(350,110,40,30);
        this.add(controlable);
        this.add(quantityL);
        this.add(increaseB);
        this.add(decreaseB);
        increaseB.addActionListener(new actions());
        decreaseB.addActionListener(new actions());
        uploadPicture.setBounds(0,350,150,30);
        
        //setting meal name positions 
        mealNL.setBounds(0,100,70,30);
        mealNameT.setBounds(65,100,150,30);
        
        //setting meal type positions 
        mealTL.setBounds(0,200,70,30);
        mealTypeT.setBounds(65,200,150,30);
        
        //setting price positions
        NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    formatter.setValueClass(Integer.class);
    formatter.setMinimum(0);
    formatter.setMaximum(Integer.MAX_VALUE);
    formatter.setAllowsInvalid(false);
    // If you want the value to be committed on each keystroke instead of focus lost
    formatter.setCommitsOnValidEdit(true);
        amountFormat = NumberFormat.getNumberInstance();
        amountField = new JFormattedTextField(formatter);
        amountField.setBounds(65, 280, 150, 30);
        pL.setBounds(30,280,70,30);
        
        //adding all
        this.add(pL);
        this.add(amountField);
        this.add(mealNL);
        this.add(mealNameT);
        this.add(mealTL);
        this.add(mealTypeT);
        this.add(uploadPicture);
        addMealB = createSimpleButton("Add meal");
        addMealB.setBounds(250,350,100,30);
        this.add(addMealB);
        
         uploadPicture.addActionListener(new actions());
        addMealB.addActionListener(new actions());
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
     public class actions  implements ActionListener  
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object s = e.getSource();
            
            if(s.equals(uploadPicture))
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
                     imageIoWrite(choosenPic, ".//mealPics//"+(o.getId("meal.txt")+1) + ".jpg");
                     ToastMessage t = new ToastMessage("picture selected");
                     t.display();
                     }
                     catch(IOException ee){System.out.println("something with iamges");}    
                  //System.out.println("getSelectedFile() : " + );

                }
                
                
                
            }
            
            else if(s.equals(addMealB))
            {
                String mealName  = mealNameT.getText();
                String mealType = mealTypeT.getText();
                String price = amountField.getText();
                if(mealName.equals("") || mealType.equals("")||price.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "one of the fields was left empty ", 
                            "InfoBox: " + "invalid", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                        try {
                            

                       meal m = new meal(mealName,mealType,Float.parseFloat(price),count);
                                    ToastMessage message = new ToastMessage("Meal Added");
                        message.display();
                        m.writeToMeals(Integer.toString(current.getUserId()));

                    } catch (IOException ex) {
                        Logger.getLogger(adminHome.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
            }
            if(s.equals(increaseB))
            {
                count--;
                if(count < 0)
                {
                    
                    count = 0;
                }
                
                controlable.setText("" + count);
            }
            else if(s.equals(decreaseB))
            {
                
                count++;
                controlable.setText(""+count);
            }
            
        }
        
    }
   
   
}

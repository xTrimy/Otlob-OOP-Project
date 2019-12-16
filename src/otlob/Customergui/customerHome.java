/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.Customergui;
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
import static otlob.Admingui.adminFrame.imageIoWrite;
/**
 *
 * @author ahmed
 */
public class customerHome extends JPanel
{
      JButton addMealB = new JButton("add meal");
    JTextField mealNameT = new JTextField(15);
    JTextField mealTypeT = new JTextField(15);
    private NumberFormat amountFormat;
    private JFormattedTextField amountField;
    JButton uploadPicture = createSimpleButton("upload Picture");

    private File choosenPic ;
    BufferedImage img = null;
    customerHome()
    {
        this.setLayout(null);
        //inisializing labels
        
        
        
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

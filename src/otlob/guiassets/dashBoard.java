/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.guiassets;
import java.awt.BorderLayout;
import java.io.*;
import javax.imageio.*;
import java.awt.Event;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 *
 * @author ahmed
 */
public class dashBoard extends JPanel{
     int x;
    int y;
    public dashBoard(int x,int y)
        {
            this.x = x;
            this.y = y;
            setSize(512, 512);
            
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            this.add(Box.createVerticalGlue());

            
        }
    @Override
        public void paintComponent(Graphics g)
        {
          //  this.setLayout(null);
            int h = this.getHeight();
            int w = this.getWidth();
            BufferedImage img = null;
            try{
             img = ImageIO.read(new File("Asset 2.png"));}
            catch(IOException e){System.out.println("ima..geprob");}             
            g.drawImage(img, 0, 0, null);
            
            g.setColor(Color.BLACK);
            Graphics2D g2 = (Graphics2D) g;
            
        // Define rendering hint, font name, font style and font size
           
            g2.setFont(new Font("serif", Font.BOLD, 35));
            g2.setPaint(Color.BLACK);

    
           
        }
}

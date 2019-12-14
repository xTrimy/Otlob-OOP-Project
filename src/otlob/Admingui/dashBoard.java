/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.Admingui;
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
    dashBoard(int x,int y)
        {
            this.x = x;
            this.y = y;
            setSize(512, 512);
            
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createEmptyBorder(0, 10,10,10));
            this.add(Box.createVerticalGlue());

            
        }
    @Override
        public void paintComponent(Graphics g)
        {
          //  this.setLayout(null);
            int h = this.getHeight();
            int w = this.getWidth();
            
            g.drawLine(w -100 ,0, w -100, this.getHeight());
            g.drawLine(0,100 , w-100, 100);
            g.drawLine(0,150,w - 100 ,150);
            g.drawLine(0,200,w-100,200);
            g.drawLine(0,250,w- 100,250);
            
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

            
        g.setColor(Color.RED);
        g.fillRect(x, y, 289, 50);
    
           
        }
}

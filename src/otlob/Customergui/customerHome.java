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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static otlob.Admingui.adminFrame.imageIoWrite;
import otlob.assistingClass;
/**
 *
 * @author ahmed
 */
public class customerHome extends JPanel
{
    private BufferedImage[] images = new BufferedImage[6];
    private JLabel[] restaurantNames = new JLabel[6];
    private HashMap<String,String[]> restaurants;
    private String[] restaurantsIds;
    private int restaurantsSize;
    private assistingClass ac = new assistingClass();
    private int startPosy;
    private int selectedRect = 0;
    private int startPosx = 0;
    private int sizeX = 120;
    private int sizeY = 100;
    private int marginsY = 70;
    private int maxPerPage = 6;
    private int currentPage = 1;
    private JButton next;    
    private JButton prev;    
    private JLabel currentPageLabel;

    customerHome() throws IOException
    {
        restaurants = ac.readFiletoHashMap("restaurant.txt");
        restaurantsSize = restaurants.size();
        restaurantsIds = new String[restaurantsSize];
        Set<Map.Entry<String, String[]>> set = restaurants.entrySet();
        int it = 0;
        for(Map.Entry<String,String[]> s: set){
            restaurantsIds[it] = s.getKey();
            System.out.println(restaurantsIds[it]);
            it++;
        }
        this.setLayout(null);
        this.addMouseMotionListener(new RectListener());
        try{
            for(int i = 0;i<6;i++){
                images[i] = ImageIO.read(new File("Untitled.jpg"));
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        for(int i = 0; i<6; i++){
            restaurantNames[i] = new JLabel("", SwingConstants.CENTER);
            this.add(restaurantNames[i]);
        }
        next = new JButton(">");        
        prev = new JButton("<");
        currentPageLabel = new JLabel("1", SwingConstants.CENTER);
        next.setBounds(290,420,50,20);    
        prev.setBounds(200,420,50,20);        
        currentPageLabel.setBounds(250,420,40,20);

        next.addMouseListener(new RectListener2());        
        prev.addMouseListener(new RectListener2());
        
        this.add(next);        
        this.add(prev);        
        this.add(currentPageLabel);


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
    @Override
    public void paintComponent(Graphics g) {
        createLabels();
        super.paintComponent(g);
        startPosy = getHeight()/2 - sizeY - marginsY/2;
        for(int i = 0; i<2;i++){
            for(int j=0;j<3;j++){
                g.drawImage(images[(j+1)+(3*i)-1],startPosx+j*sizeX,startPosy+(sizeY+marginsY)*i,sizeX,sizeY,this);
            }
        }
        g.setColor(new Color((float)1,(float)0,(float)0,(float)0.2));
        if(selectedRect != 0){
            int y = (selectedRect>3)? 1: 0;
            System.out.println(y+","+selectedRect);
            g.fillRect(startPosx+((selectedRect-1)%3)*sizeX,startPosy+(sizeY+marginsY)*y,sizeX,sizeY);
        }
    }
      
    public class RectListener2 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {

        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            if(arg0.getSource() == next){
                if((float)currentPage < restaurantsIds.length/(float)maxPerPage){
                    currentPage++;
                    createLabels();
                    currentPageLabel.setText(Integer.toString(currentPage));
                    repaint();
                    validate();
                }else{
                    JOptionPane.showMessageDialog(null, "This is the last page", "Error",JOptionPane.ERROR_MESSAGE);
                }

            }else if(arg0.getSource() == prev){
                if(currentPage > 1){
                    currentPage--;
                    createLabels();
                    currentPageLabel.setText(Integer.toString(currentPage));
                    repaint();
                    validate();
                }else{
                    JOptionPane.showMessageDialog(null, "This is the first page", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
        }

        @Override
        public void mouseExited(MouseEvent arg0) {
        }
        
    }

    public class RectListener implements MouseMotionListener 
    {
        @Override
        public void mouseDragged(MouseEvent arg0) {
            
        }

        @Override
        public void mouseMoved(MouseEvent arg0) {
            int posX = arg0.getX();
            int posY = arg0.getY();

            selectedRect = 0;
            for(int i = 0;i<2;i++){
                for(int j = 0;j<3; j++){
                    if(posX>startPosx+j*sizeX && posX<startPosx+j*sizeX+sizeX && posY > startPosy+(sizeY+marginsY)*i && posY < startPosy+(sizeY+marginsY)*i+sizeY){
                        selectedRect = (j+1)+(3*i);
                    }
                }
            }
            repaint();
            validate();
        }
    }
    private void createLabels(){
        for(int i = 0; i<6; i++){
            this.remove(restaurantNames[i]);
            String label = "";
            if(i+(currentPage-1)*6 < restaurantsSize){
                label = restaurants.get(restaurantsIds[i+(currentPage-1)*6])[1];
                restaurantNames[i] = new JLabel(label, SwingConstants.CENTER);
                restaurantNames[i].setBounds(startPosx+((i)%3)*sizeX,sizeY+startPosy+(sizeY+marginsY)*(int)(i/3),sizeX,marginsY/2);
                this.add(restaurantNames[i]);
            }
        }
    }
}

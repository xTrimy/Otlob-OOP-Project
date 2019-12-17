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
import java.util.ArrayList;
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
    private JLabel[] displayLabels = new JLabel[6];    
    private JLabel[] displayPrices= new JLabel[6];
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
    private JButton back;    
    private JLabel currentPageLabel;
    private int selectedRestaurant = 0;
    private HashMap<String,String[]> meals;
    private int mealsSize;
    private String[] mealsIds;
    private ArrayList<String> selectedMeals = new ArrayList<String>();
    customerHome() throws IOException
    {
        restaurants = ac.readFiletoHashMap("restaurant.txt");
        restaurantsSize = restaurants.size();
        restaurantsIds = new String[restaurantsSize];
        Set<Map.Entry<String, String[]>> rSet = restaurants.entrySet();        
        int it = 0;
        for(Map.Entry<String,String[]> s: rSet){
            restaurantsIds[it] = s.getKey();
            it++;
        }
        
        meals = ac.readFiletoHashMap("meal.txt");
        System.out.println("MAP: "+meals);

        mealsSize = meals.size();
        mealsIds = new String[mealsSize];
        Set<Map.Entry<String, String[]>> mSet = meals.entrySet();
        it = 0;
        for(Map.Entry<String,String[]> s: mSet){
            mealsIds[it] = s.getKey();
            it++;
        }
        this.setLayout(null);
        this.addMouseMotionListener(new RectListener());        
        this.addMouseListener(new RectListener2());


        for(int i = 0; i<6; i++){
            displayLabels[i] = new JLabel();            
            displayPrices[i] = new JLabel();
            this.add(displayLabels[i]);            
            this.add(displayPrices[i]);
        }
        next = new JButton(">");        
        prev = new JButton("<");
        back = new JButton("Back");
        currentPageLabel = new JLabel("1", SwingConstants.CENTER);
        next.setBounds(290,420,50,20);    
        prev.setBounds(200,420,50,20);           
        back.setBounds(0,420,130,20);        
        currentPageLabel.setBounds(250,420,40,20);
        back.setVisible(false);

        next.addMouseListener(new RectListener2());        
        prev.addMouseListener(new RectListener2());        
        back.addMouseListener(new RectListener2());

        this.add(next);        
        this.add(prev);        
        this.add(back); 
        
        this.add(currentPageLabel);
        try{
            for(int i = 0;i<6;i++){
                images[i] = ImageIO.read(new File(new String("./logos/"+restaurantsIds[i]+".jpg")));
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }
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
            g.fillRect(startPosx+((selectedRect-1)%3)*sizeX,startPosy+(sizeY+marginsY)*y,sizeX,sizeY);
        }
    }
      
    public class RectListener2 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {

        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            int posX = arg0.getX();
            int posY = arg0.getY();
            int itemsSize = (selectedRestaurant == 0)?restaurantsIds.length:selectedMeals.size();
            if(arg0.getSource() == next){
                if((float)currentPage < itemsSize/(float)maxPerPage){
                    currentPage++;
                    createLabels();
                    currentPageLabel.setText(Integer.toString(currentPage));
                    try{
                        for(int i = 0;i<6;i++){
                            if(i+(currentPage-1)*6 < selectedMeals.size() || selectedRestaurant == 0)
                                images[i] = ImageIO.read(new File(new String("./"+(( selectedRestaurant == 0 )?"logos":"mealPics")+"/"+(( selectedRestaurant == 0 )?restaurantsIds[i+(currentPage-1)*6]:selectedMeals.get(i+(currentPage-1)*6))+".jpg")));
                            else
                                images[i] = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
                        }
                    }
                    catch(IOException ex){
                        System.out.println(ex);
                    }
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
                    try{
                        for(int i = 0;i<6;i++){
                            if(i+(currentPage-1)*6 < selectedMeals.size() || selectedRestaurant == 0)
                                images[i] = ImageIO.read(new File(new String("./"+(( selectedRestaurant == 0 )?"logos":"mealPics")+"/"+(( selectedRestaurant == 0 )?restaurantsIds[i+(currentPage-1)*6]:selectedMeals.get(i+(currentPage-1)*6))+".jpg")));
                            else
                                images[i] = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
                        }
                    }
                    catch(IOException ex){
                        System.out.println(ex);
                    }
                    repaint();
                    validate();
                }else{
                    JOptionPane.showMessageDialog(null, "This is the first page", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }else if(arg0.getSource() == back){
                currentPage = 1;
                back.setVisible(false);
                selectedRestaurant = 0;
                selectedMeals.clear();
                try{
                      for(int i = 0;i<6;i++){
                        images[i] = ImageIO.read(new File(new String("./logos/"+restaurantsIds[i+(currentPage-1)*6]+".jpg")));
                      }
                  }
                  catch(IOException ex){
                      System.out.println(ex);
                  }
                repaint();
                validate();
            }else{
                for(int i = 0;i<2;i++){
                    for(int j = 0;j<3; j++){
                        if(posX>startPosx+j*sizeX && posX<startPosx+j*sizeX+sizeX && posY > startPosy+(sizeY+marginsY)*i && posY < startPosy+(sizeY+marginsY)*i+sizeY){
                            if(selectedRestaurant == 0){
                                back.setVisible(true);
                                selectedRestaurant = Integer.parseInt(restaurantsIds[(j+1)+(3*i)-1+(currentPage-1)*6]);
                                currentPage = 1;
                                currentPageLabel.setText("1");
                                selectedMeals.clear();
                                for(int k =0; k<mealsSize;k++){
                                    String id = meals.get(mealsIds[k])[0];
                                    if(id.equals(Integer.toString(selectedRestaurant))){
                                        selectedMeals.add(mealsIds[k]);
                                    }
                                }
                                try{
                                    for(int k = 0;k<6;k++){
                                        if(i+(currentPage-1)*6 < selectedMeals.size())
                                           images[k] = ImageIO.read(new File(new String("./mealPics/"+selectedMeals.get(k+(currentPage-1)*6)+".jpg")));
                                        else
                                            images[k] = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
                                    }
                                }
                                catch(IOException ex){
                                    System.out.println(ex);
                                }
                                createLabels();
                                repaint();
                                validate();  
                                }
                        }
                    }
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
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            selectedRect = 0;
            for(int i = 0;i<2;i++){
                for(int j = 0;j<3; j++){
                    if(posX>startPosx+j*sizeX && posX<startPosx+j*sizeX+sizeX && posY > startPosy+(sizeY+marginsY)*i && posY < startPosy+(sizeY+marginsY)*i+sizeY){
                        selectedRect = (j+1)+(3*i);
                        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }
                }
            }
            repaint();
            validate();
        }
    }
    private void createLabels(){
        for(int i = 0; i<6; i++){
            this.remove(displayLabels[i]);            
            this.remove(displayPrices[i]);
            String label = "";            
            String price = "";

            if(selectedRestaurant == 0){
                if(i+(currentPage-1)*6 < restaurantsSize){
                    label = restaurants.get(restaurantsIds[i+(currentPage-1)*6])[1];
                    displayLabels[i] = new JLabel(label, SwingConstants.CENTER);
                    displayLabels[i].setBounds(startPosx+((i)%3)*sizeX,sizeY+startPosy+(sizeY+marginsY)*(int)(i/3),sizeX,marginsY/2);
                    this.add(displayLabels[i]);
                }
            }
            else{
                if(i+(currentPage-1)*6 < selectedMeals.size() && !selectedMeals.isEmpty()){
                    label = meals.get(selectedMeals.get(i+(currentPage-1)*6))[1];                    
                    price = meals.get(selectedMeals.get(i+(currentPage-1)*6))[3];
                    displayLabels[i] = new JLabel(label, SwingConstants.CENTER);                    
                    displayPrices[i] = new JLabel(price + "EGP", SwingConstants.CENTER);
                    displayLabels[i].setBounds(startPosx+((i)%3)*sizeX,sizeY+startPosy+(sizeY+marginsY)*(int)(i/3),sizeX,marginsY/2);
                    displayPrices[i].setBounds(startPosx+((i)%3)*sizeX,20+sizeY+startPosy+(sizeY+marginsY)*(int)(i/3),sizeX,marginsY/2);
                    this.add(displayLabels[i]);                    
                    this.add(displayPrices[i]);
                }
            }
        }
    }
}

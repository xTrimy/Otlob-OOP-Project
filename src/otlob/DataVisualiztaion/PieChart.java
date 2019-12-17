/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.DataVisualiztaion;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import otlob.guiassets.ToastMessage;
/**
 *
 * @author PC
 */
public class PieChart{
    private int size;
    private int posx;
    private int posy;
    private int[] data;
    private String[] dataValues;
    private ArrayList<Color> colors = new ArrayList<Color>();
    private JFrame f;
    private boolean centerPos;
    private int dataTotal;
    public PieChart(int size,int posx, int posy, int[] data, String[] dataValues,JFrame f){
        this.size = size;
        this.posx = posx;
        this.posy = posy;
        this.data = data;
        this.dataValues = dataValues;
        this.centerPos = false;
        this.dataTotal = 0;
        for(int i = 0; i<data.length;i++){
            dataTotal += data[i];
            colors.add(generateColor());
        }
        this.f = f;
        if(data.length == 0){
            //JOptionPane.showMessageDialog(null, "This is the first page", "Error",JOptionPane.INFORMATION_MESSAGE);
            ToastMessage t = new ToastMessage("no data to show");
            t.display();
        }
    }
    public PieChart(int size,int posx, int posy, int[] data, String[] dataValues,boolean centerPos,JFrame f){
        this(size,posx,posy,data,dataValues,f);
        this.centerPos = centerPos;
    }
    private Color generateColor(){
      Random rand = new Random();
      float r = rand.nextFloat();  
      float g = rand.nextFloat();
      float b = rand.nextFloat();
      return new Color(r,g,b);
    }
    public class draw extends JPanel{
        public void paintComponent(Graphics g)
        {
            int YIndent = 0;
            super.paintComponent(g);
            int startingAngle =0;
            int currentAngle = 0;
            for(int i = 0; i<data.length;i++){
                Color c= colors.get(i);
                g.setColor(c);
                int aSize = (int)((float)data[i]/(float)dataTotal * 365);
                if(centerPos){
                    posx = f.getWidth()/2 - size/2;
                }
                g.fillArc(posx,posy,size,size,currentAngle,aSize);
                currentAngle += aSize;
                g.fillRect(posx+size+10,posy+i*(size/data.length),20,20);
                g.setColor(new Color(0,0,0));
                if(i < dataValues.length)
                    g.drawString(dataValues[i],posx+size+40,posy+i*(size/data.length)+15);
            }
        }
    }
    public JPanel draw(){
        return new draw();
    }
}

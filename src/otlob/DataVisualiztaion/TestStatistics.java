/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.DataVisualiztaion;

import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author PC
 */
public class TestStatistics {
        public static void main(String[] args) throws IOException {
            JPanel x = new JPanel();
            JFrame f = new JFrame();
            int[] data = {10,50,6,4,100,245,520,102,201};
            String[] dataValues = {"x","yy","zz","6","22","55","44"};
            PieChart p = new PieChart(200,100,100,data,dataValues,true,f);
            x.add(p.draw());
            x.setVisible(true);
            f.setSize(1000,1000);
            f.getContentPane().add(p.draw());
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}

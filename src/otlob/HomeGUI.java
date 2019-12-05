/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import javax.swing.*;

/**
 *
 * @author PC
 */
public class HomeGUI {
    JPanel f = new JPanel();
    public HomeGUI(){
        f.setSize(400,400);
        JButton butt =new JButton("click");
        butt.setBounds(130,100,100, 40);
        f.add(butt);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}

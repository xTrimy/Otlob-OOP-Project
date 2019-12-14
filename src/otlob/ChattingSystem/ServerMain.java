/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package otlob.ChattingSystem;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author xTrimy
 */
public class ServerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Server s=new Server();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread t=new Thread(s);
        t.start();
        
        //s.start();
                
    }
    
}

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
public class CostumerSupportMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
                
        SupportClient sc=new SupportClient("Admin1");
        sc.setVisible(true);
        sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SupportClient sc1 =new SupportClient("Admin2");
        sc1.setVisible(true);
        sc1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
         Thread.sleep(1000);
        }catch(Exception e){
        }
        
        //Client cl=new Client("Ahmed");
       // cl.setVisible(true);
        //cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Client cl2=new Client("Haidy");
        cl2.setVisible(true);
        cl2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }
    
}

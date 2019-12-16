/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob.ChattingSystem;
import java.awt.Color;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.*;
/**
 *
 * @author Zeina Ayman
 */
public class ClientChattingSystem extends JFrame{
    private JTextArea text = new JTextArea();
    private JButton send = new JButton("Send");
    static private int cid = 0;
    private int clientId;
    private JLabel recivedMsg;
    InputStream is;
    OutputStream os;
    Socket toFromserver = null;
    String clientName;
    
    public ClientChattingSystem(String name) throws IOException
    {
          this.setSize(500,500);
          send.setForeground(Color.WHITE);
          send.setBackground(Color.RED);
          text.setColumns(10);
          text.setRows(5);
          recivedMsg=new JLabel("<html><div style='color:red'>Recived Message</div><br>");
          JPanel panel1 = new JPanel();
          panel1.setLayout(null);
          Container cp = getContentPane();
          cp.setLayout(new GridLayout(2,1));
          cp.add(recivedMsg);
          text.setBounds(0, 130, 300, 100);
          panel1.add(text);
          
          send.setBounds(350, 170, 70, 30);
          panel1.add(send);
          
          cp.add(panel1);
          send.addActionListener(new act());
          
          
          try {
                    toFromserver = new Socket("127.0.0.1", 6000);
                    is=toFromserver.getInputStream();
                    os=toFromserver.getOutputStream();
                    updategui2 t=new updategui2();
                    t.start();


                } catch (IOException ex) {
                    
                }
        PrintWriter px=new PrintWriter(os,true);
        px.println("x,1,"+ ++cid+","+name);
        clientId = cid;
    }
    private class act implements  ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            PrintWriter pw=new PrintWriter(os,true);
            pw.println("x1,"+clientId+","+text.getText());
            recivedMsg.setText(recivedMsg.getText()+"<br><span style='color:blue;'>You: </span>"+text.getText());
        }
    }
    private class updategui2 extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
                BufferedReader bf=new BufferedReader(new InputStreamReader(is));
                String Message = null;
                try {
                    Message = bf.readLine();
                    if (Message!=null)
                    {
                    recivedMsg.setText(recivedMsg.getText()+"<br>"+Message);
                    System.out.println("Server says " +Message);
                    
                    }
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    
                }         
            }
        }
        
    }
    
}

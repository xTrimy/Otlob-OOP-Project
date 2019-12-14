/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package otlob.ChattingSystem;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.*;
import javax.swing.*;
/**
 *
 * @author xTrimy
 */
public class SupportClient extends JFrame{
    static private int cid = 0;
    private int clientId;
    private JLabel recivedMsg;
    private JTextField tx_Msg=new JTextField("Write message to server here");
    InputStream is;
    OutputStream os;
    Socket toFromserver = null;
    String clientName;
    public SupportClient (String Name) throws IOException
    {
        this.clientName=Name;
        setSize(300,600);
        setTitle("Support Client V 1.0" + Name);
        recivedMsg=new JLabel("<html><div style='color:red'>Recived Message</div><br>");
        setLayout(null);
        recivedMsg.setBounds(20,20, 200,250);
        add(recivedMsg);
        JButton btnReciveMsg=new JButton("Send");
        btnReciveMsg.setBounds(20,350,100,50);
        tx_Msg.setBounds(btnReciveMsg.getBounds().x,btnReciveMsg.getBounds().y+50,100,50);
        add(tx_Msg);
        btnReciveMsg.addActionListener(new act());
        add(btnReciveMsg);
        
                try {
                    toFromserver = new Socket("127.0.0.1", 6000);
                    is=toFromserver.getInputStream();
                    os=toFromserver.getOutputStream();
                    updategui t=new updategui();
                    t.start();


                } catch (IOException ex) {
                    
                }
        PrintWriter px=new PrintWriter(os,true);
        px.println("y,1,"+ ++cid+","+Name);
        clientId = cid;
    }
     private class act implements  ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            PrintWriter pw=new PrintWriter(os,true);
            pw.println("y1,"+clientId+","+tx_Msg.getText());
            recivedMsg.setText(recivedMsg.getText()+"<br><span style='color:blue;'>You: </span>"+tx_Msg.getText());
        }
    }
    private class updategui extends Thread
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
    


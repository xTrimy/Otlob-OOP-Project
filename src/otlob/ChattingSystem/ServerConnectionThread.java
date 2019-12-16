/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package otlob.ChattingSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author xTrimy
 */
public class ServerConnectionThread implements Runnable{
    
    private Socket s;
    private InputStream is;
    private OutputStream os;
    private BufferedReader fromclient;
    private PrintWriter toclient;
    private JLabel Message;
    private static HashMap<String, Socket> clientsSockets = new HashMap<>();    
    private static HashMap<String, Socket> adminsSockets = new HashMap<>();
    private static HashMap<String, String> clients = new HashMap<>();    
    private static HashMap<String, String> admins = new HashMap<>();    
    private static HashMap<String, String> connectionsC = new HashMap<>();
    private static HashMap<String, String> connectionsA = new HashMap<>();
    public ServerConnectionThread(Socket s,JLabel Msg) throws IOException
    {
        this.s=s;
        this.Message=Msg;
        is=s.getInputStream();
        os=s.getOutputStream();
    }
    
   
//    public String getcontentOfLabel()
//    {
//        return this.Message.getText();
//    }
    public void run() {
           fromclient=new BufferedReader(new InputStreamReader(is));
           toclient=new PrintWriter(os,true);
        while (true)
        {
               try {
                   String NewMessage=fromclient.readLine();
                   String [] LIST = NewMessage.split(",");
                   //System.out.println(ch9nw.Server.allMessage.getText());
                   //Message.setText(ch9nw.Server.allMessage.getText() +"<br>"+NewMessage);
                   String tokenA = new String("y");                   
                   String tokenA1 = new String("y1");                   
                   String tokenC = new String("x");
                   String tokenC1 = new String("x1");
                   if(LIST[0].equals(tokenC)){
                    clients.put(LIST[2],LIST[3]);
                    clientsSockets.put(LIST[2],s);
                    Message.setText(Message.getText() +"<div style='color:blue;'>"+clients.get(LIST[2]) +" Joined the chat</div>");
                    boolean check = false;
                    Set<Map.Entry<String, String>> set = admins.entrySet();
                    for(Map.Entry<String, String> entry : set) {
                        String key = entry.getKey();
                        if(!connectionsA.containsKey(key)){
                            connectionsC.put(LIST[2],key);
                            connectionsA.put(key,LIST[2]);
                            System.out.println(connectionsC);                            
                            System.out.println(connectionsA);
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        toclient.println("All support admins are currently unavailable, please come back later");
                    }else{
                        toclient.println("<br>Connected to support admin ("+admins.get(connectionsC.get(LIST[2]))+")");
                    }
                   }else if(LIST[0].equals(tokenA)){
                    toclient.println(clients.size() + " clients online<br>and "+ admins.size() + " admins online");
                    admins.put(LIST[2],LIST[3]);
                    System.out.println(admins);
                    adminsSockets.put(LIST[2],s);
                    Message.setText(Message.getText() +"<div style='color:blue;'>"+admins.get(LIST[2]) +" Joined the chat</div>");
                   }else{
                    if(LIST[0].equals(tokenC1)){
                      Socket supp = adminsSockets.get(connectionsC.get(LIST[1]));
                      System.out.println("admins Sockets: " + adminsSockets);
                      OutputStream suppOs = supp.getOutputStream();
                      PrintWriter pw = new PrintWriter(suppOs,true);
                      pw.println("<br>"+"<span style='color:red;'>"+clients.get(LIST[1])+": </span>"+LIST[2]);
                      Message.setText(Message.getText() +"<br>"+"Client: <span style='color:red;'>"+clients.get(LIST[1])+":</span>"+LIST[2]);
                    }else{
                      Socket c = clientsSockets.get(connectionsA.get(LIST[1]));
                      OutputStream suppOs = c.getOutputStream();
                      PrintWriter pw = new PrintWriter(suppOs,true);
                      pw.println("<br>"+"<span style='color:red;'>"+admins.get(LIST[1])+": </span>"+LIST[2]);
                      Message.setText(Message.getText() +"<br>"+"Admin: <span style='color:red;'>"+admins.get(LIST[1])+":</span> "+LIST[2]);
                    }
                   }
                   //System.out.println(Message);
                   Thread.sleep(100);
               } catch (InterruptedException ex) {
                    System.out.println(ex);
               } catch(IOException ex){
                    System.out.println(ex);
               }
            
        }   
        
    }
    
}

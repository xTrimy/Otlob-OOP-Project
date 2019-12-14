/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package otlob;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author xTrimy
 */
public class Server extends JFrame implements Runnable{
    private ServerSocket Mysocket;
    private Socket clientsocket;
    private JTextField OneMessage;
    public  JLabel allMessage;
    private ArrayList<Socket> Allconnections=new ArrayList<Socket>();
    private ArrayList<Socket> AllSupportConnections=new ArrayList<Socket>();
    
    public Server() throws IOException
    {
        setSize(new Dimension (600,600));
        setTitle("ServerLog");
        Mysocket=new ServerSocket(6000);
        setLayout(null);
        allMessage=new JLabel("<html>*Messages Log*");
        allMessage.setBounds(20, 20, 500, 500);
        add(allMessage);
    }
    public void run() 
    {
        try
        {
        while (true)
        {
        clientsocket=Mysocket.accept();
        Allconnections.add(clientsocket);
        ServerConnectionThread ct=new ServerConnectionThread(clientsocket,allMessage);
        Thread t1=new Thread(ct);
        t1.start();
        Thread.sleep(1000);
            System.out.println("Waiting for another client");
        }
        }
        catch (InterruptedException e)
        {}
        catch (IOException e)
        {}
    }
}

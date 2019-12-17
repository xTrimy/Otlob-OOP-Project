/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.time.*;
import java.awt.*;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.GraphicsConfiguration;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
/**
 *
 * @author PC
 */

//InoviceType
public class Invoice  extends JFrame
{
    String thebill;
	public static boolean printcard(final String bill) {
		System.out.println("printed");
		final PrinterJob job=PrinterJob.getPrinterJob();
		Printable ContentToPrent= new Printable() {
			@Override
			public int print(Graphics graphics,PageFormat PageFormat,int pageIndex)throws PrinterException{
				Graphics2D g2d=(Graphics2D) graphics;
				g2d.translate(PageFormat.getImageableX(),PageFormat.getImageableY());
				g2d.setFont(new Font("Monospaced",Font.BOLD,10));
				String[] receipt=bill.split(":"); // break the string
			
				int y=15;
			    for(int i=0;i<receipt.length;i++) {
			    	graphics.drawString(receipt[i], 5, y);
			    	y=y+15;
			    }
			if(pageIndex>0) {return NO_SUCH_PAGE;} //only one page ya gd3aaaan 
				
			return PAGE_EXISTS;
			}
		
		};
	 PageFormat pageFormat = new PageFormat();
    pageFormat.setOrientation(PageFormat.PORTRAIT);
      Paper pPaper = pageFormat.getPaper();



   pPaper.setImageableArea(0, 0, pPaper.getWidth() , pPaper.getHeight() -2);
   pageFormat.setPaper(pPaper);

   Printable contentToPrint = null;
job.setPrintable(contentToPrint, pageFormat);





    try {
      job.print();

  } catch (PrinterException e) {
    System.err.println(e.getMessage());
  }
    return true;
    }
	Invoice(String name, String number, String address,String qty, String amount) {
		setSize(230,180);
		setLocationRelativeTo(null);
		JLabel data = new JLabel("");
		JButton print = new JButton("Print");
		print.addMouseListener(new RectListener());
		data.setBounds(30, 20, 180, 50);
		data.setAlignmentY(TOP_ALIGNMENT);
		print.setBounds(50, 100, 100, 30);
		GregorianCalendar gg=new GregorianCalendar();
		SimpleDateFormat dd=new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat ddd = new SimpleDateFormat("HH-MM");

		  String Header =
		                   "******FoodAtlas Management*******\n"
		                    + "Date:"+dd.format(gg.getTime())+"       Time:"+ddd.format(gg.getTime())+"\n;"
		                    + "         Order Receipt        \n;"
		                    + "---------------------------------\n;"
		                    + "Product Description              \n;"
		                    + "Name             Qty       Amount\n;"
		                  
		                    + "---------------------------------\n;";
		        
		             String a=name+"      "+qty+"      "+amount+"\n;";
		             String h=Header+a;
		        String amt  =
		                    "\n;---------------------------------\n;"
		                    + "Total Amount:      Rs.\n;"
		                    + "---------------------------------\n;"
		                    + "---------------------------------\n;"
		                    + "For Further Detail                \n;"
		                    + "Please Call/Whatsapp 0111111111111\n;"
		                    + "---------------------------------\n;"
		                    + "       Software Developed by      \n ;"
		                    + " ADHAM,ADEL,MOTAAZ,ZEINA,A&M ASHRAF;"
		                    + "*********************************\n;"
		                    + "            Thank You             \n;"
		                    + "_________________________________\n;";

		thebill=Header+amt;
		data.setText("<html>name: "+name+"<br>Phone number: "+number+"<br>Address: "+address+"</html>");
		setLayout(null);
		add(print);
		add(data);
	}
	
	public class RectListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			printcard(thebill);
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
    
    
}

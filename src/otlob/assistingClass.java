/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.*;


/**
 *
 * @author ahmed
 */
public class assistingClass {
    
    public int getId(String fileName) throws IOException
    {
        int size;
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String S;
        S = in.readLine();
        size = Integer.parseInt(S);
        
        return size;
    }
    
    public void resetSize(String fileName) throws IOException
    {
        File fileToBeModified = new File(fileName);
        String oldSize = "";
        
       BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
       
       String line = reader.readLine();

        while (line != null)
        {
            oldSize = oldSize + line + System.lineSeparator();
            line = reader.readLine();
        }
       // String newContent = oldSize.replaceAll(oldString, newString);
        
        FileWriter writer = new FileWriter(fileToBeModified);
      //  writer.write(newContent);
        reader.close();
        writer.close();

    }
    
    
     void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
           while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceFirst(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
}

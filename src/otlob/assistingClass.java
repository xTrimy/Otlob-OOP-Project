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
    
public boolean search(String arg,String fileName)throws IOException
{
    int count =0;
    BufferedReader obj = new BufferedReader(new FileReader(fileName));
    String s;
    while ((s = obj.readLine()) != null)
    {
        
      // StringTokenizer tokens = new StringTokenizer(s,",");
            String [] list = s.split(",");

            for(String x : list)
            {
                if(x.equals(arg))
                {
                    return true;
                }
            }
    }
    return false; //-1 
}
//not used yet 
String passwordEncyption(String s)
{
    String e = "";
    int length = s.length();
    for(int i=0;i<length;i++)
    {
        e += (char)(s.charAt(i) + i + 1);
    }
    
    return e;
}
String passwordDecryption(String s)
{
    String d = "";
    int length = s.length();
    for(int i=0;i<length;i++)
    {
        d += (char)(s.charAt(i) - i - 1);
    }
    
    return d;
}
void writeFile(String arg,String fileName)throws IOException
{
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
    writer.write(arg);
    writer.close();
    
    
}
String searchId(String Id,String fileName) throws IOException
{
   BufferedReader obj = new BufferedReader(new FileReader(fileName));
   String s;
   while((s = obj.readLine()) != null)
   {
       //try because the first iteration iterates over the first line which is the size
     try
     {
          // StringTokenizer tokens = new StringTokenizer(s,",");
          String [] list = s.split(",");
           if(list[0].equals(Id))
           {
               return Id;
           }

      }
      catch(ArrayIndexOutOfBoundsException exception) 
      {
           continue;
      }

   }
   return "not found";
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
            //read all of the file !
           while (line != null) 
            {
                //store it in oldcontenr and use a lineseparator
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             //user replace first to replace the first thing you see
             //when useing only replace you shall change the whole file 
            String newContent = oldContent.replaceFirst(oldString, newString);
             
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //finaly block is always excuted in the try and catch
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;


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
    
//    public void resetSize(String fileName) throws IOException
//    {
//        File fileToBeModified = new File(fileName);
//        String oldSize = "";
//        
//       BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
//       
//       String line = reader.readLine();
//
//        while (line != null)
//        {
//            oldSize = oldSize + line + System.lineSeparator();
//            line = reader.readLine();
//        }
//       // String newContent = oldSize.replaceAll(oldString, newString);
//        
//        FileWriter writer = new FileWriter(fileToBeModified);
//      //  writer.write(newContent);
//        reader.close();
//        writer.close();
//
//    }
    
public String search(String arg,String fileName)throws IOException
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
                    return x;
                }
            }
    }
    return "not found"; //-1 
}

public boolean isTaken(String arg,String fileName)throws IOException
{
    BufferedReader obj = new BufferedReader(new FileReader(fileName));
    String s;
    while ((s = obj.readLine()) != null)
    {
        
      // StringTokenizer tokens = new StringTokenizer(s,",");
            String [] list = s.split(",");

            for(String x : list)
            {
                if(!x.equals(arg))
                {
                    return false;
                }
            }
    }
    return true;
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
void writeFile(String arg/*Data*/,String fileName)throws IOException
{
    writeFile(arg,fileName,true);
}

public String validateMail(String mail)
{System.out.println(mail);
    if(mail.contains("@")){
        
        return "valid";
    }
    else
        return "invalid email";
                         
}
public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}

public String validateMobile(String mobile)
{
    if(!isNumeric(mobile) || mobile.length() != 11)
    {   
        return "invalid phone nulmber";
    }
    else 
        return "valid";
}

void writeFile(String arg/*Data*/,String fileName,boolean app)throws IOException
{
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,app));
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
    void deleteFromFile(String filePath, String removable)
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
            
             oldContent = oldContent.replaceFirst(removable,"");
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(oldContent);
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

     public void modifyFile(String filePath, String oldString, String newString)
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
     
     //ReadFile returns a 2d array 
    public String[][] ReadFile(String fileName) throws IOException
    {
        //create the file objects
        File restaurants = new File(fileName);
        String fileData = "";
        BufferedReader reader = null;
        int i=0;
        try
        {
            reader = new BufferedReader(new FileReader(restaurants));
            String line = reader.readLine();
            //read the whole file and store it into a string
            while (line != null) 
            {
                //line separator in windows is \n
                if(i ==0)
                {
                    i++ ;
                    continue;
                }
                fileData = fileData + line + System.lineSeparator();
                line = reader.readLine();

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        //make a 1d list
        String [] list = null;
        //make a 2d list
        String [][] result = null;
        try
        {
            //looked for \n
            //list has all lines in a single String
            list = fileData.split(System.lineSeparator());
            
            int size = list.length;
            //2d array to store the rows and columns
            result = new String [size][]; 
            int count = 0;
            //iterate and put everything in a 2d array
            for (String line : list)
            {
                result [count] = line.split (",");
                ++count;
            }
        }catch(Exception e){
            System.out.print(e);
            return null;
        }
        return result;
    }
    
     //ReadFile returns a 2d array 
    public String[][] ReadFile(String fileName,ArrayList<String> IDS) throws IOException
    {
        //create the file objects
        File restaurants = new File(fileName);
        String fileData = "";
        BufferedReader reader = null;
        int i=0;
        try
        {
            reader = new BufferedReader(new FileReader(restaurants));
            String line ;
            //read the whole file and store it into a string
            while ((line = reader.readLine()) != null) 
            {
                //line separator in windows is \n
                if(i ==0)
                {
                    i++ ;
                    

                    continue;
                }
                for(String x : IDS)
                {
                    if(x.equals(line.substring(0, line.indexOf(","))))
                    fileData = fileData + line + System.lineSeparator();
                    
                }
                

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        //make a 1d list
        String [] list = null;
        //make a 2d list
        String [][] result = null;
        try
        {
            //looked for \n
            //list has all lines in a single String
            list = fileData.split(System.lineSeparator());
            
            int size = list.length;
            //2d array to store the rows and columns
            result = new String [size][]; 
            int count = 0;
            //iterate and put everything in a 2d array
            for (String line : list)
            {
                result [count] = line.split (",");
                ++count;
            }
        }catch(Exception e){
            System.out.print(e);
            return null;
        }
        return result;
    }
    
    public  String[][] removeCol(String [][] array, int colRemove)
    {
        int row = array.length;
        int col = array[0].length;

        String [][] newArray = new String[row][col-1]; //new Array will have one column less


        for(int i = 0; i < row; i++)
        {
            for(int j = 0,currColumn=0; j < col; j++)
            {
                if(j != colRemove)
                {
                    newArray[i][currColumn++] = array[i][j];
                }
            }
        }

        return newArray;
    }
    public HashMap<String,String[]> readFiletoHashMap(String fileName)
    {
        HashMap<String,String[]> content = new HashMap();
        
        //create the file objects
        File restaurants = new File(fileName);
        String fileData = "";
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(restaurants));
            String line = reader.readLine();
            String[] list;
            int i=0;
            //read the whole file and store it into a string
            while (line != null) 
            {
                //line separator in windows is \n
                if(i == 0)
                {
                    i++;
                    continue;
                }
                fileData = fileData + line + System.lineSeparator();
                list= line.split(",");
                content.put(list[0],Arrays.copyOfRange(list,1,list.length));
                line = reader.readLine();

            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return content;
    }
    
    public HashMap<String,String[]> readFiletoHashMap(String fileName,boolean colSelection)
    {
        if(colSelection == true)
        {
            HashMap<String,String[]> content = new HashMap();

            //create the file objects
            File restaurants = new File(fileName);
            String fileData = "";
            BufferedReader reader = null;
            try
            {
                reader = new BufferedReader(new FileReader(restaurants));
                //String line = reader.readLine();
                String line;
                String[] list;
                int i=0;
                //read the whole file and store it into a string
                while ((line = reader.readLine()) != null) 
                {
                    //line separator in windows is \n
                    if(i == 0)
                    {
                        i++;
                        continue;
                    }
                    fileData = fileData + line + System.lineSeparator();
                    list= line.split(",");
                    String l = list[1];
                    String afterremoval[] = removeTheElement(list,1);
                    content.put(l,afterremoval);
                    line = reader.readLine();

                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

            return content;
        }
        else
        {
            return readFiletoHashMap(fileName);
        }
    }
    
     public static String[] removeTheElement(String[] arr, 
                                          int index) 
    { 
  
        // If the array is empty 
        // or the index is not in array range 
        // return the original array 
        if (arr == null
            || index < 0
            || index >= arr.length) { 
  
            return arr; 
        } 
  
        // Create another array of size one less 
        String[] anotherArray = new String[arr.length - 1]; 
  
        // Copy the elements except the index 
        // from original array to the other array 
        for (int i = 0, k = 0; i < arr.length; i++) { 
  
            // if the index is 
            // the removal element index 
            if (i == index) { 
                continue; 
            } 
  
            // if the index is not 
            // the removal element index 
            anotherArray[k++] = arr[i]; 
        } 
  
        // return the resultant array 
        return anotherArray; 
    } 
}

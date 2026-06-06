
package ClassPackag;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSystem {
   
    private static String FILE_PATH="D:\\Netbeans Work\\Company Details\\";
    
    File file;
    private String fileName;
    
    public FileSystem(String fileName){
        this.fileName=fileName;
        
        create_NewFile();
    }
    public boolean create_NewFile(){
        try
        {
          file=new File(FILE_PATH+fileName);
          if(file.createNewFile()){
              System.out.println("File Created "+file.getName());
              return true;
          }
          else
          {
            System.out.println("File Already Exist !");
            return false;
          }
        }
        catch (IOException ex)
        {
            System.err.println("Something went wrong when creating the file"+ex);
             return false;
        }
       }
    public boolean writeDataToFile(String record){
        try
        {
            file.createNewFile();
            FileWriter fileWriter=new FileWriter(file,true);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            bufferedWriter.write(record);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
            
            return true;
        }
        catch(IOException ex)
        {
            System.err.println("Something went wrong with writing"+ex);
            return false;
        }
    }
    
    public BufferedReader readFile(){
        if(!create_NewFile())
        {
            try
                    {
                        FileReader fileReader=new FileReader(file);
                        BufferedReader bufferedReader=new BufferedReader(fileReader);
                        
                        return bufferedReader;
                    }
           catch(IOException ex)
        {
            System.err.println("Something went wrong with writing"+ex);
         
        }
        }
        return null;
    }
  }


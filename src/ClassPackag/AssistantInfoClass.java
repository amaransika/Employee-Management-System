
package ClassPackag;

import java.io.BufferedReader;

public class AssistantInfoClass {
    
    private String EPFNumber;
    private String Password;
    
     FileSystem fileSystem=new FileSystem("AssistantInfo.txt");
     
     public AssistantInfoClass(String EPFNumber, String Password) {
        this.EPFNumber = EPFNumber;
        this.Password = Password;
    }
     public AssistantInfoClass(){}

    public String getEPFNumber() {
        return EPFNumber;
    }

    public void setEPFNumber(String EPFNumber) {
        this.EPFNumber = EPFNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
     
    public boolean addNewUser() {
        if(!fileSystem.create_NewFile()){
           String record = EPFNumber+" "+Password;
           return fileSystem.writeDataToFile(record);
        }
        return false;
    }
    public boolean validateLogin()
            {
             try{
                 String[] words=null;
                  BufferedReader bufferedReader = fileSystem.readFile();
                  String user;
                  while((user=bufferedReader.readLine())!=null)
                  {
                     words=user.split(" ");
                     if(words[0].equals(EPFNumber)&&words[1].equals(Password))
                     {
                         this.setEPFNumber(words[0]);
                         this.setPassword(words[1]);
                         return true;
                     }
                  }
             }   
             catch(Exception ex)
             {
                 System.err.println("Something went wrong"+ex);
                 return false;
             }
        return false;
            }
    
}

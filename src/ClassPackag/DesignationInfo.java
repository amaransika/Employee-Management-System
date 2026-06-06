
package ClassPackag;

import java.io.BufferedReader;

public class DesignationInfo {
  
         private String Designation;
   
    FileSystem fileSystem=new FileSystem("Designation.txt");
    
    public DesignationInfo(){}
    
    public DesignationInfo(String Designation){
    
        
        this.Designation = Designation;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
    public boolean addDesignation()
    {
        if(!fileSystem.create_NewFile())
        {
            String emp=Designation;
     
            return fileSystem.writeDataToFile(emp);
        }
        return false;
    }

    
}

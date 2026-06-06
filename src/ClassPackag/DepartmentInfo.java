
package ClassPackag;

import java.io.BufferedReader;

public class DepartmentInfo {
  
     private String Department;
   
    FileSystem fileSystem=new FileSystem("Department.txt");
    
    public DepartmentInfo(){}
    
    public DepartmentInfo(String Department){
    
        
        this.Department = Department;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }
    public boolean addDepartment()
    {
        if(!fileSystem.create_NewFile())
        {
            String emp=Department;
     
            return fileSystem.writeDataToFile(emp);
        }
        return false;
    }

}

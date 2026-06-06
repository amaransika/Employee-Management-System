
package ClassPackag;

import java.io.BufferedReader;

public class EmployeeForm {
    
    private String EmployeeEPF;
    private String EmployeeName;
    private String Gender;
    private String Address;
    private String Department;
    private String Designation;
    
    FileSystem fileSystem=new FileSystem("EmployeeInfo.txt");
    
    public EmployeeForm(){}
    
    public EmployeeForm(String EPF, String EmpName,String Gender, String Address, String Department,String Designation){
    
        this.EmployeeEPF = EPF;
        this.EmployeeName = EmpName;
        this.Gender = Gender;
        this.Address = Address;
        this.Department = Department;
        this.Designation = Designation;
    }

    public String getEmployeeEPF() {
        return EmployeeEPF;
    }

    public void setEmployeeEPF(String EmployeeEPF) {
        this.EmployeeEPF = EmployeeEPF;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
    
    public boolean addEmployee()
    {
        if(!fileSystem.create_NewFile())
        {
            String emp=EmployeeEPF+" "+EmployeeName+" "+Gender+" "+Address+" "+Department+" "+Designation+" ";
     
            return fileSystem.writeDataToFile(emp);
        }
        return false;
    }
    public boolean searchEmployee(String keyword)
    {
        boolean isFound=false;
        
        try{
            String[]words=null;
            BufferedReader bufferedReader=fileSystem.readFile();
            String employee;
            while((employee = bufferedReader.readLine())!=null)
            {
                words=employee.split(" ");
                
                for(String word : words)
                {
                    if(word.equals(keyword))
                    {
                        isFound=true;
                        this.setEmployeeEPF(words[0]);
                        this.setEmployeeName(words[1]);
                        this.setGender(words[2]);
                        this.setAddress(words[3]);
                        this.setDepartment(words[4]);
                        this.setDesignation(words[5]);
                        break;
                    }
                }
            }
        }
        catch(Exception ex)
        {
                 System.err.println("Something went wrong"+ex);
        }
        return isFound;
    }
}
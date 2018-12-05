package com.scp.java.Hibernate.hibcurd;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {
      Employee emp1=new Employee(101,"anu",152515,"surat",18);
      Employee emp2=new Employee(021, "arnav",251512,"solapur",15);
      EmployeeImpl emp=new EmployeeImpl();
      System.out.println("adding employee successfully....");
      
      boolean isEmployeeAddred = emp.addEmployee(emp1);
		String yesOrNo = isEmployeeAddred ? "Yes" : "No";
		System.out.println("isEmployeeAddred  : " + yesOrNo);
		

		isEmployeeAddred = emp.addEmployee(emp2);
		yesOrNo = isEmployeeAddred ? "Yes" : "No";
		System.out.println("IsCustomerAdded  : " + yesOrNo);
		
		
		System.out.println("get Customer ");
		Employee dbemp = emp.getEmployee(1);
		System.out.println("getCustomer   : " + dbemp);
		
		
		System.out.println("update customer");
		dbemp.setAddress("Mumbai");
		Employee updatedemp =emp.updateEmployee(dbemp);
		System.out.println("update : Pune  -----   : " + dbemp);
		dbemp = emp.getEmployee(1);
		System.out.println("update : kholapur-----   : " + dbemp);
		
		
		System.out.println("getAllCust");
		List<Employee> empList = emp.getAllEmployee();
		System.out.println("list of customer -  " + empList);
		
		boolean isemployeedeleted = emp.deleteEmployee(1);
		yesOrNo = isEmployeeAddred ? "Yes" : "No";
		System.out.println("Isemployeedeleted  : " + yesOrNo);
		
		
		System.out.println("after delete");
		empList = emp.getAllEmployee();
		System.out.println("list of employee-  " + empList);
		
    }
}

package com.scp.java.Hibernate.hibcurd;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeImpl implements EmployeeServices{

	private static SessionFactory SessionFactory=null;
	static
	{
		SessionFactory= AppUtil.getSessionFactory();
	}
	
	@Override
	public boolean addEmployee(Employee emp) {
		try{
			Session session = SessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(emp);
			AppUtil.closeResources(session,tr);
			return true;	
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public Employee getEmployee(int empId) {
		try{
			Session session = SessionFactory.openSession();
			Employee emp  = session.get(Employee.class,empId);
			AppUtil.closeResources(session,null);
			return emp;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean deleteEmployee(int empId) {
		try{
			Employee dbemp = getEmployee(empId);
			if(dbemp!=null){
					Session session = SessionFactory.openSession();
					Transaction tr = session.beginTransaction();
					session.delete(dbemp);
					AppUtil.closeResources(session,tr);
					return true;	
			}
			System.out.println("no employee exist with given id so cannot delete");
			return false;
		}catch(Exception e){
			return false;
		}
		
	}
	
	@Override
	public Employee updateEmployee(Employee emp) {
		try{
			Employee dbemp = getEmployee(emp.getEmpId());
			if(dbemp!=null){
				Session session = SessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				Employee updatedemp = (Employee)session.merge(emp);
				AppUtil.closeResources(session,tr);
				return updatedemp;
			}
			System.out.println("no employee exist with given id so cannot update");
			return null;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = AppUtil.getSessionFactory().openSession();
		List<Employee>employeeList = session.createCriteria(Employee.class).list();
		AppUtil.closeResources(session,null);
		return employeeList;
	
	}

}

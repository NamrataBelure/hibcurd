package com.scp.java.Hibernate.hibcurd;

import java.util.List;

public interface EmployeeServices {
	public boolean addEmployee(Employee emp);
	public Employee getEmployee(int empId);
	public boolean deleteEmployee(int empId);
	public Employee updateEmployee(Employee emp);
	public List<Employee> getAllEmployee();
}

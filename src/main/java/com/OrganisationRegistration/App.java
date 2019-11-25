package com.OrganisationRegistration;

import org.hibernate.Session;

import com.OrganisationRegistration.bean.Address;
import com.OrganisationRegistration.bean.Department;
import com.OrganisationRegistration.bean.Employee;
import com.OrganisationRegistration.bean.Organisation;
import com.OrganisationRegistration.util.SessionUtil;

public class App {
	
	public static void main(String args[])
	{
		Department dept=new Department();
		Employee emp=new Employee();
		Address addr=new Address();
		Organisation org=new Organisation();
		dept.setName("MT-ESE");
		emp.setDept(dept);
		emp.setPassword("password");
		emp.setEmail("abc");
		addr.setCity("Banglore");
		addr.setLandmark("HSR");
		addr.setPincode(3112);
		addr.setState("Karnatak");
		org.setAddress(addr);
		org.setEmp(emp);
		org.setName("amazon");
		org.setContact("12345678");
		
		Session session = SessionUtil.getSession();
        session.beginTransaction();
        
        session.save(dept);
        session.save(emp);
        session.save(addr);
        session.save(org);
        
        session.getTransaction().commit();
        session.close();
	}
  
}

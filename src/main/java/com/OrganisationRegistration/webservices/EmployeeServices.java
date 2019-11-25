package com.OrganisationRegistration.webservices;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.OrganisationRegistration.bean.Employee;
import com.OrganisationRegistration.bean.Organisation;
import com.OrganisationRegistration.util.SessionUtil;

public class EmployeeServices {
	
	public boolean verifyUser(String id,String password)
	{
		boolean result;
		Session session = SessionUtil.getSession();
        session.beginTransaction();
        
        Query q=session.createQuery("from Employee where email= :emp_id");
        q.setParameter("emp_id", id);
        Employee emp=(Employee)q.getSingleResult();
        if(emp==null)
        	result=false;
        else if(emp.getPassword().compareTo(password)==0)
        	result=true;
        else
        	result=false;
        session.getTransaction().commit();
        session.close();
        return result;
	}
}

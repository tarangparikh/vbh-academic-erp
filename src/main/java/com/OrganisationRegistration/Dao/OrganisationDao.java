package com.OrganisationRegistration.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.OrganisationRegistration.bean.Organisation;
import com.OrganisationRegistration.util.SessionUtil;
import com.OrganisationRegistration.Dao.*;

public class OrganisationDao {
	
	public List<Organisation> View(Integer id)
	{
		
		Session session = SessionUtil.getSession();
        session.beginTransaction();

        Query q=session.createQuery("from Organisation where emp.id= :emp_id");
        q.setParameter("emp_id", id);
        List<Organisation> list=q.list();
        
        session.getTransaction().commit();
        session.close();
        return list;
	}
	
	
  
}

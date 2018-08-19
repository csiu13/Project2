package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.LoginAnnotation;
import com.revature.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao{

	@Override
	public LoginAnnotation findLoginById(int id) {
		
		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = null;
		
		t1 = session.beginTransaction();
		LoginAnnotation x = session.get(LoginAnnotation.class, id);
		t1.commit();
		session.close();
		return x;
	}

}

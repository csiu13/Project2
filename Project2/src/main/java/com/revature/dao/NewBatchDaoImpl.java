package com.revature.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.revature.model.BatchAnnotation;
import com.revature.util.HibernateUtil;

public class NewBatchDaoImpl implements NewBatchDao {

	public BatchAnnotation findBatchById(int id) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = null;
		
		t1 = session.beginTransaction();
		BatchAnnotation x = session.get(BatchAnnotation.class, id);
		t1.commit();
		session.close();
		return x;
	}

}

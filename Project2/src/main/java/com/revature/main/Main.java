package com.revature.main;

import java.sql.SQLException;

import com.revature.dao.NewBatchDaoImpl;
import com.revature.util.HibernateUtil;


public class Main {
	public static void main(String[] args) throws SQLException {
		
		NewBatchDaoImpl nb = new NewBatchDaoImpl();
		System.out.println(nb.findBatchById(1));
		
		HibernateUtil.closeSession();
	}
}

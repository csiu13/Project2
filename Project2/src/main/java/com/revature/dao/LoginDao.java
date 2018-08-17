package com.revature.dao;

import com.revature.model.LoginAnnotation;

public interface LoginDao {
	public LoginAnnotation findLoginById(int id);
}

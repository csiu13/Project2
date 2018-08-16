package com.revature.main;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.NewBatchDao;
import com.revature.dao.NewBatchDaoImpl;
import com.revature.util.HibernateUtil;

@SpringBootApplication(scanBasePackages = "com")
public class Main{ //implements CommandLineRunner{
	
	@Autowired
	NewBatchDaoImpl batchDao;
	
	@RestController
	public class RestApiController {
		@RequestMapping("/api/hi")
		public String hi() {
			return "Hello world!";
			}
//	public static void main(String[] args) throws SQLException {
		
//		NewBatchDaoImpl nb = new NewBatchDaoImpl();
//  	System.out.println(nb.findBatchById(1));

//		SpringApplication.run(Main.class,  args);
//		HibernateUtil.closeSession();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(batchDao.findBatchById(1));
//	}
}

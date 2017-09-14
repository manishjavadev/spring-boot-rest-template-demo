package com.manish.javadev;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.manish.javadev.dao.AccountRepository;
import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.service.AccountService;

/**
 * @author Manish
 *
 */
@SpringBootApplication
public class SpringBootApplicationDemo implements CommandLineRunner {
	@Autowired
	static AccountRepository accountRepository;

	@Autowired
	private AccountService accountService;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApplicationDemo.class, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("accountService = " + accountService.getClass().getSimpleName());
		Calendar calendar = Calendar.getInstance();
		Date startDate = null;
		// 1
		startDate = calendar.getTime();
		AccountEntity accountEntity = new AccountEntity("Saving Account", "Manish", new Double(15000));
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		// 2
		calendar.add(Calendar.MONTH, -1);
		startDate = calendar.getTime();
		accountEntity = new AccountEntity("Saving Account", "Neha", new Double(15000));
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		// 3
		accountEntity = new AccountEntity("Saving Account", "Veena", new Double(15000));
		calendar.add(Calendar.MONTH, -2);
		startDate = calendar.getTime();
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		// 4
		accountEntity = new AccountEntity("Personal Account", "Munichandra", new Double(15000));
		calendar.add(Calendar.MONTH, -3);
		startDate = calendar.getTime();
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		// 5
		accountEntity = new AccountEntity("Personal Account", "Veena", new Double(15000));
		calendar.add(Calendar.MONTH, -4);
		startDate = calendar.getTime();
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		System.out.println("===================");
		accountEntity = accountService.findAccount(new Long(1));
		System.out.println("After Loading The Account info =" + accountEntity);
		System.out.println("Done");

	}
}

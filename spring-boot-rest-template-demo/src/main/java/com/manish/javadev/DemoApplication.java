package com.manish.javadev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.service.AccountService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveData();
		System.out.println("Done");

	}

	private void saveData() {

		AccountEntity accountResult = accountService
				.addAccount(new AccountEntity("Saving Account", "Manish", new Double(20000)));
		System.out.println(accountResult);
		System.out.println("==============");
		accountResult = accountService.addAccount(new AccountEntity("Current Account", "Veena", new Double(30000)));
		System.out.println(accountResult);

	}
}

package com.manish.javadev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.repository.AccountRepositery;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepositery accountRepositery;

	@Override
	public List<AccountEntity> getAllAccounts() {

		return (List<AccountEntity>) accountRepositery.findAll();
	}

	@Override
	public AccountEntity getAccountById(Long accId) {
		return accountRepositery.findOne(accId);
	}

	@Override
	public AccountEntity addAccount(AccountEntity accountEntity) {
		return accountRepositery.save(accountEntity);
	}

	@Override
	public void updateAccount(AccountEntity accountEntity) {
		accountRepositery.save(accountEntity);

	}

	@Override
	public void deleteAccount(Long accId) {
		accountRepositery.delete(accId);

	}

}

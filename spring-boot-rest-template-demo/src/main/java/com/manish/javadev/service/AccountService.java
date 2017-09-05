package com.manish.javadev.service;

import java.util.List;

import com.manish.javadev.model.AccountEntity;

public interface AccountService {

	List<AccountEntity> getAllAccounts();

	AccountEntity getAccountById(Long accId);

	AccountEntity addAccount(AccountEntity accountEntity);

	void updateAccount(AccountEntity accountEntity);

	void deleteAccount(Long accId);

}

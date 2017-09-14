package com.manish.javadev.service;

import java.util.List;

import com.manish.javadev.model.AccountEntity;

/**
 * @author Manish
 *
 */
public interface AccountService {
	AccountEntity createAccount(AccountEntity accountEntity);

	AccountEntity findAccount(Long accountNumber);

	public AccountEntity depositAmount(Long accountNumber, Double amount);

	void fundTransfer(Long accountFrom, Long accountTo, Double amount);

	AccountEntity updateAccount(Long accountNumber, AccountEntity accountEntity);

	List<AccountEntity> findAllAccounts();

	void deleteAccount(Long accountNumber);
}

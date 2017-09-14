package com.manish.javadev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manish.javadev.dao.AccountRepository;
import com.manish.javadev.model.AccountEntity;

/**
 * @author Manish
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public void setPersonDAO(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public AccountEntity createAccount(AccountEntity accountEntity) {
		AccountEntity acccountResult = accountRepository.save(accountEntity);
		return acccountResult;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public void fundTransfer(Long accountFrom, Long accountTo, Double amount) {
		AccountEntity accountEntity = accountRepository.findOne(accountFrom);
		accountEntity.setAmount(accountEntity.getAmount() - amount);
		accountRepository.save(accountEntity);
		accountEntity = accountRepository.findOne(accountTo);
		accountEntity.setAmount(accountEntity.getAmount() + amount);
		accountRepository.save(accountEntity);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public AccountEntity depositAmount(Long accountNumber, Double amount) {
		AccountEntity accountEntity = accountRepository.findOne(accountNumber);
		accountEntity.setAmount(accountEntity.getAmount() + amount);
		return accountRepository.save(accountEntity);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public AccountEntity findAccount(Long accountNumber) {
		return accountRepository.findOne(accountNumber);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public AccountEntity updateAccount(Long accountNumber, AccountEntity sourceEntity) {
		AccountEntity targetEntity = accountRepository.findOne(accountNumber);
		targetEntity = papulateAccountEntity(sourceEntity, targetEntity);
		return accountRepository.save(targetEntity);
	}

	private AccountEntity papulateAccountEntity(AccountEntity sourceEntity, AccountEntity targetEntity) {
		targetEntity.setAccountHolderName(sourceEntity.getAccountHolderName());
		return targetEntity;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public List<AccountEntity> findAllAccounts() {
		return (List<AccountEntity>) accountRepository.findAll();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public void deleteAccount(Long accountNumber) {
		accountRepository.delete(accountNumber);
	}
}

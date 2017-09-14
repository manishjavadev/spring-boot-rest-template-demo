package com.manish.javadev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.service.AccountService;

import io.swagger.annotations.Api;

/**
 * @author Manish
 * 
 *         http://localhost:8080/api/ping
 * 
 *         http://localhost:8080/api/account/2
 * 
 *         http://localhost:8080/api/account
 *
 */
@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public boolean ping() {
		return true;

	}

	@RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AccountEntity> findAccount(@PathVariable("accountNumber") Long accountNumber) {
		AccountEntity accountEntity = accountService.findAccount(new Long(accountNumber));
		return new ResponseEntity<AccountEntity>(accountEntity, HttpStatus.OK);
	}

	@RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AccountEntity> deleteAccount(@PathVariable("accountNumber") Long accountNumber) {
		accountService.deleteAccount(new Long(accountNumber));
		return new ResponseEntity<AccountEntity>(HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<AccountEntity>> findAllAccounts() {
		List<AccountEntity> allAccountList = accountService.findAllAccounts();
		return new ResponseEntity<List<AccountEntity>>(allAccountList, HttpStatus.OK);
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountEntity accountEntity) {
		accountEntity = accountService.createAccount(accountEntity);
		return new ResponseEntity<AccountEntity>(accountEntity, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
					MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AccountEntity> updateAccount(@PathVariable("accountNumber") Long accountNumber,
			@RequestBody AccountEntity accountEntity) {
		accountEntity = accountService.updateAccount(accountNumber, accountEntity);
		return new ResponseEntity<AccountEntity>(accountEntity, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/fundtransfer/{accountNumberfrom}/{accountNumberto}/{amount}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> fundTransfer(@PathVariable("accountNumberfrom") Long accountNumberFrom,
			@PathVariable("accountNumberto") Long accountNumberto, @PathVariable("amount") Double amount) {
		accountService.fundTransfer(new Long(accountNumberFrom), new Long(accountNumberto), new Double(amount));
		return new ResponseEntity<String>("Fund Transfer Successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/deposit/{accountNumber}/{amount}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AccountEntity> depositAmount(@PathVariable("accountNumber") Long accountNumber,
			@PathVariable("amount") Double amount) {
		AccountEntity accountEntity = accountService.depositAmount(new Long(accountNumber), new Double(amount));
		return new ResponseEntity<AccountEntity>(accountEntity, HttpStatus.OK);
	}

}

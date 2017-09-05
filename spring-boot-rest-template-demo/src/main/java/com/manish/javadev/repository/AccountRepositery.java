package com.manish.javadev.repository;

import org.springframework.data.repository.CrudRepository;

import com.manish.javadev.model.AccountEntity;

public interface AccountRepositery extends CrudRepository<AccountEntity, Long> {

}

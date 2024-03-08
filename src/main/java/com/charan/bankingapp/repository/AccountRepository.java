package com.charan.bankingapp.repository;

import com.charan.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account,Long> {
}

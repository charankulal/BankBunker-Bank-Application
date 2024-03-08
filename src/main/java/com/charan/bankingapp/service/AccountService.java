package com.charan.bankingapp.service;

import com.charan.bankingapp.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);
}

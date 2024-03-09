package com.charan.bankingapp.service.impl;

import com.charan.bankingapp.dto.AccountDto;
import com.charan.bankingapp.entity.Account;
import com.charan.bankingapp.mapper.AccountMapper;
import com.charan.bankingapp.repository.AccountRepository;
import com.charan.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount= accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        double total=account.getBalance()+ amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        if (account.getBalance()<amount)
        {
            throw new RuntimeException("Insufficient amount");
        }
        double total=account.getBalance()- amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}

package com.charan.bankingapp.mapper;

import com.charan.bankingapp.dto.AccountDto;
import com.charan.bankingapp.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto)
    {
        Account account;
        account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto;
        accountDto= new AccountDto(
            account.getId(),
            account.getAccountHolderName(),
            account.getBalance()
        );
    return accountDto;
    }

}

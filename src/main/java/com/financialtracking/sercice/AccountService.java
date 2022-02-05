package com.financialtracking.sercice;

import com.financialtracking.dto.AccountDTO;

public interface AccountService
{
    AccountDTO save(AccountDTO accountDTO, Long id);
}

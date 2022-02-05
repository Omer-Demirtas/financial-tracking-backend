package com.financialtracking.sercice.impl;

import com.financialtracking.Repository.AccountActivityRepository;
import com.financialtracking.Repository.AccountRepository;
import com.financialtracking.domain.Account;
import com.financialtracking.domain.AccountActivity;
import com.financialtracking.domain.User;
import com.financialtracking.dto.AccountDTO;
import com.financialtracking.sercice.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService
{
    private final AccountRepository accountRepository;
    private final AccountActivityRepository accountActivityRepository;

    @Override
    public AccountDTO save(AccountDTO accountDTO, Long id)
    {

        Account account = Account.builder()
                .title(accountDTO.getTitle())
                .user(new User(id))
                .build();

        account = accountRepository.save(account);

        List<AccountActivity> activities = new ArrayList<>();

        for (int i = 0; i < 12; i++)
        {
            activities.add(
                    AccountActivity.builder()
                            .year(2021)
                            .month(""+i)
                            .account(account)
                            .income(0 + (Math.random() * (9000)))
                            .expense(0 + (Math.random() * (9000)))
                            .build()
            );
        }

        accountActivityRepository.saveAll(activities);

        return null;
        //return AccountDTO.builder().id(account.getId()).title(account.getTitle()).build();
    }
}

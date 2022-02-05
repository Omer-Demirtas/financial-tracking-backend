package com.financialtracking.sercice.impl;

import com.financialtracking.Repository.AccountActivityRepository;
import com.financialtracking.Repository.AccountRepository;
import com.financialtracking.Repository.UserRepository;
import com.financialtracking.domain.AccountActivity;
import com.financialtracking.domain.User;
import com.financialtracking.dto.AccountActivityDTO;
import com.financialtracking.dto.AccountDTO;
import com.financialtracking.dto.UserDTO;
import com.financialtracking.sercice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final AccountActivityRepository accountActivityRepository;

    @Override
    public UserDTO findUserById(Long id)
    {
        int year = LocalDate.now().getYear();

        UserDTO user = userRepository.findUserById(id);

        List<AccountDTO> accounts = accountRepository.findAllByUserId(user.getId());

        accounts.forEach(account -> {
            List<AccountActivityDTO> activities = accountActivityRepository.findAllByAccountIdAndYear(account.getId(), year);

            account.setActivities(activities);
        });

        user.setAccounts(accounts);

        return user;
    }
}

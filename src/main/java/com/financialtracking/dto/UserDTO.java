package com.financialtracking.dto;

import com.financialtracking.domain.Account;
import com.financialtracking.domain.Organization;
import com.financialtracking.domain.User;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable
{
    private Long id;

    private String username;

    private String email;

    private List<AccountDTO> accounts = new ArrayList<>();

    private List<OrganizationDTO> organizations = new ArrayList<>();

    public UserDTO(User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.accounts = user.getAccounts().stream().map(account -> AccountDTO.builder()
                .id(account.getId())
                .title(account.getTitle())
                .activities(account.getAccountActivities().stream().map(accountActivity -> AccountActivityDTO.builder()
                        .id(accountActivity.getId())
                        .expense(accountActivity.getExpense())
                        .income(accountActivity.getIncome())
                        .month(accountActivity.getMonth())
                        .year(accountActivity.getYear())
                        .build()
                ).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());
        this.organizations = user.getOrganizations().stream().map(organization -> OrganizationDTO.builder().title(organization.getTitle()).build()).collect(Collectors.toList());
    }

    public UserDTO(Long id, String username, String email)
    {
        this.id = id;
        this.email = email;
        this.username = username;
        //this.accounts = user.getAccounts().stream().map(account -> AccountDTO.builder().id(account.getId()).title(account.getTitle()).build()).collect(Collectors.toList());
    }
}

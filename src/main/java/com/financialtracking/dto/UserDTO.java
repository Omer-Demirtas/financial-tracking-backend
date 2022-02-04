package com.financialtracking.dto;

import com.financialtracking.domain.Account;
import com.financialtracking.domain.Organization;
import com.financialtracking.domain.User;
import lombok.*;

import java.io.Serializable;
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

    private List<AccountDTO> accounts;

    private List<OrganizationDTO> organizations;

    public UserDTO(User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmil();
        this.organizations = user.getOrganizations().stream().map(organization -> OrganizationDTO.builder().title(organization.getTitle()).build()).collect(Collectors.toList());
    }
}

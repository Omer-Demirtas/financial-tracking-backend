package com.financialtracking.dto;

import com.financialtracking.domain.AccountActivity;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable
{
    private Long id;

    private String title;

    private List<ActionDTO> actions = new ArrayList<>();

    private List<AccountActivityDTO> activities = new ArrayList<>();


    public AccountDTO(Long id, String title)
    {
        this.id = id;
        this.title = title;
    }
}

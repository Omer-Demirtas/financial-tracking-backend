package com.financialtracking.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable
{
    private Long id;

    private String title;
}

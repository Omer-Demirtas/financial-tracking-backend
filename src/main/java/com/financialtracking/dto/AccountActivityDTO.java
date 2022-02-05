package com.financialtracking.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountActivityDTO
{
    private Long id;

    private int year;

    private String month;

    private Double income;

    private Double expense;
}

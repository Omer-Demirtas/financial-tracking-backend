package com.financialtracking.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionDTO
{
    private String title;

    private Double amount;
}

package com.financialtracking.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountActivity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID")
    private Long id;

    @Column( name = "YEAR")
    private Integer year;

    @Column( name = "MONTH", length = 2)
    private String month;

    @Column( name = "INCOME")
    private Double income;

    @Column( name = "EXPENSE")
    private Double expense;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}

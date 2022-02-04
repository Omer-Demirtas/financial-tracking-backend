package com.financialtracking.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "T_USER")
public class User
{
    @Id
    @GeneratedValue
    @Column( name = "ID")
    private Long id;

    @Column( name = "EMAIL")
    private String emil;

    @Column( name = "USERNAME")
    private String username;

    @Column( name = "PASSWORD")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "T_USER_ORGANIZATION",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id"))
    List<Organization> organizations;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Account> accounts;
}

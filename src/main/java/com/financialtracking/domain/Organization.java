package com.financialtracking.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table( name = "T_ORGANIZATION" )
@NoArgsConstructor
@AllArgsConstructor
public class Organization
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "ID")
    private Long id;

    @Column( name = "TITLE" )
    private String title;

    @ManyToMany(mappedBy = "organizations")
    List<User> users;
}

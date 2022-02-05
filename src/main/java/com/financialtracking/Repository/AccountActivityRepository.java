package com.financialtracking.Repository;

import com.financialtracking.domain.AccountActivity;
import com.financialtracking.dto.AccountActivityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountActivityRepository extends JpaRepository<AccountActivity, Long>
{
    @Query(
            value = "SELECT new com.financialtracking.dto.AccountActivityDTO( " +
                    "aa.id, aa.year, aa.month, aa.income, aa.expense ) " +
                    "FROM AccountActivity aa " +
                    "WHERE aa.account.id = :id and aa.year = :year"
    )
    List<AccountActivityDTO> findAllByAccountIdAndYear(@Param("id") Long id, @Param("year") int year);
}

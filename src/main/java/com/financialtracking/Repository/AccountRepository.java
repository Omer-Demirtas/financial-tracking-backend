package com.financialtracking.Repository;

import com.financialtracking.domain.Account;
import com.financialtracking.dto.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{

    @Query(
            value = "SELECT new com.financialtracking.dto.AccountDTO(ac.id, ac.title) FROM Account ac " +
                    "WHERE ac.user.id = :id "
    )
    List<AccountDTO> findAllByUserId(Long id);
}

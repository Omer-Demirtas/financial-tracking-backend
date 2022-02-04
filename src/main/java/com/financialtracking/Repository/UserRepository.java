package com.financialtracking.Repository;

import com.financialtracking.domain.User;
import com.financialtracking.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    @Query("SELECT new com.financialtracking.dto.UserDTO(u) FROM User u WHERE u.id = :id")
    UserDTO findFirstById(@Param("id") Long id);
}

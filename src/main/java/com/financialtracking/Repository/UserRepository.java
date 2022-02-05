package com.financialtracking.Repository;

import com.financialtracking.domain.User;
import com.financialtracking.dto.UserDTO;
import com.financialtracking.projection.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    @Query( value = "SELECT u FROM User u"
    )
    List<UserView> getUser();

    @Query(
            value = "SELECT new com.financialtracking.dto.UserDTO(u) " +
                    "FROM User u " +
                    "JOIN u.accounts a " +
                    "WHERE u.id = :id AND a.title = 'Garanti'"
    )
    UserDTO findFirstById(@Param("id") Long id);

    @Query(
            value = "SELECT new com.financialtracking.dto.UserDTO(u.id, u.username, u.email) FROM User u " +
                    "WHERE u.id = :id"
    )
    UserDTO findUserById(Long id);
}

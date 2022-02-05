package com.financialtracking.sercice;

import com.financialtracking.domain.User;
import com.financialtracking.dto.UserDTO;

public interface UserService
{
    UserDTO findUserById(Long id);
}

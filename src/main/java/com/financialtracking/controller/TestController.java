package com.financialtracking.controller;

import com.financialtracking.Repository.UserRepository;
import com.financialtracking.domain.User;
import com.financialtracking.dto.AccountDTO;
import com.financialtracking.sercice.AccountService;
import com.financialtracking.sercice.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController
{
    private final UserRepository userRepository;
    private final AccountService accountService;
    private final UserService userService;

    @GetMapping("/test")
    public ResponseEntity<?> getTest()
    {
        User user = new User();
        Pageable pageable = PageRequest.of(10, 10);
        //return ResponseEntity.ok(userRepository.findAll(pageable));

        AccountDTO accountDTO = AccountDTO.builder()
                .title("İş bankası")
                .build();

        accountService.save(accountDTO, 1L);

        return ResponseEntity.ok(userRepository.getUser());
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser()
    {
        return ResponseEntity.ok(userService.findUserById(1L));
    }
}

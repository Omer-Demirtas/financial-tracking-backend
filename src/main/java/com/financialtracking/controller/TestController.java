package com.financialtracking.controller;

import com.financialtracking.Repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController
{
    private final UserRepository userRepository;

    @GetMapping("/test")
    public ResponseEntity<?> getTest()
    {
        Pageable pageable = PageRequest.of(10, 10);
        //return ResponseEntity.ok(userRepository.findAll(pageable));
        return null;
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUser()
    {
        return ResponseEntity.ok(userRepository.findFirstById(562L));
    }
}

package com.bank.demo;

import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/account")
public class AccountController {
    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Account> repositoryAccounts = new ArrayList<>();

    @GetMapping
    public List<Account> index() {
        return repositoryAccounts;
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) {
        log.info("Cadastrando conta do titular: " + account.getTitular());
        repositoryAccounts.add(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

}

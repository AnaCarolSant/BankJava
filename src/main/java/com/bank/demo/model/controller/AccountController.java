package com.bank.demo.model.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bank.demo.model.Account;

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
        validarConta(account);
        account.setAberturaDate(LocalDateTime.now()); // Define a data de abertura automaticamente
        repositoryAccounts.add(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    private void validarConta(Account account) {

        // valida se o titular vai ser preenchido ()
        if (account.getTitular() == null || account.getTitular().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome do titular é obrigatório.");
        }

        if (account.getAberturaDate() != null && account.getAberturaDate().isAfter(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data de abertura não pode ser no futuro.");
        }

        if (account.getSaldo() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O saldo inicial não pode ser negativo.");
        }

        if (!List.of("corrente", "poupanca", "salario").contains(account.getTipo().toLowerCase())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O tipo deve ser 'corrente', 'poupanca' ou 'salario'.");
        }
    }

}

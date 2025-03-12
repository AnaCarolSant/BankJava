package com.bank.demo.model;

import java.time.LocalDateTime;

public class Account {
    private int agencia;
    private int conta;
    private String titular;
    private LocalDateTime aberturaDate; // Alterado para LocalDateTime
    private int saldo;
    private boolean status;
    private String tipo;

    public Account(int agencia, int conta, String titular, int saldo, boolean status, String tipo) {
        this.agencia = agencia;
        this.conta = conta;
        this.titular = titular;
        this.aberturaDate = LocalDateTime.now(); // Pega a data e hora atuais
        this.saldo = saldo;
        this.status = status;
        this.tipo = tipo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDateTime getAberturaDate() {
        return aberturaDate;
    }

    public void setAberturaDate(LocalDateTime aberturaDate) {
        this.aberturaDate = aberturaDate;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

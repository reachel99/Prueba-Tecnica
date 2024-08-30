package com.programa.prueba.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String numeroCuenta;

    @NotNull
    private String tipoCuenta;

    @NotNull
    private BigDecimal saldoInicial;

    @NotNull
    private Boolean estado;

    @NotNull
    private Long clienteId;

    public @NotNull Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(@NotNull Long clienteId) {
        this.clienteId = clienteId;
    }

    public @NotNull Boolean getEstado() {
        return estado;
    }

    public void setEstado(@NotNull Boolean estado) {
        this.estado = estado;
    }

    public @NotNull BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(@NotNull BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public @NotNull String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(@NotNull String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public @NotNull String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(@NotNull String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

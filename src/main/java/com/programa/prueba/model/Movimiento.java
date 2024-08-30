package com.programa.prueba.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime fecha;

    @NotNull
    private String tipo;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private BigDecimal saldo;

    @NotNull
    private Long cuentaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(@NotNull LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public @NotNull String getTipo() {
        return tipo;
    }

    public void setTipo(@NotNull String tipo) {
        this.tipo = tipo;
    }

    public @NotNull BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull BigDecimal valor) {
        this.valor = valor;
    }

    public @NotNull BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(@NotNull BigDecimal saldo) {
        this.saldo = saldo;
    }

    public @NotNull Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(@NotNull Long cuentaId) {
        this.cuentaId = cuentaId;
    }
}

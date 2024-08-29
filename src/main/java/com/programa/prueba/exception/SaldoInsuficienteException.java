package com.programa.prueba.exception;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException(String message){
        super(message);
    }
}

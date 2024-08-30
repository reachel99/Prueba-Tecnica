package com.programa.prueba.service;

import com.programa.prueba.exception.SaldoInsuficienteException;
import com.programa.prueba.model.Cuenta;
import com.programa.prueba.model.Movimiento;
import com.programa.prueba.repository.CuentaRepository;
import com.programa.prueba.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public Movimiento saveMovimiento(Movimiento movimiento) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(movimiento.getCuenta().getId());
        if (cuentaOpt.isEmpty()) {
            throw new IllegalArgumentException("Cuenta no encontrada");
        }

        Cuenta cuenta = cuentaOpt.get();
        BigDecimal nuevoSaldo;

        if (movimiento.getTipo().equalsIgnoreCase("Deposito")) {
            nuevoSaldo = cuenta.getSaldoInicial().add(movimiento.getValor());
        } else if (movimiento.getTipo().equalsIgnoreCase("Retiro")) {
            nuevoSaldo = cuenta.getSaldoInicial().subtract(movimiento.getValor());
            if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
                throw new SaldoInsuficienteException("Saldo no disponible");
            }
        } else {
            throw new IllegalArgumentException("Tipo de movimiento no reconocido");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaRepository.save(cuenta);

        movimiento.setSaldo(nuevoSaldo);
        movimiento.setFecha(new java.sql.Timestamp(System.currentTimeMillis())); 
        return movimientoRepository.save(movimiento);
    }

    public Optional<Movimiento> getMovimientoById(Long id) {
        return movimientoRepository.findById(id);
    }

    public Iterable<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}

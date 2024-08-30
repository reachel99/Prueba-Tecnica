package com.programa.prueba.service;

import com.programa.prueba.exception.SaldoInsuficienteException;
import com.programa.prueba.model.Cuenta;
import com.programa.prueba.model.Movimiento;
import com.programa.prueba.repository.CuentaRepository;
import com.programa.prueba.repository.MovimientoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {


    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public Movimiento crearMovimiento(Movimiento movimiento) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(movimiento.getCuentaId());
        if (cuentaOpt.isPresent()) {
            Cuenta cuenta = cuentaOpt.get();

            if ("Deposito".equalsIgnoreCase(movimiento.getTipo())) {

                cuenta.setSaldoInicial(cuenta.getSaldoInicial().add(movimiento.getValor()));
                cuentaRepository.save(cuenta);
                movimiento.setSaldo(cuenta.getSaldoInicial());
                return movimientoRepository.save(movimiento);
            } else if ("Retiro".equalsIgnoreCase(movimiento.getTipo())) {
                if (cuenta.getSaldoInicial().compareTo(movimiento.getValor()) < 0) {
                    throw new SaldoInsuficienteException("Saldo no disponible");
                }

                cuenta.setSaldoInicial(cuenta.getSaldoInicial().subtract(movimiento.getValor()));
                cuentaRepository.save(cuenta);
                movimiento.setSaldo(cuenta.getSaldoInicial());
                return movimientoRepository.save(movimiento);
            } else {
                throw new IllegalArgumentException("Tipo de movimiento no válido");
            }
        }
        throw new IllegalArgumentException("Cuenta no encontrada");
    }

    public List<Movimiento> obtenerTodosMovimientos() {
        return movimientoRepository.findAll();
    }

    public Movimiento obtenerMovimientoPorId(Long id) {
        return movimientoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Movimiento actualizarMovimiento(Long id, Movimiento movimiento) {
        Optional<Movimiento> movimientoExistente = movimientoRepository.findById(id);
        if (movimientoExistente.isPresent()) {
            Movimiento movToUpdate = movimientoExistente.get();

  
            if (!"Deposito".equalsIgnoreCase(movimiento.getTipo()) && !"Retiro".equalsIgnoreCase(movimiento.getTipo())) {
                throw new IllegalArgumentException("Tipo de movimiento no válido");
            }

            movToUpdate.setFecha(movimiento.getFecha());
            movToUpdate.setTipo(movimiento.getTipo());
            movToUpdate.setValor(movimiento.getValor());
            movToUpdate.setCuentaId(movimiento.getCuentaId());

            return movimientoRepository.save(movToUpdate);
        } else {
            throw new RuntimeException("Movimiento no encontrado");
        }
    }

    public void eliminarMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}

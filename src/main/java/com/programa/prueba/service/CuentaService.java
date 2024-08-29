package com.programa.prueba.service;

import com.programa.prueba.model.Cuenta;
import com.programa.prueba.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public Cuenta saveCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> getCuentaById(Long id) {
        return cuentaRepository.findById(id);
    }

    public Iterable<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }

    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }
}

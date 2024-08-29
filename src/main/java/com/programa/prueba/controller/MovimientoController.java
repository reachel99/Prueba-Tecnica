package com.programa.prueba.controller;

import com.programa.prueba.exception.SaldoInsuficienteException;
import com.programa.prueba.model.Movimiento;
import com.programa.prueba.service.MovimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movimientos")
public class MovimientoController {


    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<String> crearMovimiento(@RequestBody Movimiento movimiento) {
        try {
            Movimiento nuevoMovimiento = movimientoService.saveMovimiento(movimiento);
            if (movimiento.getTipo().equalsIgnoreCase("Deposito")) {
                return ResponseEntity.ok("Depósito realizado exitosamente. Saldo actual: " + nuevoMovimiento.getSaldo());
            } else if (movimiento.getTipo().equalsIgnoreCase("Retiro")) {
                return ResponseEntity.ok("Retiro realizado exitosamente. Saldo actual: " + nuevoMovimiento.getSaldo());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Operación no válida.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        return movimientoService.getMovimientoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Movimiento>> getAllMovimientos() {
        return ResponseEntity.ok(movimientoService.getAllMovimientos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @Valid @RequestBody Movimiento movimiento) {
        if (!movimientoService.getMovimientoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        movimiento.setId(id);
        Movimiento updatedMovimiento = movimientoService.saveMovimiento(movimiento);
        return ResponseEntity.ok(updatedMovimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        if (!movimientoService.getMovimientoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        movimientoService.deleteMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}

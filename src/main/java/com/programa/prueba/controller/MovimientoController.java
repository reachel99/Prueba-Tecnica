package com.programa.prueba.controller;

import com.programa.prueba.exception.SaldoInsuficienteException;
import com.programa.prueba.model.Movimiento;
import com.programa.prueba.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/movimientos")
@Validated
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<String> crearMovimiento(@RequestBody Movimiento movimiento) {
        try {
            movimientoService.crearMovimiento(movimiento);
            return ResponseEntity.ok("Movimiento registrado con éxito");
        } catch (SaldoInsuficienteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> obtenerTodosMovimientos() {
        return ResponseEntity.ok(movimientoService.obtenerTodosMovimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> obtenerMovimientoPorId(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.obtenerMovimientoPorId(id);
        if (movimiento != null) {
            return ResponseEntity.ok(movimiento);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> actualizarMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        Movimiento movimientoActualizado = movimientoService.actualizarMovimiento(id, movimiento);
        if (movimientoActualizado != null) {
            return ResponseEntity.ok(movimientoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long id) {
        movimientoService.eliminarMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}

package com.programa.prueba.controller;

import com.programa.prueba.model.Cliente;
import com.programa.prueba.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente) {
        try {
            Cliente nuevoCliente = clienteService.saveCliente(cliente);
            return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> getAllClientes() {
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        if (!clienteService.getClienteById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        Cliente updatedCliente = clienteService.saveCliente(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (!clienteService.getClienteById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}

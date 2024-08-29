package com.programa.prueba.service;

import com.programa.prueba.model.Cliente;
import com.programa.prueba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public Iterable<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

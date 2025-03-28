package br.com.ninodev.cortecerto.controller;

import br.com.ninodev.cortecerto.dto.ClienteDTO;
import br.com.ninodev.cortecerto.model.Cliente;
import br.com.ninodev.cortecerto.model.Login;
import br.com.ninodev.cortecerto.repository.ClienteRepository;
import br.com.ninodev.cortecerto.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @PostMapping("/login")
    public void loginRequest(@RequestBody Login dados) {
        System.out.println("oi");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registrarUsuario(@RequestBody ClienteDTO dto) {
        clienteService.registrarCliente(dto);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }


    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

}

package com.algaworks.algalog.apiController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    List<Cliente> listar(){
        return clienteRepository.findAll();

    } 
    
    @RequestMapping("/{clienteId}")
    ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        
        if (!cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(cliente.get());
        
        
        // Outra forma, mais enxuta, usando uma linguagem intermediária do Java:

        // return clienteRepository.findById(clienteId)
        //         .map(ResponseEntity::ok)
        //         .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Cliente cadastrar(@RequestBody Cliente cliente){
        
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    ResponseEntity<Cliente> atualiza(@PathVariable Long clienteId, @RequestBody Cliente cliente){

        if(!clienteRepository.existsById(clienteId)){

            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    ResponseEntity<Void> deletar(@PathVariable Long clienteId){

        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }
}

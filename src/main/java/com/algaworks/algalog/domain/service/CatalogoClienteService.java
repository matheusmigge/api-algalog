package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

// Componente do Spring que indica que aqui serão declaradas regras de negócio

@AllArgsConstructor
@Service 
public class CatalogoClienteService {

    private ClienteRepository clienteRepository; 
    
    // Componente do Spring que indica que aqui será uma transação, ou seja, se algo de errado neste método, a operação deve ser inteiramente descartada

    @Transactional
    public Cliente salvar(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}

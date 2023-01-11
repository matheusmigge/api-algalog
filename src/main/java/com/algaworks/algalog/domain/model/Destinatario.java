package com.algaworks.algalog.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Declara que essa classe poder ser embutida em outra classe. Se ela for embutida em outra classe, é OBRIGATÓRIO colocar essa anotação.
@Embeddable
public class Destinatario {

    @Column(name = "destinatario_nome")
    private String nome;

    @Column(name = "destinatario_logradouro")
    private String logradouro;

    @Column(name = "destinatario_numero")
    private String numero;

    @Column(name = "destinatario_complemento")
    private String complemento;

    @Column(name = "destinatario_bairro")
    private String bairro;

}

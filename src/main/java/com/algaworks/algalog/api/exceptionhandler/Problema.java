package com.algaworks.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Incluir mensagem de erro apenas para as propriedades não nulas. Se estiver nulo, simplesmente não mostre a mensagem de erro.

@JsonInclude(Include.NON_NULL) 
@Getter
@Setter
public class Problema {
    
    private Integer status;
    private LocalDateTime dataHora;
    private String título;
    private List<Campo> campos;

    @AllArgsConstructor
    @Getter
    public static class Campo {
    
        private String nome;
        private String mensagem;

    }

}

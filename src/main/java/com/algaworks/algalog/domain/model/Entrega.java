package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Declara propriamente a ligação com a classe cliente existente.
    @ManyToOne
    private Cliente cliente;
    
    // Declara que dentro dessa classe contém algumas variáveis que originalmente pertenceriam a classe atual, porém foram jogadas em uma classe separada para melhor organização.
    @Embedded 
    private Destinatario destinatario;

    private BigDecimal taxa;

    //  Declara que o enum que aparecerá na coluna será a opção selecionada em String, e não o índice dessa opção (Por exemplo, 1 = PENDENTE. EnumType.STRING mostraria o status PENDENTE ao invés do número 1).
    @Enumerated(EnumType.STRING) 
    private StatusEntrega status;

    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;
}

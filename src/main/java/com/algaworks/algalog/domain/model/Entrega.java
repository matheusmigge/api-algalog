package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.algaworks.algalog.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
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

    @Valid
    // O parâmetro passado em NotNull serve para bypassar o comportamento "Default" dessa anotação. Passamos uma interface vazia no lugar para ela se comportar de maneira diferente da padrão
    @ConvertGroup(from = Default.class, to = ValidationGroups.clienteId.class)
    @NotNull
    // Declara propriamente a ligação com a classe cliente existente.
    @ManyToOne
    private Cliente cliente;
    
    @NotNull
    @Valid
    // Declara que dentro dessa classe contém algumas variáveis que originalmente pertenceriam a classe atual, porém foram jogadas em uma classe separada para melhor organização.
    @Embedded 
    private Destinatario destinatario;

    @NotNull 
    private BigDecimal taxa;

    @JsonProperty(access = Access.READ_ONLY)
    //  Declara que o enum que aparecerá na coluna será a opção selecionada em String, e não o índice dessa opção (Por exemplo, 1 = PENDENTE. EnumType.STRING mostraria o status PENDENTE ao invés do número 1).
    @Enumerated(EnumType.STRING) 
    private StatusEntrega status;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime dataPedido;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime dataFinalizacao;
}

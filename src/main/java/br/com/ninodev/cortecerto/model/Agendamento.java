package br.com.ninodev.cortecerto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;
}

enum StatusAgendamento {
    PENDENTE, CONFIRMADO, CANCELADO, REALIZADO;
}
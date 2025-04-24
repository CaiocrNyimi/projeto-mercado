package br.com.fiap.projeto_mercado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @Pattern(regexp = "^(guerreiro|mago|arqueiro)$", message = "A classe deve ser guerreiro, mago ou arqueiro!")
    private String classe;

    @Min(value = 1, message = "O nível mínimo é 1!")
    @Max(value = 99, message = "O nível máximo é 99!")
    private int nivel;

    @PositiveOrZero(message = "O saldo deve ser positivo!")
    private double moedas;
}

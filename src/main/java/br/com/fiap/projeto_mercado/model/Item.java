package br.com.fiap.projeto_mercado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @Pattern(regexp = "^(arma|armadura|poção|acessório)$", message = "O item deve ser: arma, armadura, poção ou acessório!")
    private String tipo;

    @Pattern(regexp = "^(comum|raro|épico|lendário)$", message = "A raridade deve ser: comum, raro, épico ou lendário!")
    private String raridade;

    @Positive(message = "O preço deve ser positivo!")
    private double preco;

    @ManyToOne
    @JoinColumn(name = "nome_dono")
    private Personagem dono;
}

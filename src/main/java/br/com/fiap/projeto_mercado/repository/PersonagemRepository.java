package br.com.fiap.projeto_mercado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_mercado.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, String> {

    Optional<Personagem> findByNome(String nome);

}
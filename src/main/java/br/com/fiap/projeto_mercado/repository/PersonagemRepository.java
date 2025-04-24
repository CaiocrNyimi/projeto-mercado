package br.com.fiap.projeto_mercado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.fiap.projeto_mercado.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>, JpaSpecificationExecutor<Personagem> {

}
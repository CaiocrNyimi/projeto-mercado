package br.com.fiap.projeto_mercado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_mercado.model.Item;

public interface ItemRepository extends JpaRepository<Item, String> {

    Optional<Item> findByNome(String nome);

}
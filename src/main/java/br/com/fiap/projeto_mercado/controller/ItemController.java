package br.com.fiap.projeto_mercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_mercado.model.Item;
import br.com.fiap.projeto_mercado.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping()
    @Cacheable(value = "itens")
    public List<Item> index() {
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "itens", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@RequestBody @Valid Item item) {
        log.info("Cadastrando item " + item.getNome());
        return repository.save(item);
    }

    @PutMapping("{nome}")
    @CacheEvict(value = "itens", allEntries = true)
    public Item update(@PathVariable String nome, @RequestBody Item item) {
        log.info("Atualizando item " + nome + " " + item);
        getItem(nome);
        item.setNome(nome);
        return repository.save(item);
    }

    @DeleteMapping("{nome}")
    @CacheEvict(value = "itens", allEntries = true)
    public void destroy(@PathVariable String nome) {
        log.info("Apagando item " + nome);
        repository.delete(getItem(nome));
    }

    private Item getItem(String nome) {
        return repository
                .findByNome(nome)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Item " + nome + " não encontrado!"));
    }
}

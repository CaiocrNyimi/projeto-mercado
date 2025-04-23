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

import br.com.fiap.projeto_mercado.model.Personagem;
import br.com.fiap.projeto_mercado.repository.PersonagemRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/personagem")
@Slf4j
public class PersonagemController {

    @Autowired
    private PersonagemRepository repository;

    @GetMapping()
    @Cacheable(value = "personagens")
    public List<Personagem> index() {
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "personagens", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    public Personagem create(@RequestBody @Valid Personagem personagem) {
        log.info("Cadastrando personagem " + personagem.getNome());
        return repository.save(personagem);
    }

    @GetMapping("{nome}")
    public Personagem get(@PathVariable String nome) {
        log.info("Buscando personagem " + nome);
        return getPersonagem(nome);
    }

    @PutMapping("{nome}")
    @CacheEvict(value = "personagens", allEntries = true)
    public Personagem update(@PathVariable String nome, @RequestBody Personagem personagem) {
        log.info("Atualizando personagem " + nome + " " + personagem);
        getPersonagem(nome);
        personagem.setNome(nome);
        return repository.save(personagem);
    }

    @DeleteMapping("{nome}")
    @CacheEvict(value = "personagens", allEntries = true)
    public void destroy(@PathVariable String nome) {
        log.info("Apagando personagem " + nome);
        repository.delete(getPersonagem(nome));
    }

    private Personagem getPersonagem(String nome) {
        return repository
                .findByNome(nome)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Personagem " + nome + " não encontrado!"));
    }
}

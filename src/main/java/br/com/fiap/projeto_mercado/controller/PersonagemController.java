package br.com.fiap.projeto_mercado.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
import br.com.fiap.projeto_mercado.model.PersonagemFilter;
import br.com.fiap.projeto_mercado.repository.PersonagemRepository;
import br.com.fiap.projeto_mercado.specification.PersonagemSpecification;
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
    public Page<Personagem> index(PersonagemFilter filter,
            @PageableDefault(size = 10, sort = "nivel", direction = Direction.DESC) Pageable pageable) {
        return repository.findAll(PersonagemSpecification.withFilters(filter), pageable);
    }

    @PostMapping
    @CacheEvict(value = "personagens", allEntries = true)
    @ResponseStatus(HttpStatus.CREATED)
    public Personagem create(@RequestBody @Valid Personagem personagem) {
        log.info("Cadastrando personagem " + personagem.getId());
        return repository.save(personagem);
    }
    
    @PutMapping("{id}")
    @CacheEvict(value = "personagens", allEntries = true)
    public Personagem update(@PathVariable Long id, @RequestBody Personagem personagem) {
        log.info("Atualizando personagem " + id + " " + personagem);
        getPersonagem(id);
        personagem.setId(id);
        return repository.save(personagem);
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "personagens", allEntries = true)
    public void destroy(@PathVariable Long id) {
        log.info("Apagando personagem " + id);
        repository.delete(getPersonagem(id));
    }

    private Personagem getPersonagem(Long id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Personagem com id " + id + " não encontrado!"));
    }
}

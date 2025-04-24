package br.com.fiap.projeto_mercado.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.projeto_mercado.model.Item;
import br.com.fiap.projeto_mercado.model.ItemFilter;
import jakarta.persistence.criteria.Predicate;

public class ItemSpecification {
    
    public static Specification<Item> withFilters(ItemFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.nome() != null){
                predicates.add(cb.like(
                    cb.lower(root.get("nome")), "%" + filter.nome().toLowerCase() + "%"));
            }

            if (filter.tipo() != null){
                predicates.add(cb.like(
                    cb.lower(root.get("tipo")), "%" + filter.tipo().toLowerCase() + "%"));
            }

            if (filter.minPreco() != null && filter.maxPreco() != null) {
                predicates.add(
                    cb.between(root.get("preco"), filter.minPreco(), filter.maxPreco()));
            }
            
            if (filter.raridade() != null){
                predicates.add(cb.like(
                    cb.lower(root.get("raridade")), "%" + filter.raridade().toLowerCase() + "%"));
            }
            var arrayPredicates = predicates.toArray(new Predicate[0]);
            return cb.and(arrayPredicates);
        };

    }
}

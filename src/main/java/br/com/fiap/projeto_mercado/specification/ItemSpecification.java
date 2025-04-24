package br.com.fiap.projeto_mercado.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.projeto_mercado.model.Item;
import br.com.fiap.projeto_mercado.model.ItemFilter;

public class ItemSpecification {
    
    public static Specification<Item> withFilters(ItemFilter filter) {
        
    }
}

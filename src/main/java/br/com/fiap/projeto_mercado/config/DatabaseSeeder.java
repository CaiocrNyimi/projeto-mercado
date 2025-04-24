package br.com.fiap.projeto_mercado.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.projeto_mercado.model.Item;
import br.com.fiap.projeto_mercado.model.Personagem;
import br.com.fiap.projeto_mercado.repository.ItemRepository;
import br.com.fiap.projeto_mercado.repository.PersonagemRepository;
import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        var personagens = List.of(
                Personagem.builder().nome("Cebolinha").classe("guerreiro").nivel(1).moedas(0).build(),
                Personagem.builder().nome("Cascão").classe("guerreiro").nivel(2).moedas(5.20).build(),
                Personagem.builder().nome("Mônica").classe("guerreiro").nivel(3).moedas(10.50).build(),
                Personagem.builder().nome("Magali").classe("guerreiro").nivel(1).moedas(1.00).build(),
                Personagem.builder().nome("Chico Bento").classe("guerreiro").nivel(5).moedas(15.75).build(),
                Personagem.builder().nome("Rosinha").classe("guerreiro").nivel(4).moedas(12.30).build(),
                Personagem.builder().nome("Zé Lelé").classe("guerreiro").nivel(3).moedas(9.80).build(),
                Personagem.builder().nome("Hiro").classe("arqueiro").nivel(6).moedas(20.00).build(),
                Personagem.builder().nome("Carmem").classe("mago").nivel(7).moedas(25.50).build(),
                Personagem.builder().nome("Dudu").classe("guerreiro").nivel(2).moedas(7.10).build(),
                Personagem.builder().nome("Aninha").classe("mago").nivel(8).moedas(30.25).build(),
                Personagem.builder().nome("Titi").classe("arqueiro").nivel(5).moedas(18.90).build(),
                Personagem.builder().nome("Mané Garrincha").classe("guerreiro").nivel(9).moedas(35.60).build(),
                Personagem.builder().nome("Pelezinho").classe("guerreiro").nivel(10).moedas(40.00).build(),
                Personagem.builder().nome("Jairzinho").classe("guerreiro").nivel(8).moedas(32.15).build(),
                Personagem.builder().nome("Rivellino").classe("mago").nivel(11).moedas(45.75).build(),
                Personagem.builder().nome("Tostão").classe("arqueiro").nivel(7).moedas(28.40).build(),
                Personagem.builder().nome("Gérson").classe("guerreiro").nivel(9).moedas(37.90).build(),
                Personagem.builder().nome("Clodoaldo").classe("guerreiro").nivel(6).moedas(22.50).build(),
                Personagem.builder().nome("Carlos Alberto").classe("guerreiro").nivel(12).moedas(50.00).build(),
                Personagem.builder().nome("Amarildo").classe("guerreiro").nivel(5).moedas(17.60).build(),
                Personagem.builder().nome("Zagallo").classe("mago").nivel(10).moedas(42.80).build(),
                Personagem.builder().nome("Nilton Santos").classe("guerreiro").nivel(13).moedas(55.30).build(),
                Personagem.builder().nome("Garrincha").classe("arqueiro").nivel(9).moedas(39.10).build(),
                Personagem.builder().nome("Didi").classe("mago").nivel(12).moedas(48.50).build(),
                Personagem.builder().nome("Vavá").classe("guerreiro").nivel(11).moedas(44.20).build(),
                Personagem.builder().nome("Gilmar").classe("guerreiro").nivel(7).moedas(26.90).build(),
                Personagem.builder().nome("Zito").classe("guerreiro").nivel(10).moedas(41.00).build(),
                Personagem.builder().nome("Mauro").classe("guerreiro").nivel(8).moedas(30.70).build(),
                Personagem.builder().nome("Bellini").classe("guerreiro").nivel(14).moedas(60.00).build(),
                Personagem.builder().nome("Orlando").classe("guerreiro").nivel(6).moedas(21.40).build(),
                Personagem.builder().nome("Djalma Santos").classe("guerreiro").nivel(12).moedas(52.80).build(),
                Personagem.builder().nome("Pepe").classe("arqueiro").nivel(10).moedas(40.50).build(),
                Personagem.builder().nome("Coutinho").classe("guerreiro").nivel(9).moedas(36.30).build(),
                Personagem.builder().nome("Mengálvio").classe("mago").nivel(11).moedas(47.10).build(),
                Personagem.builder().nome("SANTOS Dumont").classe("mago").nivel(25).moedas(1000.00).build(),
                Personagem.builder().nome("Machado de Assis").classe("mago").nivel(20).moedas(800.50).build(),
                Personagem.builder().nome("Cecília Meireles").classe("mago").nivel(18).moedas(700.25).build(),
                Personagem.builder().nome("Carlos Drummond de Andrade").classe("mago").nivel(22).moedas(900.75).build(),
                Personagem.builder().nome("Vinicius de Moraes").classe("mago").nivel(19).moedas(750.00).build(),
                Personagem.builder().nome("Tom Jobim").classe("mago").nivel(23).moedas(950.50).build(),
                Personagem.builder().nome("Chiquinha Gonzaga").classe("mago").nivel(17).moedas(650.20).build(),
                Personagem.builder().nome("Pixinguinha").classe("mago").nivel(21).moedas(850.80).build(),
                Personagem.builder().nome("Villa-Lobos").classe("mago").nivel(24).moedas(980.00).build(),
                Personagem.builder().nome("Oscar Niemeyer").classe("mago").nivel(26).moedas(1050.30).build(),
                Personagem.builder().nome("Lina Bo Bardi").classe("mago").nivel(20).moedas(820.90).build(),
                Personagem.builder().nome("Ayrton Senna").classe("guerreiro").nivel(30).moedas(1500.00).build(),
                Personagem.builder().nome("Gustavo Kuerten").classe("guerreiro").nivel(28).moedas(1300.75).build(),
                Personagem.builder().nome("Ronaldo Fenômeno").classe("guerreiro").nivel(35).moedas(2000.50).build(),
                Personagem.builder().nome("Pelé").classe("guerreiro").nivel(40).moedas(2500.00).build(),
                Personagem.builder().nome("Zico").classe("arqueiro").nivel(32).moedas(1700.25).build(),
                Personagem.builder().nome("Sócrates").classe("mago").nivel(33).moedas(1800.90).build(),
                Personagem.builder().nome("Romário").classe("guerreiro").nivel(38).moedas(2200.60).build(),
                Personagem.builder().nome("Cafu").classe("guerreiro").nivel(29).moedas(1400.10).build(),
                Personagem.builder().nome("Roberto Carlos").classe("arqueiro").nivel(31).moedas(1600.80).build(),
                Personagem.builder().nome("Kaká").classe("mago").nivel(34).moedas(1900.30).build(),
                Personagem.builder().nome("Ronaldinho Gaúcho").classe("arqueiro").nivel(37).moedas(2100.00).build(),
                Personagem.builder().nome("Neymar Jr").classe("arqueiro").nivel(36).moedas(2050.40).build(),
                Personagem.builder().nome("Marta Vieira da Silva").classe("guerreiro").nivel(39).moedas(2300.70)
                        .build(),
                Personagem.builder().nome("Rei Charles III").classe("guerreiro").nivel(15).moedas(7000000.00).build(),
                Personagem.builder().nome("Rainha Elizabeth II").classe("mago").nivel(99).moedas(9999999.99).build(),
                Personagem.builder().nome("Príncipe William").classe("arqueiro").nivel(28).moedas(5000000.50).build(),
                Personagem.builder().nome("Kate Middleton").classe("guerreiro").nivel(25).moedas(4500000.25).build(),
                Personagem.builder().nome("Príncipe Harry").classe("arqueiro").nivel(27).moedas(4000000.75).build(),
                Personagem.builder().nome("Meghan Markle").classe("mago").nivel(26).moedas(3500000.00).build(),
                Personagem.builder().nome("Princesa Anne").classe("guerreiro").nivel(29).moedas(5500000.10).build(),
                Personagem.builder().nome("Príncipe Edward").classe("mago").nivel(24).moedas(3000000.80).build(),
                Personagem.builder().nome("Sophie Rhys-Jones").classe("arqueiro").nivel(23).moedas(2500000.30).build(),
                Personagem.builder().nome("Príncipe Andrew").classe("guerreiro").nivel(22).moedas(2000000.00).build(),
                Personagem.builder().nome("Beatrice de York").classe("mago").nivel(21).moedas(1500000.50).build(),
                Personagem.builder().nome("Eugenie de York").classe("arqueiro").nivel(20).moedas(1000000.25).build(),
                Personagem.builder().nome("Zara Tindall").classe("guerreiro").nivel(19).moedas(900000.75).build(),
                Personagem.builder().nome("Mike Tindall").classe("guerreiro").nivel(18).moedas(800000.00).build(),
                Personagem.builder().nome("Peter Phillips").classe("arqueiro").nivel(17).moedas(700000.50).build(),
                Personagem.builder().nome("Autumn Phillips").classe("mago").nivel(16).moedas(600000.25).build(),
                Personagem.builder().nome("Lady Louise Windsor").classe("arqueiro").nivel(15).moedas(500000.75).build(),
                Personagem.builder().nome("James, Visconde Severn").classe("guerreiro").nivel(14).moedas(400000.00)
                        .build(),
                Personagem.builder().nome("Savannah Phillips").classe("mago").nivel(13).moedas(300000.50).build(),
                Personagem.builder().nome("Isla Phillips").classe("arqueiro").nivel(12).moedas(200000.25).build(),
                Personagem.builder().nome("Mia Tindall").classe("guerreiro").nivel(11).moedas(100000.75).build(),
                Personagem.builder().nome("Lena Tindall").classe("guerreiro").nivel(10).moedas(90000.00).build(),
                Personagem.builder().nome("August Brooksbank").classe("arqueiro").nivel(9).moedas(80000.50).build(),
                Personagem.builder().nome("Sienna Mapelli Mozzi").classe("mago").nivel(8).moedas(70000.25).build(),
                Personagem.builder().nome("Lucas Tindall").classe("arqueiro").nivel(7).moedas(60000.75).build(),
                Personagem.builder().nome("Ernest Brooksbank").classe("guerreiro").nivel(6).moedas(50000.00).build(),
                Personagem.builder().nome("Lilibet Mountbatten-Windsor").classe("mago").nivel(5).moedas(40000.50)
                        .build(),
                Personagem.builder().nome("Archie Mountbatten-Windsor").classe("arqueiro").nivel(4).moedas(30000.25)
                        .build(),
                Personagem.builder().nome("George de Cambridge").classe("guerreiro").nivel(3).moedas(20000.75).build(),
                Personagem.builder().nome("Charlotte de Cambridge").classe("mago").nivel(2).moedas(10000.00).build(),
                Personagem.builder().nome("Louis de Cambridge").classe("arqueiro").nivel(1).moedas(5000.50).build());

        personagemRepository.saveAll(personagens);

        var itens = List.of(
                Item.builder().nome("Espada Curta").tipo("arma").raridade("comum").preco(25.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Cebolinha")).findFirst()
                                .orElse(null))
                        .build(),
                Item.builder().nome("Armadura de Couro").tipo("armadura").raridade("comum").preco(40.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Cascão")).findFirst().orElse(null))
                        .build(),
                Item.builder().nome("Poção de Cura Menor").tipo("poção").raridade("comum").preco(10.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Mônica")).findFirst().orElse(null))
                        .build(),
                Item.builder().nome("Amuleto da Sorte").tipo("acessório").raridade("épico").preco(75.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Magali")).findFirst().orElse(null))
                        .build(),
                Item.builder().nome("Arco Simples").tipo("arma").raridade("comum").preco(30.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Chico Bento")).findFirst()
                                .orElse(null))
                        .build(),
                Item.builder().nome("Cota de Malha").tipo("armadura").raridade("raro").preco(120.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Rosinha")).findFirst().orElse(null))
                        .build(),
                Item.builder().nome("Poção de Mana Pequena").tipo("poção").raridade("comum").preco(12.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Zé Lelé")).findFirst().orElse(null))
                        .build(),
                Item.builder().nome("Anel de Agilidade").tipo("acessório").raridade("lendário").preco(90.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Hiro")).findFirst().orElse(null))
                        .build(),
                Item.builder().nome("Cajado de Madeira").tipo("arma").raridade("comum").preco(20.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Carmem")).findFirst().orElse(null))
                        .build(),
                Item.builder().nome("Escudo de Madeira").tipo("armadura").raridade("comum").preco(35.00)
                        .dono(personagens.stream().filter(p -> p.getNome().equals("Dudu")).findFirst().orElse(null))
                        .build());
        itemRepository.saveAll(itens);
        System.out.println(itens.size() + " itens semeados.");
    }
}
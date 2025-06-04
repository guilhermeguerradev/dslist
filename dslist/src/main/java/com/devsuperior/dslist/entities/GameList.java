package com.devsuperior.dslist.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity // Indica que essa classe é uma entidade JPA (será mapeada para uma tabela no banco)
@Table(name = "tb_game_list") // Define explicitamente o nome da tabela como "tb_game_list"
public class GameList {

    @Id // Define o campo "id" como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz o banco gerar o ID automaticamente (auto incremento)
    private Long id;

    private String name; // Nome da lista de jogos (ex: "Favoritos", "RPGs", "Lançamentos")

    // Construtor padrão (necessário para o JPA)
    public GameList () {
    }

    // Construtor com parâmetros, útil para instanciar objetos manualmente
    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters e setters: permitem acessar e modificar os atributos da entidade
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // equals() e hashCode() são usados para comparar objetos corretamente,
    // especialmente em coleções como listas ou conjuntos.
    // Aqui, a comparação é baseada no ID da lista.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameList gameList = (GameList) o;
        return Objects.equals(id, gameList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

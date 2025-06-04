package com.devsuperior.dslist.entities;

// Anotações para mapeamento JPA/Hibernate
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity // Indica que esta classe é uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados.
@Table(name = "tb_belonging") // Define o nome da tabela correspondente no banco de dados.
public class Belonging {

    // Chave composta que combina Game + GameList (representada pela classe BelongingPK)
    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    // Posição do jogo dentro da lista (usado para ordenação)
    private Integer position;

    // Construtor padrão (necessário para o JPA)
    public Belonging() {
    }

    // Construtor que já recebe o jogo, a lista e a posição como parâmetros
    public Belonging(Game game, GameList list, Integer position) {
        // Define os componentes da chave composta
        id.setGame(game);
        id.setList(list);

        // Define a posição do jogo dentro da lista
        this.position = position;
    }

    // Getter e Setter da chave composta
    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    // Getter e Setter da posição
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    // Métodos equals e hashCode baseados na chave composta (id)
    // Importantes para garantir o correto funcionamento em coleções e comparações
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable // Indica que esta classe será usada como parte da chave primária de outra entidade (composição).
public class BelongingPK {

    // Muitos pertencimentos (Belonging) podem estar associados a um mesmo jogo (Game)
    @ManyToOne
    @JoinColumn(name = "game_id") // Nome da coluna no banco que representa a foreign key para Game
    private Game game;

    // Muitos pertencimentos podem estar associados a uma mesma lista (GameList)
    @ManyToOne
    @JoinColumn(name = "list_id") // Nome da coluna no banco que representa a foreign key para GameList
    private GameList list;

    // Construtor padrão (obrigatório para o JPA)
    public BelongingPK() {
    }

    // Construtor com parâmetros para facilitar a criação do objeto
    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    // Getters e Setters
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    // Implementações de equals() e hashCode() são fundamentais em classes de chave composta,
    // pois o JPA precisa dessas operações para gerenciar entidades corretamente
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BelongingPK that = (BelongingPK) o;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}

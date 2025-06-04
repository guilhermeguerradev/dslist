package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/*
 * Repositório responsável por acessar os dados da entidade GameList no banco de dados.
 * Interface que estende JpaRepository, o que já fornece automaticamente métodos prontos como:
 * - findAll(), findById(), save(), deleteById(), etc.
 */
public interface GameListRepository extends JpaRepository<GameList, Long> {

    /*
     * Método personalizado para atualizar a posição de um jogo dentro de uma lista.
     *
     * Anotações:
     * - @Modifying: indica que a query vai modificar o banco (UPDATE, INSERT ou DELETE)
     * - @Query: define a SQL nativa a ser executada
     *
     * Essa query atualiza a coluna `position` da tabela `tb_belonging` com base nos IDs da lista e do jogo.
     */
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}

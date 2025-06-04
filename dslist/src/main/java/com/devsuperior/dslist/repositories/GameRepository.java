package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 * GameRepository
 *
 * Interface responsável por acessar os dados da entidade Game no banco de dados.
 * Estende JpaRepository, o que fornece automaticamente métodos prontos para CRUD:
 * - findAll(), findById(), save(), deleteById(), etc.
 *
 * Também permite definir consultas personalizadas usando @Query.
 */
public interface GameRepository extends JpaRepository<Game, Long> {

	/*
	 * Consulta nativa (SQL puro) para retornar jogos de uma lista específica,
	 * com os dados mínimos necessários para exibir em uma listagem.
	 *
	 * O resultado será mapeado para a interface `GameMinProjection`.
	 *
	 * - Faz um JOIN entre `tb_game` e `tb_belonging` (tabela que associa jogos às listas)
	 * - Filtra pelo `list_id` recebido por parâmetro
	 * - Ordena os jogos conforme a posição definida na lista
	 */
	@Query(nativeQuery = true, value = """
        SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
               tb_game.short_description AS shortDescription, tb_belonging.position
        FROM tb_game
        INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
        WHERE tb_belonging.list_id = :listId
        ORDER BY tb_belonging.position
    """)
	List<GameMinProjection> searchByList(Long listId);
}

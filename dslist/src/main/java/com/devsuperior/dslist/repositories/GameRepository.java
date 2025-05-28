package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    /*
     * Camada de acesso a dados (Data Access Layer - DAL)
     * Responsável por realizar operações diretas com o banco de dados:
     * - Consultas (SELECT)
     * - Inserções (INSERT)
     * - Atualizações (UPDATE)
     * - Exclusões (DELETE)
     *
     * Essa camada isola a lógica de acesso ao banco de dados da camada de serviço (Service Layer),
     * promovendo melhor organização e manutenção do código.
     */

}

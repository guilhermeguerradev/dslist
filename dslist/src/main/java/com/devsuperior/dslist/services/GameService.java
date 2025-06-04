package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMiniDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
// Indica que esta classe é um componente gerenciado pelo Spring.
// Isso permite que ela seja injetada automaticamente em outras partes do sistema (como nos controllers).
public class GameService {

    /*
     * Camada de serviço (Service Layer)
     *
     * Responsável por implementar regras de negócio, orquestrar chamadas aos repositórios
     * e transformar os dados antes de devolvê-los aos controladores (controllers).
     *
     * Aqui o serviço se comunica com o GameRepository (camada de acesso a dados)
     * e devolve DTOs para serem usados na camada de apresentação (API).
     */

    @Autowired
    private GameRepository gameRepository; // Injeção automática do repositório de jogos

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        // Busca um jogo pelo ID no banco de dados
        Game result = gameRepository.findById(id).get();

        // Constrói um DTO com os dados da entidade encontrada
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMiniDTO> findAll() {
        // Busca todos os jogos da tabela
        List<Game> result = gameRepository.findAll();

        // Converte cada Game em GameMiniDTO (versão resumida para listagem)
        List<GameMiniDTO> dto = result.stream().map(x -> new GameMiniDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMiniDTO> findByList(Long listId) {
        // Executa a query customizada que busca os jogos de uma lista específica,
        // retornando apenas os dados necessários (usando a projeção GameMinProjection)
        List<GameMinProjection> result = gameRepository.searchByList(listId);

        // Converte a projeção para GameMiniDTO
        List<GameMiniDTO> dto = result.stream().map(x -> new GameMiniDTO(x)).toList();
        return dto;
    }
}

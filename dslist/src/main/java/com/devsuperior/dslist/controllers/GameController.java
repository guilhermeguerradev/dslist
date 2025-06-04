package com.devsuperior.dslist.controllers;

// Importa as classes necessárias para trabalhar com DTOs, entidades, serviços e anotações do Spring.
import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMiniDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;

import org.springframework.beans.factory.annotation.Autowired; // Para injeção automática de dependência
import org.springframework.web.bind.annotation.GetMapping;  // Mapeia requisições GET
import org.springframework.web.bind.annotation.PathVariable; // Permite capturar variáveis da URL
import org.springframework.web.bind.annotation.RequestMapping; // Define o caminho base da API
import org.springframework.web.bind.annotation.RestController; // Marca a classe como um controlador REST

import java.util.List; // Importa lista para retorno múltiplo de objetos

// Esta classe é responsável por expor endpoints da aplicação para o mundo externo.
// É a "porta de entrada" do back-end, permitindo que clientes (como front-end ou apps) façam requisições HTTP.
@RestController // Indica que esta classe é um controlador REST (retorna JSON ao invés de páginas HTML).
@RequestMapping(value = "/games") // Define o caminho base dos endpoints deste controlador (ex: /games).
public class GameController {

    @Autowired // Injeta automaticamente uma instância do GameService (injeção de dependência).
    private GameService gameService;

    // Endpoint para buscar um jogo específico por ID
    @GetMapping(value = "/{id}") // Mapeia requisições GET para /games/{id}
    public GameDTO findById(@PathVariable Long id) {
        // Chama o serviço passando o ID e obtém um DTO com os dados do jogo
        GameDTO result = gameService.findById(id);

        // Retorna o DTO como resposta (em JSON)
        return result;
    }

    // Endpoint para retornar todos os jogos (versão resumida)
    @GetMapping // Mapeia requisições HTTP GET para o método abaixo (ex: GET /games)
    public List<GameMiniDTO> findAll() {
        // Chama o serviço para buscar todos os jogos em formato resumido (MiniDTO)
        List<GameMiniDTO> result = gameService.findAll();

        // Retorna a lista como resposta da API (Spring automaticamente converte para JSON)
        return result;
    }
}

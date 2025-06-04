package com.devsuperior.dslist.controllers;

// Importa as classes de DTOs e serviços usados pelo controlador
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMiniDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

import org.springframework.beans.factory.annotation.Autowired; // Para injeção de dependência
import org.springframework.web.bind.annotation.*; // Importa todas as anotações REST (Get, Post, PathVariable etc)
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List; // Importa o tipo List para listas de objetos

// Define que esta classe é um controlador REST (responde com JSON em vez de HTML).
@RestController
// Define o caminho base dos endpoints desse controlador. Ex: /lists
@RequestMapping(value = "/lists")
public class GameListController {

    // Injeta automaticamente a instância de GameListService
    @Autowired
    private GameListService gameListService;

    // Injeta automaticamente a instância de GameService
    @Autowired
    private GameService gameService;

    // Endpoint GET para retornar todas as listas de jogos
    @GetMapping
    public List<GameListDTO> findAll() {
        // Chama o serviço para buscar todas as listas e retorna como JSON
        return gameListService.findAll();
    }

    // Endpoint GET para retornar todos os jogos de uma lista específica
    @GetMapping(value = "/{listId}/games") // Ex: /lists/1/games
    public List<GameMiniDTO> findByList(@PathVariable Long listId) {
        // Usa o GameService para buscar jogos associados a uma lista pelo ID
        List<GameMiniDTO> result = gameService.findByList(listId);
        return result;
    }

    // Endpoint POST para mover um jogo de posição dentro da lista
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        // Chama o serviço para mover o jogo dentro da lista com base nos índices enviados no corpo da requisição
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}

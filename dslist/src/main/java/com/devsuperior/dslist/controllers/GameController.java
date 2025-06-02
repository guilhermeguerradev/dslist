package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMiniDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Esta classe é responsável por expor endpoints da aplicação para o mundo externo.
// É a "porta de entrada" do back-end, permitindo que clientes (como front-end ou apps) façam requisições HTTP.
@RestController // Indica que esta classe é um controlador REST (retorna JSON ao invés de páginas HTML).
@RequestMapping(value = "/games") // Define o caminho base dos endpoints deste controlador (ex: /games).
public class GameController {

    @Autowired // Injeta automaticamente uma instância do GameService (injeção de dependência).
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping // Mapeia requisições HTTP GET para o método abaixo (ex: GET /games).
    public List<GameMiniDTO> findAll() {
        // Chama o serviço para buscar todos os jogos
        List<GameMiniDTO> result = gameService.findAll();

        // Retorna a lista como resposta da API (Spring automaticamente converte para JSON)
        return result;
    }
}

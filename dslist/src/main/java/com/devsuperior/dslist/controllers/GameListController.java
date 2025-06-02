package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Define que esta classe é um controlador REST (responde com JSON).
@RequestMapping(value = "/lists") // Define o caminho base dos endpoints desse controlador.
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        // Retorna a lista de GameListDTOs buscando via serviço.
        return gameListService.findAll();
    }
}

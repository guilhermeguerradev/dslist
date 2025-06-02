package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
// Marca essa classe como um componente gerenciado pelo Spring (um "bean").
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        // Busca todos os registros da tabela de listas de games no banco.
        List<GameList> result = gameListRepository.findAll();

        // Converte a lista de GameList para uma lista de GameListDTO.
        return result.stream().map(GameListDTO::new).toList();
    }
}

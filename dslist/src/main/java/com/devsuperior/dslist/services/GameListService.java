package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
// Marca essa classe como um componente Spring (um "bean"), que pode ser injetado em outros lugares.
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository; // Responsável por acessar os dados das listas

    @Autowired
    private GameRepository gameRepository; // Responsável por acessar os dados dos jogos

    @Transactional(readOnly = true) // Indica que esta transação é de leitura (melhora desempenho)
    public List<GameListDTO> findAll() {
        // Busca todas as listas de jogos no banco de dados
        List<GameList> result = gameListRepository.findAll();

        // Converte cada GameList em GameListDTO (transformação de entidade em DTO)
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional // Aqui é necessário permitir escrita, pois atualiza posições no banco
    public void move(long listId, int sourceIndex, int destinationIndex) {
        // Busca todos os jogos da lista (em versão simplificada) e já ordenados pela posição
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        // Remove o jogo da posição original
        GameMinProjection obj = list.remove(sourceIndex);

        // Adiciona o jogo na nova posição
        list.add(destinationIndex, obj);

        // Determina o intervalo que será atualizado (para evitar atualizar toda a lista desnecessariamente)
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        // Atualiza a posição de cada jogo dentro do intervalo afetado
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}

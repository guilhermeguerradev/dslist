package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMiniDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
// Indica que esta classe é um componente do Spring.
// O Spring irá detectar automaticamente esta classe durante o scan de componentes
// e registrá-la como um bean no contexto da aplicação, permitindo a injeção de dependência.

public class GameService {
    /*
     * Camada de serviço (Service Layer)
     *
     * Um serviço é um componente que encapsula a lógica de negócio da aplicação.
     * É responsável por aplicar as regras que definem o funcionamento do domínio da aplicação,
     * incluindo:
     * - Validações de dados
     * - Cálculos e regras de negócio
     * - Orquestração de chamadas a repositórios e outros serviços
     * - Manipulação e transformação de dados antes de retornar a resposta
     *
     * A camada de serviço atua como intermediária entre os controladores (Controllers) e
     * a camada de acesso a dados (Repositories/DAOs), promovendo separação de responsabilidades.
     */

    @Autowired
    private GameRepository gameRepository; // Injeção de dependência do GameRepository no GameService.
    // O GameService é um componente que depende do GameRepository (camada de acesso a dados).
    // O Spring injeta automaticamente uma instância do GameRepository aqui, sem a necessidade de criá-la manualmente.
    // Isso permite que os componentes "se componham" e sigam o princípio da inversão de dependência,
    // promovendo um design desacoplado e mais fácil de testar.

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMiniDTO> findAll() {

        // Primeiro, buscamos todos os registros da tabela de games no banco de dados.
        // O método findAll() retorna uma lista de objetos do tipo Game.
        List<Game> result = gameRepository.findAll();

        // Em seguida, pegamos essa lista de Game e transformamos em uma lista de GameMiniDTO.
        // Usamos stream() para percorrer a lista, map() para criar um novo GameMiniDTO para cada Game,
        // e toList() para coletar tudo de volta em uma nova lista.
        List<GameMiniDTO> dto = result.stream().map(x -> new GameMiniDTO(x)).toList();
        return dto;
    }

}

package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMiniDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public List<GameMiniDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMiniDTO> dto = result.stream().map(x -> new GameMiniDTO(x)).toList();
        return dto;
    }

}

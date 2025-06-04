package com.devsuperior.dslist.dto;

// Importa a entidade GameList, da qual os dados serão copiados
import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {

    // Atributos do DTO que representam os dados da entidade GameList
    private Long id;
    private String name;

    // Construtor padrão (necessário para frameworks como o Spring)
    public GameListDTO() {
    }

    // Construtor que recebe um objeto GameList e copia seus dados para o DTO
    public GameListDTO(GameList entity) {
        this.id = entity.getId();     // Copia o ID da entidade para o DTO
        this.name = entity.getName(); // Copia o nome da entidade para o DTO
    }

    // Getters (não precisa de setters se os dados não forem modificados depois de criados)

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

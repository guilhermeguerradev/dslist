package com.devsuperior.dslist.dto;

// Importa a entidade Game, usada para popular o DTO
import com.devsuperior.dslist.entities.Game;

// Importa a projeção personalizada usada para otimizar consultas específicas
import com.devsuperior.dslist.projections.GameMinProjection;

public class GameMiniDTO {

    /*
     * GameMiniDTO
     *
     * DTO (Data Transfer Object) usado para representar uma versão simplificada dos dados de um jogo.
     * Ideal para listagens ou exibições resumidas, onde não é necessário retornar todas as informações do jogo.
     * Reduz o tráfego de dados entre o backend e o frontend e melhora a performance.
     */

    // Atributos principais do jogo usados na versão "mini"
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    // Construtor padrão, necessário para frameworks como Spring instanciar o objeto
    public GameMiniDTO() {
    }

    // Construtor que recebe um objeto Game (entidade completa) e extrai os dados principais
    public GameMiniDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    // Construtor que recebe uma projeção (consulta personalizada vinda do banco com SQL otimizado)
    public GameMiniDTO(GameMinProjection projection) {
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.year = projection.getGameYear(); // Note que o nome pode ser diferente do campo original
        this.imgUrl = projection.getImgUrl();
        this.shortDescription = projection.getShortDescription();
    }

    // Métodos de acesso (getters). Não há setters pois o DTO é usado apenas para leitura
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}

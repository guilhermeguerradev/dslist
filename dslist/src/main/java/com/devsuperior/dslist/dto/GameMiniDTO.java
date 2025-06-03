package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public class GameMiniDTO {

    /*
     * GameMiniDTO
     *
     * Data Transfer Object (DTO) usado para representar uma versão simplificada dos dados de um jogo.
     *
     * Este DTO é útil quando se deseja transferir apenas informações básicas de um jogo,
     * por exemplo, em listagens ou visualizações resumidas, evitando a exposição de dados desnecessários.
     *
     * contém atributos essenciais como: id, nome ou outros campos resumidos.
     */


    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMiniDTO() {
    }

    public GameMiniDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public GameMiniDTO(GameMinProjection projection) {
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.year = projection.getGameYear();
        this.imgUrl = projection.getImgUrl();
        this.shortDescription = projection.getShortDescription();
    }

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

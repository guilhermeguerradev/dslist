package com.devsuperior.dslist.dto;

// Importa a entidade Game, da qual vamos copiar os dados
import com.devsuperior.dslist.entities.Game;

// Importa utilitário do Spring que copia propriedades entre objetos automaticamente
import org.springframework.beans.BeanUtils;

public class GameDTO {

    // Atributos do DTO que representam os dados que serão enviados na resposta da API
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    // Construtor padrão (necessário para frameworks como o Spring instanciar o objeto)
    public GameDTO() {
    }

    // Construtor que recebe uma entidade Game e copia os dados dela para o DTO
    public GameDTO(Game entity) {
        // Copia automaticamente os dados da entidade 'entity' para o objeto atual (this)
        // Isso evita escrever manualmente: this.title = entity.getTitle(); etc.
        BeanUtils.copyProperties(entity, this);
    }

    // Métodos getters e setters: permitem acessar e modificar os dados do DTO
    // São importantes para a serialização e desserialização dos objetos JSON

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}

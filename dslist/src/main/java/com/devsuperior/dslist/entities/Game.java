package com.devsuperior.dslist.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity  // Diz ao JPA que essa classe será mapeada como uma tabela no banco de dados
@Table(name = "tb_game") // Define o nome da tabela como "tb_game"
public class Game {

    @Id // Define o campo "id" como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz o banco gerar o ID automaticamente (auto incremento)
    private Long id;

    private String title;

    @Column(name = "game_year") // Renomeia a coluna no banco para "game_year" (evita conflito com a palavra reservada "year")
    private Integer year;

    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT") // Define o tipo da coluna como TEXT (aceita textos grandes)
    private String shortDescription;

    @Column(columnDefinition = "TEXT") // Também define como TEXT para textos longos
    private String longDescription;

    public Game() {
    }

    public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

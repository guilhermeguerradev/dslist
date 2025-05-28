package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity  // Configura Classe Java para que ela seja equivalente a uma tabela do banco relacional
@Table(name = "tb_game") // Customizar tabela do banco
public class Game {

    @Id // Configurando Id como chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para o id ser auto incrementado pelo banco // Forma que ele vai indicar pra o banco gerar o ID;
    private Long id;
    private String title;

    @Column(name = "game_year") // Palavra Year, palavra reservado do Sql, mudei o nome do campo la no banco para game_year
    private Integer year;
    private String genre;
    private String platform;
    private String imgUrl;
    private String shorDescription;
    private String longDescription;


    public Game() {
    }

    public Game(Long id, String title, Integer year, String genre, String platform, String imgUrl, String shorDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platform = platform;
        this.imgUrl = imgUrl;
        this.shorDescription = shorDescription;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShorDescription() {
        return shorDescription;
    }

    public void setShorDescription(String shorDescription) {
        this.shorDescription = shorDescription;
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

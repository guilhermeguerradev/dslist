package com.devsuperior.dslist.entities;

import jakarta.persistence.*; // Importa as anotações JPA
import java.util.Objects;

@Entity // Informa ao JPA que esta classe representa uma entidade no banco de dados
@Table(name = "tb_game") // Define explicitamente o nome da tabela como "tb_game"
public class Game {

    @Id // Marca o campo "id" como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do ID será gerado automaticamente pelo banco (auto-incremento)
    private Long id;

    private String title;

    @Column(name = "game_year") // Define o nome da coluna no banco como "game_year" (evita conflito com "year", palavra reservada em alguns bancos)
    private Integer year;

    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    // Define as colunas como tipo TEXT no banco (ideal para textos grandes)
    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    // Construtor padrão (necessário para o JPA instanciar objetos)
    public Game() {
    }

    // Construtor completo para facilitar criação manual de objetos Game
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

    // Getters e Setters para acessar e modificar os campos da entidade

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

    // equals e hashCode são usados para comparar objetos e em estruturas como HashSet ou HashMap.
    // Baseados no ID para garantir que dois jogos com o mesmo ID sejam considerados iguais.
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

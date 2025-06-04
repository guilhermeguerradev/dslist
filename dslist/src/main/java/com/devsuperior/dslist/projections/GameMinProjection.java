package com.devsuperior.dslist.projections;

/*
 * GameMinProjection
 *
 * Essa interface representa uma "projeção" de dados no Spring Data JPA.
 * Ela serve para **consultas SQL personalizadas (nativas ou JPQL)** que retornam
 * apenas parte dos dados de uma entidade — ideal para performance em listagens.
 *
 * O Spring usa o nome dos métodos (getters) para mapear automaticamente os campos
 * retornados pela query SQL para os atributos da projeção.
 */
public interface GameMinProjection {

    // Cada método abaixo corresponde a uma coluna retornada pela consulta SQL

    Long getId(); // ID do jogo
    String getTitle(); // Título do jogo
    Integer getGameYear(); // Ano do jogo (rebatizado na query como "gameYear")
    String getImgUrl(); // URL da imagem
    String getShortDescription(); // Descrição resumida
    Integer getPosition(); // Posição do jogo na lista (caso use ordenação)

}

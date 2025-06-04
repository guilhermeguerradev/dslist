package com.devsuperior.dslist.dto;

/*
 * ReplacementDTO
 *
 * DTO usado para representar a operação de troca de posição entre dois elementos
 * de uma lista de jogos. Ele é utilizado, por exemplo, quando o usuário deseja
 * reordenar os jogos arrastando um item da lista para uma nova posição.
 *
 * A requisição POST envia esse DTO no corpo da requisição (JSON), contendo:
 * - sourceIndex: posição original do item
 * - destinationIndex: nova posição desejada
 */

public class ReplacementDTO {

    // Índice de origem (posição atual do item na lista)
    private Integer sourceIndex;

    // Índice de destino (nova posição desejada)
    private Integer destinationIndex;

    // Getters e Setters permitem que o Spring converta o JSON da requisição
    // para esse objeto e também permite acessar seus valores posteriormente

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }
}

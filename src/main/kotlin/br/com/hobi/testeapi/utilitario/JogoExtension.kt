package br.com.hobi.testeapi.utilitario

import br.com.hobi.testeapi.modelo.InfoJogoJson
import br.com.hobi.testeapi.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}
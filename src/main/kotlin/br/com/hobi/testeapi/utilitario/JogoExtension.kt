package br.com.hobi.testeapi.utilitario

import br.com.hobi.testeapi.dados.JogoEntity
import br.com.hobi.testeapi.modelo.InfoJogoJson
import br.com.hobi.testeapi.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}
package br.com.hobi.testeapi.utilitario

import br.com.hobi.testeapi.dados.GamerEntity
import br.com.hobi.testeapi.modelo.Gamer
import br.com.hobi.testeapi.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.id, this.nome, this.email, this.dataNascimento, this.usuario, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}
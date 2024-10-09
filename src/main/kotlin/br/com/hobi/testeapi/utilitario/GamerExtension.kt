package br.com.hobi.testeapi.utilitario

import br.com.hobi.testeapi.modelo.Gamer
import br.com.hobi.testeapi.modelo.InfoGamerJson

fun InfoGamerJson.criarGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}
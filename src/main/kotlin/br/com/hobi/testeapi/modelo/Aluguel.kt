package br.com.hobi.testeapi.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo){

    val valorDoAluguel = jogo.preco * periodo.emDias

    override fun toString(): String {
        return "\nAluguel do ${jogo.titulo} por ${gamer.nome} pelo valor R$ $valorDoAluguel"
    }
}

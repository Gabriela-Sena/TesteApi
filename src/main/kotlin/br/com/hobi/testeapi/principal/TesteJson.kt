package br.com.hobi.testeapi.principal

import br.com.hobi.testeapi.modelo.Periodo
import br.com.hobi.testeapi.servicos.ConsumoApi
import java.time.LocalDate

fun main(){

    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
   // val jogoApi = consumo.buscaJogo("151")
    val listaJogosJson = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(listaJogosJson)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogosJson.get(10)

    println(gamerCaroline)
    println(jogoResidentVillage)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))

    val aluguel = gamerCaroline.alugaJogo(jogoResidentVillage, periodo)
    println(aluguel)
}
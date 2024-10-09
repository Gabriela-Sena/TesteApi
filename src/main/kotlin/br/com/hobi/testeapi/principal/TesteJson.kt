package br.com.hobi.testeapi.principal

import br.com.hobi.testeapi.servicos.ConsumoApi

fun main(){

    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
   // val jogoApi = consumo.buscaJogo("151")
    val listaJogosJson = consumo.buscaJogosJson()

    println(listaGamers)
    println(listaJogosJson)
}
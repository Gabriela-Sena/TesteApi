package br.com.hobi.testeapi.principal

import br.com.hobi.testeapi.modelo.Periodo
import br.com.hobi.testeapi.modelo.PlanoAssinatura
import br.com.hobi.testeapi.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
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
    val jogoSpider = listaJogosJson.get(13)
    val jogoTheLastOfUs = listaJogosJson.get(2)

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)

    //println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamers.get(5)
    //gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3)

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpider, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)

    //println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    println(gamerCamila.jogosAlugados)


    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCaroline.recomendarJogo(jogoResidentVillage, 8)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 9)

    println(gamerCamila.jogosRecomendados)
    println(gamerCaroline.jogosRecomendados)

//    val gamerCaroline = listaGamers.get(3)
//    val jogoResidentVillage = listaJogoJson.get(10)
//    val jogoSpider = listaJogoJson.get(13)
//    val jogoTheLastOfUs = listaJogoJson.get(2)
//    val jogoDandara = listaJogoJson.get(5)
//    val jogoAssassins = listaJogoJson.get(4)
//    val jogoCyber = listaJogoJson.get(6)
//    val jogoGod = listaJogoJson.get(7)
//    val jogoSkyrim = listaJogoJson.get(18)
//
//    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
//    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
//    gamerCamila.recomendarJogo(jogoAssassins, 8)
//    gamerCamila.recomendarJogo(jogoCyber, 7)
//    gamerCamila.recomendarJogo(jogoGod, 10)
//    gamerCamila.recomendarJogo(jogoDandara, 8)
//    gamerCamila.recomendarJogo(jogoSkyrim, 8)
//    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    var arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)
}
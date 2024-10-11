package br.com.hobi.testeapi.principal

import br.com.hobi.testeapi.dados.Banco
import br.com.hobi.testeapi.dados.JogosDAO
import br.com.hobi.testeapi.modelo.Jogo

fun main(){
//    val conexao = Banco.obterConexao()
//    println(conexao) teste de conexao
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogo2 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    //jogoDAO.adicionar(jogo)

    val jogoRecuperado = jogoDAO.recuperarPeloId(6)
    println(jogoRecuperado)

    jogoDAO.apagar(6)

    val listaJogos: List<Jogo> = jogoDAO.getLista()
    println(listaJogos)

    manager.close()
}
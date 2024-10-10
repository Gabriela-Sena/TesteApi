package br.com.hobi.testeapi.principal

import br.com.hobi.testeapi.dados.Banco
import br.com.hobi.testeapi.dados.JogosDAO
import br.com.hobi.testeapi.modelo.Jogo

fun main(){
//    val conexao = Banco.obterConexao()
//    println(conexao) teste de conexao
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogoDAO = JogosDAO()
    jogoDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogoDAO.getJogos()
    println(listaJogos)

}
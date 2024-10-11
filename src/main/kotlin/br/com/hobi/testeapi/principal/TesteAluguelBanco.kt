package br.com.hobi.testeapi.principal

import br.com.hobi.testeapi.dados.AluguelDAO
import br.com.hobi.testeapi.dados.GamersDAO
import br.com.hobi.testeapi.modelo.Periodo
import br.com.hobi.testeapi.dados.Banco
import br.com.hobi.testeapi.dados.JogosDAO

fun main() {
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamersDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(1)
    val jogo = jogoDAO.recuperarPeloId(3)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val listaAluguel = aluguelDAO.getLista()
    println(listaAluguel)

    manager.close()
}
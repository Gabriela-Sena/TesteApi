package br.com.hobi.testeapi.principal

import br.com.hobi.testeapi.dados.GamersDAO
import br.com.hobi.testeapi.dados.PlanosDAO
import br.com.hobi.testeapi.modelo.Gamer
import br.com.hobi.testeapi.dados.Banco

fun main(){
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    val planosDAO = PlanosDAO(manager)

    gamer.plano = planosDAO.recuperarPeloId(3)

    gamerDAO.adicionar(gamer)

    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}
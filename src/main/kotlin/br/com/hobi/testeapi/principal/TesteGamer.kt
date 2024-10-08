package br.com.hobi.testeapi.principal

import br.com.hobi.testeapi.modelo.Gamer

fun main(){
    val gamer1 = Gamer("Gabriela", "senagabi829@gmail.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Pessoa2",
        "pessoa@gmail.com",
        "08/10/2024",
        "pessoa"
    )

    println(gamer2)

    gamer1.let {
        it.dataNascimento = "29/05/2004"
        it.usuario = "gabi"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)

    gamer1.usuario = "gabriela_teste"
    println(gamer1)
}
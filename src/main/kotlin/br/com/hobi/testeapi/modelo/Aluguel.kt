package br.com.hobi.testeapi.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo){

    override fun toString(): String {
        return "\nAluguel do ${jogo.titulo} por ${gamer.nome}"
    }
}

package br.com.hobi.testeapi.modelo

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}
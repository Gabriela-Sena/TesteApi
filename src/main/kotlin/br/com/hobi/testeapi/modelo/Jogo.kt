package br.com.hobi.testeapi.modelo

import com.google.gson.annotations.SerializedName

class Jogo (val titulo:String,
            val capa:String){

    var descricao = ""

    override fun toString(): String {
        return "Meu br.com.hobi.testeapi.modelo.Jogo: \n" +
        "Titulo=$titulo \n" +
        "Capa=$capa \n" +
        "Descricao=$descricao"
    }
}
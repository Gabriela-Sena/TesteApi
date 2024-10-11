package br.com.hobi.testeapi.modelo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.persistence.*

data class Jogo(@Expose val titulo:String,
                @Expose val capa:String): Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()

//    constructor(titulo: String, capa: String, preco: Double, descricao: String?):
//            this(titulo, capa) {
//        this.preco = preco
//        this.descricao = descricao
//    }

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String?, id: Int=0)
            : this(titulo, capa){
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override fun toString(): String {
        return "\n\nMeu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao\n" +
                "Preço: $preco\n" +
                "Id: $id"
    }
}
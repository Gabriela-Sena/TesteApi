import com.google.gson.annotations.SerializedName

class Jogo (val titulo:String,
            val capa:String){

    val descricao = ""

    override fun toString(): String {
        return "Meu Jogo: \n" +
        "Titulo=$titulo \n" +
        "Capa=$capa \n" +
        "Descricao=$descricao"
    }
}
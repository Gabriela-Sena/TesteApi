import br.com.hobi.testeapi.modelo.Jogo
import br.com.hobi.testeapi.servicos.ConsumoApi
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`) //cria o scanner
    println("Digite um codigo de jogo para buscar:")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi() //variavel para inicializar a classe consumoApi
    val informacaoJogo = buscaApi.buscaJogo(busca)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )
    }

    resultado.onFailure{
        println("br.com.hobi.testeapi.modelo.Jogo inexistente. Tente outro código.")
    }


    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N:")
        val opcao = leitura.nextLine()

        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada do jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo.toString()
        }
        //por algum motivo ele nao funciona a exceção caso haja falha
        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso!")
    }
}
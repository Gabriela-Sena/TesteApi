import br.com.hobi.testeapi.modelo.Gamer
import br.com.hobi.testeapi.modelo.Jogo
import br.com.hobi.testeapi.servicos.ConsumoApi
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`) //cria o scanner
    val gamer = Gamer.criarGamer(leitura)
    println(gamer)

    do {
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

        resultado.onFailure {
            println("Jogo inexistente. Tente outro código.")
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
            //println(meuJogo)
            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    }while(resposta.equals("s", true)) //s maiusculo ou minusculo

    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("\nJogos ordenados por titulo: ")
    gamer.jogosBuscados.sortBy { //filtrar a lista para um filtro especifico
        it?.titulo
    }
    gamer.jogosBuscados.forEach{ //exibir só o titulo
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true)?:false //caso nao encontre jogos com o parametro passado, retorne false, ou nao retorne nada
    }
    println("\nJogos Filtrados:")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N") //exclui uma posicao da lista de jogos buscados
    val opcao = leitura.nextLine()
    if(opcao.equals("s", true)){
        println(gamer.jogosBuscados)
        println("Informe a posicao do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao) //lista de arrays começa no 0
    }

    println("\nLista ataualizada:")
    println(gamer.jogosBuscados)

    println("\nBusca finalizada com sucesso!")

}
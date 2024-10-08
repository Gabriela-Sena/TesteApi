import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*

fun main() {
    //val leitura = Scanner(System.`in`)
    //println("Digite um codigo de jogo para buscar:")
    //val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=146"//concatenando o ID

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()

    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())//cria um cliente HTTP e envia essa requisição para o servidor usando

    val json = response.body()
   // println(json) //A resposta da API vem como um objeto String contendo o JSON com os dados do jogo

    val gson = Gson() //variavel para inicializar a biblioteca gson

    var novoJogo: Jogo? = null

    val meuJogo = gson.fromJson(json, InfoJogo::class.java)

    println(meuJogo)








}
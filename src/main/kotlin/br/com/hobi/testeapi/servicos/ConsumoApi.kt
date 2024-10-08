package br.com.hobi.testeapi.servicos

import br.com.hobi.testeapi.modelo.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogo(id: String):InfoJogo{

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"//concatenando o ID

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())//cria um cliente HTTP e envia essa requisição para o servidor usando

        val json = response.body()
        // println(json) //A resposta da API vem como um objeto String contendo o JSON com os dados do jogo

        val gson = Gson() //variavel para inicializar a biblioteca gson, inserir dependencia e dar um alt+enter
        //var novoJogo: br.com.hobi.testeapi.modelo.Jogo? = null

        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)//O JSON retornado pela API é convertido para um objeto Kotlin usando a biblioteca Gson
        // a variável `meuInfoJogo` é do tipo `br.com.hobi.testeapi.modelo.InfoJogo`

        return meuInfoJogo
    }
}
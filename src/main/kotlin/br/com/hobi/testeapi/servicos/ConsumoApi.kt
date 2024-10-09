package br.com.hobi.testeapi.servicos

import br.com.hobi.testeapi.modelo.Gamer
import br.com.hobi.testeapi.modelo.InfoGamerJson
import br.com.hobi.testeapi.modelo.InfoJogo
import br.com.hobi.testeapi.utilitario.criarGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {


    private fun consomeDados(endereco: String): String { //parte responsavel pelo consumo da api, privado pois só vamos acessar dentro esta mesma classe

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())//cria um cliente HTTP e envia essa requisição para o servidor usando

        val json = response.body()// println(json) //A resposta da API vem como um objeto String contendo o JSON com os dados do jogo
        return json
    }
    fun buscaJogo(id: String):InfoJogo{

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"//concatenando o ID

        val json = consomeDados(endereco)

        val gson = Gson() //variavel para inicializar a biblioteca gson, inserir dependencia e dar um alt+enter
        //var novoJogo: br.com.hobi.testeapi.modelo.Jogo? = null

        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)//O JSON retornado pela API é convertido para um objeto Kotlin usando a biblioteca Gson
        // a variável `meuInfoJogo` é do tipo `br.com.hobi.testeapi.modelo.InfoJogo`

        return meuInfoJogo
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consomeDados(endereco)

        val gson = Gson()
        val meuGamerTipo = object: TypeToken<List<InfoGamerJson>>() {}.type //transforma o json em um tipo para que a conversao seja feita
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGamerJson -> infoGamerJson.criarGamer() }

        return listaGamerConvertida
    }
}
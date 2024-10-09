package br.com.hobi.testeapi.modelo
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.util.*
import kotlin.random.Random.Default.nextInt
import kotlin.text.*

data class Gamer(var nome:String, var email:String): Recomendavel{
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) { //deixar privado para que somente a classe Gamer possa alterar o valor de usuario
            field = value
            if(idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }

    var idInterno:String? = null
        private set
    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int){
        listaNotas.add(nota)
    }

    constructor(nome: String, email: String, dataNascimento: String, usuario: String):this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    init {
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("O nome está em branco")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer:\n" +
                "Nome=$nome\n" +
                "Email=$email\n" +
                "DataNascimento=$dataNascimento\n" +
                "Usuario=$usuario\n" +
                "idInterno=$idInterno\n" +
                "Reputação=$media"
    }

    fun criarIdInterno(){
        val numero = nextInt(10000) //gera numeros para o id interno
        val tag = String.format("%04d", numero) //limitar a 4 numeros

        idInterno = "$usuario#$tag" //concatena na tag usuario + numero aleatorio
    }


    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Email Inválido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel{
        val aluguel = Aluguel(this, jogo, periodo )
        jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogosDoMes(mes:Int): List<Jogo> {
        return jogosAlugados
            .filter { aluguel ->  aluguel.periodo.dataInicial.monthValue == mes}
            .map { aluguel ->  aluguel.jogo}
    }


    companion object {
        fun criarGamer(leitura: Scanner): Gamer{
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
            return Gamer (nome, email)
            }
        }
    }
}

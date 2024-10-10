package br.com.hobi.testeapi.dados

import br.com.hobi.testeapi.modelo.Jogo

class JogosDAO {

    fun getJogos(): List<Jogo>{
        val manager = Banco.getEntityManager()
        try{
            val query = manager.createQuery("FROM JogoEntity", JogoEntity:: class.java)
            return query.resultList.map{entity -> Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id) }
        }finally {
            manager.close()
        }
    }

//    fun getJogos(): List<Jogo> {
//        val listaJogos = mutableListOf<Jogo>()
//        val conexao = Banco.obterConexao()
//
//        if(conexao != null){
//            try {
//                val statement = conexao.createStatement()
//                val resultado = statement.executeQuery("Select * from jogos")
//
//                while (resultado.next()){
//                    val id = resultado.getInt("id")
//                    val titulo = resultado.getString("titulo")
//                    val capa = resultado.getString("capa")
//                    val descricao = resultado.getString("descricao")
//                    val preco = resultado.getDouble("preco")
//
//                    val jogo = Jogo(titulo, capa, preco, descricao, id)//se der problema tira o d
//                    listaJogos.add(jogo)
//                }
//                statement.close()
//            }finally {
//                conexao.close()
//            }
//        }
//        return listaJogos
//    }
//
//    fun adicionarJogo(jogo: Jogo) {
//        val connection = Banco.obterConexao()
//        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"
//
//        if (connection != null) {
//            try {
//                val statement = connection.prepareStatement(insert)
//                statement.setString(1, jogo.titulo)
//                statement.setString(2, jogo.capa)
//                statement.setDouble(3, jogo.preco)
//                statement.setString(4, jogo.descricao)
//
//                statement.executeUpdate()
//                statement.close()
//
//            } finally {
//                connection.close()
//            }
//        }
//    }
}
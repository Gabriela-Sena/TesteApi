package br.com.hobi.testeapi.dados

import br.com.hobi.testeapi.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "root")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }


}
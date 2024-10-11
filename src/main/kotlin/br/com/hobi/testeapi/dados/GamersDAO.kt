package br.com.hobi.testeapi.dados

import br.com.hobi.testeapi.modelo.Gamer
import br.com.hobi.testeapi.utilitario.toEntity
import br.com.hobi.testeapi.utilitario.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply {
            plano = entity.plano?.toModel() ?: throw IllegalArgumentException("Plano cannot be null")
        }
    }
}
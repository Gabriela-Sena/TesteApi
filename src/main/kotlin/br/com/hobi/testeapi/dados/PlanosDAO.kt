package br.com.hobi.testeapi.dados

import br.com.hobi.testeapi.modelo.Plano
import br.com.hobi.testeapi.utilitario.toEntity
import br.com.hobi.testeapi.utilitario.toModel
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {
    override fun toEntity(plano: Plano): PlanoEntity {
        return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel() ?: throw IllegalArgumentException("Entity cannot be null")
    }
}
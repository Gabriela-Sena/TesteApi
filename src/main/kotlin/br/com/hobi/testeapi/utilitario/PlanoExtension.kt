package br.com.hobi.testeapi.utilitario

import br.com.hobi.testeapi.dados.PlanoAssinaturaEntity
import br.com.hobi.testeapi.dados.PlanoAvulsoEntity
import br.com.hobi.testeapi.dados.PlanoEntity
import br.com.hobi.testeapi.modelo.Plano
import br.com.hobi.testeapi.modelo.PlanoAssinatura
import br.com.hobi.testeapi.modelo.PlanoAvulso

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity?.toModel(): Plano? {
    return if (this != null) {
        if (this is PlanoAssinaturaEntity) {
            PlanoAssinatura(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
        } else {
            PlanoAvulso(this.tipo, this.id)
        }
    } else {
        null
    }
}
package br.com.hobi.testeapi.modelo

data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}
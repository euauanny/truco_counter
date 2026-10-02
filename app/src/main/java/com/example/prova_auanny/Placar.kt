package com.example.prova_auanny

/** Contadores em memória, conforme o enunciado da avaliação. */
class Placar {
    var pontosNos = 0
    var pontosEles = 0
    var vitoriasNos = 0
    var vitoriasEles = 0

    fun adicionarPontos(nos: Boolean, pontos: Int): Boolean {
        require(pontos in listOf(1, 3, 6, 9, 12))
        if (nos) pontosNos += pontos else pontosEles += pontos
        val venceu = (if (nos) pontosNos else pontosEles) >= 12
        if (venceu) {
            if (nos) vitoriasNos++ else vitoriasEles++
        }
        return venceu
    }

    fun novaPartida() {
        pontosNos = 0
        pontosEles = 0
    }

    fun zerarHistorico() {
        novaPartida()
        vitoriasNos = 0
        vitoriasEles = 0
    }
}

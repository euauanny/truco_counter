package com.example.prova_auanny

/** Contadores em memória, conforme o enunciado da avaliação. */
class Placar {
    var pontosNos = 0
    var pontosEles = 0
    var vitoriasNos = 0
    var vitoriasEles = 0

    fun adicionarPontos(nos: Boolean, pontos: Int): Boolean {
        if (nos) {
            pontosNos += pontos
            if (pontosNos >= 12) {
                vitoriasNos++
                return true
            }
        } else {
            pontosEles += pontos
            if (pontosEles >= 12) {
                vitoriasEles++
                return true
            }
        }
        return false
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

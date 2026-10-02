package com.example.prova_auanny

import org.junit.Assert.*
import org.junit.Test

class PlacarTest {
    @Test fun iniciaComTodosOsContadoresZerados() {
        val placar = Placar()
        assertEquals(listOf(0, 0, 0, 0), listOf(placar.pontosNos, placar.pontosEles, placar.vitoriasNos, placar.vitoriasEles))
    }

    @Test fun somaCadaValorPermitidoParaAmbosOsTimes() {
        for (nos in listOf(true, false)) {
            for (valor in listOf(1, 3, 6, 9, 12)) {
                val placar = Placar()
                assertEquals(valor == 12, placar.adicionarPontos(nos, valor))
                assertEquals(valor, if (nos) placar.pontosNos else placar.pontosEles)
                assertEquals(0, if (nos) placar.pontosEles else placar.pontosNos)
            }
        }
    }

    @Test fun vitoriaExataZeraPartidaEPreservaHistorico() {
        val placar = Placar()
        assertFalse(placar.adicionarPontos(false, 3))
        assertFalse(placar.adicionarPontos(true, 9))
        assertTrue(placar.adicionarPontos(true, 3))
        placar.novaPartida()
        assertEquals(0, placar.pontosNos)
        assertEquals(0, placar.pontosEles)
        assertEquals(1, placar.vitoriasNos)
        assertEquals(0, placar.vitoriasEles)
    }

    @Test fun ultrapassarDozeTambemContaUmaVitoria() {
        val placar = Placar()
        assertFalse(placar.adicionarPontos(false, 9))
        assertTrue(placar.adicionarPontos(false, 6))
        placar.novaPartida()
        assertTrue(placar.adicionarPontos(false, 12))
        placar.novaPartida()
        assertEquals(2, placar.vitoriasEles)
        assertEquals(0, placar.vitoriasNos)
    }

    @Test fun zerarHistoricoLimpaVitoriasEPontosDosDoisTimes() {
        val placar = Placar()
        placar.adicionarPontos(true, 12)
        placar.novaPartida()
        placar.adicionarPontos(false, 12)
        placar.novaPartida()
        placar.adicionarPontos(true, 3)
        placar.adicionarPontos(false, 6)
        placar.zerarHistorico()
        assertEquals(listOf(0, 0, 0, 0), listOf(placar.pontosNos, placar.pontosEles, placar.vitoriasNos, placar.vitoriasEles))
    }
}

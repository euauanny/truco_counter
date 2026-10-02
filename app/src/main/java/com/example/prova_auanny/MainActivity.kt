package com.example.prova_auanny

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prova_auanny.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val placar = Placar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        savedInstanceState?.let {
            placar.pontosNos = it.getInt("pontosNos")
            placar.pontosEles = it.getInt("pontosEles")
            placar.vitoriasNos = it.getInt("vitoriasNos")
            placar.vitoriasEles = it.getInt("vitoriasEles")
        }
        binding.btNos1.setOnClickListener { pontuar(true, 1) }
        binding.btNos3.setOnClickListener { pontuar(true, 3) }
        binding.btNos6.setOnClickListener { pontuar(true, 6) }
        binding.btNos9.setOnClickListener { pontuar(true, 9) }
        binding.btNos12.setOnClickListener { pontuar(true, 12) }

        binding.btEles1.setOnClickListener { pontuar(false, 1) }
        binding.btEles3.setOnClickListener { pontuar(false, 3) }
        binding.btEles6.setOnClickListener { pontuar(false, 6) }
        binding.btEles9.setOnClickListener { pontuar(false, 9) }
        binding.btEles12.setOnClickListener { pontuar(false, 12) }
        binding.btHistorico.setOnClickListener {
            val intent = Intent(this, HistoricoActivity::class.java)
            intent.putExtra(HistoricoActivity.VITORIAS_NOS, placar.vitoriasNos)
            intent.putExtra(HistoricoActivity.VITORIAS_ELES, placar.vitoriasEles)
            startActivity(intent)
        }
        binding.btZerar.setOnClickListener {
            placar.zerarHistorico()
            atualizarPlacar()
        }
        atualizarPlacar()
    }

    private fun pontuar(nos: Boolean, pontos: Int) {
        if (placar.adicionarPontos(nos, pontos)) {
            val time = getString(if (nos) R.string.nos else R.string.eles)
            Toast.makeText(this, getString(R.string.vitoria, time), Toast.LENGTH_LONG).show()
            placar.novaPartida()
        }
        atualizarPlacar()
    }

    private fun atualizarPlacar() {
        binding.tvPontosNos.text = getString(R.string.pontuacao, placar.pontosNos)
        binding.tvPontosEles.text = getString(R.string.pontuacao, placar.pontosEles)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("pontosNos", placar.pontosNos)
        outState.putInt("pontosEles", placar.pontosEles)
        outState.putInt("vitoriasNos", placar.vitoriasNos)
        outState.putInt("vitoriasEles", placar.vitoriasEles)
        super.onSaveInstanceState(outState)
    }
}

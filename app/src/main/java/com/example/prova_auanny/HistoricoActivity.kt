package com.example.prova_auanny

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prova_auanny.databinding.ActivityHistoricoBinding

class HistoricoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityHistoricoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setAccessibilityHeading(binding.tvTitulo, true)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        binding.tvVitoriasNos.text = getString(R.string.vitorias_nos, intent.getIntExtra(VITORIAS_NOS, 0))
        binding.tvVitoriasEles.text = getString(R.string.vitorias_eles, intent.getIntExtra(VITORIAS_ELES, 0))
        binding.btVoltar.setOnClickListener { finish() }
    }

    companion object {
        const val VITORIAS_NOS = "vitoriasNos"
        const val VITORIAS_ELES = "vitoriasEles"
    }
}

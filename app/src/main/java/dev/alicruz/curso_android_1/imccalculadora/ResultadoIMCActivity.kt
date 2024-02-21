package dev.alicruz.curso_android_1.imccalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import dev.alicruz.curso_android_1.R
import dev.alicruz.curso_android_1.imccalculadora.ImcActivity.Companion.IMC_KEY

class ResultadoIMCActivity : AppCompatActivity() {


    private lateinit var tvResultados: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescripcion: TextView
    private lateinit var btnRecalculate:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imcactivity)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponent()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener {onBackPressed()

        }

    }


    private fun initComponent() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResultados = findViewById(R.id.tvResultados)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }


    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when (result) {
            in 0.00..18.50 -> {
                //bajo
                tvResultados.text = getString(R.string.title_pesobajo)
                tvResultados.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescripcion.text = getString(R.string.descripcion_pesobajo)
            }

            in 18.51..24.99 -> {
                //normal
                tvResultados.text = getString(R.string.title_pesonormal)
                tvResultados.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescripcion.text = getString(R.string.descripcion_pesonormal)
            }

            in 25.0..29.99 -> {
                //sobre
                tvResultados.text = getString(R.string.title_sobrepeso)
                tvResultados.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescripcion.text = getString(R.string.descripcion_sobrepeso)
            }

            in 30.00..99.00 -> {
                //obesi
                tvResultados.text = getString(R.string.title_obesidad)
                tvResultados.setTextColor(ContextCompat.getColor(this, R.color.peso_obesidad))
                tvDescripcion.text = getString(R.string.descripcion_obesidad)
            } else -> {
                tvDescripcion.text = "error"
                tvIMC.text = "error"
                tvResultados.text = "error"
            }

        }
    }


}
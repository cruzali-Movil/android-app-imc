package dev.alicruz.curso_android_1.imccalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.alicruz.curso_android_1.R
import dev.alicruz.curso_android_1.imccalculadora.ImcActivity.Companion.IMC_KEY

class ResultadoIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imcactivity)

        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
    }
}
package dev.alicruz.curso_android_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dev.alicruz.curso_android_1.firstapp.FirstAppActivity
import dev.alicruz.curso_android_1.imccalculadora.ImcActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludar = findViewById<Button>(R.id.btnSaludar);
        btnSaludar.setOnClickListener {navigateToSaludar()}

        val btnImc = findViewById<Button>(R.id.btnIMCApp);
        btnImc.setOnClickListener {navigateToImc()};



    }

    private fun navigateToImc() {
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)

    }

    fun navigateToSaludar() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent);
    }


}

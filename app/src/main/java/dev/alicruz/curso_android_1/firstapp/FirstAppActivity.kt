package dev.alicruz.curso_android_1.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import dev.alicruz.curso_android_1.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnInicio = findViewById<AppCompatButton>(R.id.btnInicio)
        val editName = findViewById<AppCompatEditText>(R.id.editName)





        btnInicio.setOnClickListener{
            val name = editName.text.toString()

            if (name.isNotEmpty()) {
                Log.i("alicruz.dev", "Pulsado ${editName.text.toString()}")
                val intent1 = Intent(this, ResultActivity::class.java)
                intent1.putExtra("NAME", name)
                startActivity(intent1)
            }
        }


    }

}
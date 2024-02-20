package dev.alicruz.curso_android_1.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.alicruz.curso_android_1.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val activityResult = findViewById<TextView>(R.id.textViewName)
        val name:String = intent.extras?.getString("NAME").orEmpty()
        activityResult.text = "Hola $name"
    }

}
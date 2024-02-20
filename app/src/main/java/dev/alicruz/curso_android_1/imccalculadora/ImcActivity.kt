package dev.alicruz.curso_android_1.imccalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import dev.alicruz.curso_android_1.R
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 60;
    private var currentAge:Int = 30;
    private var currentHeight:Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnPesoMenos: FloatingActionButton
    private lateinit var btnPesoMas: FloatingActionButton
    private lateinit var textVPeso: TextView

    private lateinit var btnEdadMenos: FloatingActionButton
    private lateinit var btnEdadMas: FloatingActionButton
    private lateinit var textVAge: TextView

    private lateinit var btnCalculate: Button

    // Pasar el valor a otro activity
    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        initComponent()

        initListener()

        initUI()
    }

    private fun initListener() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener {_, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight"
        }

        btnPesoMas.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnPesoMenos.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        btnEdadMenos.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnEdadMas.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val res = calculateIMC()
            navigateToResult(res)
        }


    }

    private fun navigateToResult(res: Double) {
        val intent = Intent(this, ResultadoIMCActivity::class.java)
        intent.putExtra(IMC_KEY, res)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return df.format(imc).toDouble()
    }

    private fun setWeight() {
        textVPeso.text = currentWeight.toString()
    }

    private fun setAge() {
        textVAge.text = currentAge.toString()
    }

    private fun changeGender()
    {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }

    private fun initComponent() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.textVHeight)
        rsHeight = findViewById(R.id.rangeSliHeight)
        btnPesoMenos = findViewById(R.id.btnPesoMenos)
        btnPesoMas = findViewById(R.id.btnPesoMas)
        textVPeso = findViewById(R.id.textVPeso)
        btnEdadMenos = findViewById(R.id.btnEdadMenos)
        btnEdadMas = findViewById(R.id.btnEdadMas)
        textVAge = findViewById(R.id.textVAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))


    }

    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

}
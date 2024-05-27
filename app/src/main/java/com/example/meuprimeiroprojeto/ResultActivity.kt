package com.example.meuprimeiroprojeto

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)
        val peso: String = intent.getFloatExtra("resumoPeso", 0.0f).toString()
        val altura: String = intent.getFloatExtra("resumoAltura", 0.0f).toString()
        val tvPeso = findViewById<TextView>(R.id.tv_peso)
        val tvAltura = findViewById<TextView>(R.id.tv_altura)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassicicacao = findViewById<TextView>(R.id.tv_classificacao)


        tvResult.text = result.toString()


        val classificacao: String = if (result <= 18.5f) {
            "MAGREZA"
        } else if (result > 18.5f && result <= 24.9f) {
            "NORMAL"
        } else if (result > 25f && result <= 29.29f) {
            "SOBREPESO"
        } else if (result > 30f && result <= 39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassicicacao.text = classificacao
        tvPeso.text = peso + " Kg"
        tvAltura.text = altura + " cm"

        val btnNovoCalculo = findViewById<Button>(R.id.btn_novo_calculo)

        btnNovoCalculo.setOnClickListener {
            finish()
        }



    }


}
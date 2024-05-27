package com.example.meuprimeiroprojeto


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)


        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {

                Snackbar
                    .make(
                        edtPeso,
                        "Campos Obrigatórios*",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2



                val intent = Intent(this, ResultActivity::class.java)
                intent.apply {
                    putExtra(KEY_RESULT_IMC, resultado)
                    putExtra("resumoPeso", peso)
                    putExtra("resumoAltura", altura)
                }

                startActivity(intent)

            }

        }

    }


    override fun onResume() {
        super.onResume()
        val edtPeso: EditText = findViewById(R.id.edt_peso)
        val edtAltura: EditText = findViewById(R.id.edt_altura)
        edtAltura.setText("")
        edtPeso.setText("")

    }
}
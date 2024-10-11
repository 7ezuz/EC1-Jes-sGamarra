package com.example.appec1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DigitoNumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digito_num)


        val editTextNumero = findViewById<EditText>(R.id.btnNumero)  //
        val buttonCalcular = findViewById<Button>(R.id.btnCalcular)
        val textViewResultado = findViewById<TextView>(R.id.btnResultado)


        buttonCalcular.setOnClickListener {
            val numero = editTextNumero.text.toString()

            if (numero.isNotEmpty()) {

                val cantidadDigitos = numero.length

                textViewResultado.text = "Cantidad de dígitos: $cantidadDigitos"
            } else {

                textViewResultado.text = "Por favor, ingrese un número."
            }
        }
    }
}
package com.example.appec1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AlcoholCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alcohol_check)


        val spinnerVehiculo = findViewById<Spinner>(R.id.btnVehiculo)
        val editTextTasa = findViewById<EditText>(R.id.btnTasa)
        val buttonCalcular = findViewById<Button>(R.id.btnCaalcular)
        val textViewRespuesta = findViewById<TextView>(R.id.btnRespuesta)


        val vehicleTypes = arrayOf("Coche", "Moto", "Camión")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, vehicleTypes)
        spinnerVehiculo.adapter = adapter


        buttonCalcular.setOnClickListener {
            val alcoholLevel = editTextTasa.text.toString().toDoubleOrNull()
            val vehicle = spinnerVehiculo.selectedItem.toString()


            if (alcoholLevel != null) {
                val isPositive = when (vehicle) {
                    "Coche" -> alcoholLevel > 0.5
                    "Moto" -> alcoholLevel > 0.3
                    "Camión" -> alcoholLevel > 0.2
                    else -> false
                }


                textViewRespuesta.text = if (isPositive) {
                    "El conductor da positivo en el control de alcoholemia."
                } else {
                    "El conductor está dentro de los límites permitidos."
                }
            } else {

                textViewRespuesta.text = "Por favor, ingrese una tasa de alcohol válida."
            }
        }
    }
}

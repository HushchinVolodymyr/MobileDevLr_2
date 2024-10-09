package com.example.lr_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultOutputField: TextView = findViewById(R.id.resultOutput)

        val coalWeightInput: EditText = findViewById(R.id.coalWeightInput)
        val coalHeatValueInput: EditText = findViewById(R.id.coalHeatValueInput)

        val oilWeightInput: EditText = findViewById(R.id.oilWeightInput)
        val oilHeatValueInput: EditText = findViewById(R.id.oilHeatValueInput)

        val gasWeightInput: EditText = findViewById(R.id.gasWeightInput)
        val gasHeatValueInput: EditText = findViewById(R.id.gasHeatValueInput)

        val calcButton: Button = findViewById(R.id.calcButton)

        calcButton.setOnClickListener {
            val coalWeight = coalWeightInput.text.toString().toDoubleOrNull() ?: 0
            val coalHeatValue = coalHeatValueInput.text.toString().toDoubleOrNull() ?: 20.47

            val oilWeight = oilWeightInput.text.toString().toDoubleOrNull() ?: 0
            val oilHeatValue = oilHeatValueInput.text.toString().toDoubleOrNull() ?: 40.40

            val gasWeight = gasWeightInput.text.toString().toDoubleOrNull() ?: 0
            val gasHeatValue = gasHeatValueInput.text.toString().toDoubleOrNull() ?: 33.08

            val fuelEmissionCalculator = FuelEmissionCalculator()

            val coalEmission = fuelEmissionCalculator.calculateCoalEmission(coalWeight.toDouble(), coalHeatValue)
            val oilEmission = fuelEmissionCalculator.calculateOilEmission(oilWeight.toDouble(), oilHeatValue)
            val gasEmission = fuelEmissionCalculator.calculateGasEmission(gasWeight.toDouble(), gasHeatValue)

            val totalEmissions = fuelEmissionCalculator.calculateTotalEmission(coalEmission, oilEmission, gasEmission)

            val result = "Показник емісії твердих частинок при спалюванні вугілля: ${fuelEmissionCalculator.getCoalEmissionFactor()} г/ГДж\n" +
                    "Показник емісії твердих частинок при спалюванні вугілля: $coalEmission т.\n" +
                    "Показник емісії твердих частинок при спалюванні мазуту: ${fuelEmissionCalculator.getOilEmissionFactor()} г/ГДж\n" +
                    "Показник емісії твердих частинок при спалюванні мазуту: $oilEmission т.\n" +
                    "Показник емісії твердих частинок при спалюванні природного газу: ${fuelEmissionCalculator.getGasEmissionFactor()} г/ГДж\n" +
                    "Показник емісії твердих частинок при спалюванні природного газу: $gasEmission т.\n" +
                    "Загальний валовий викид: $totalEmissions т."

            resultOutputField.text = result
        }
    }
}
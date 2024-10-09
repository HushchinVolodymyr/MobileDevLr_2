package com.example.lr_2

class FuelEmissionCalculator {
    private val coalEmissionFactor = 150
    private val oilEmissionFactor = 0.57
    private val gasEmissionFactor = 0.0

    fun calculateCoalEmission(kgCoal: Double, heatValueCoal: Double): Double {
        return 1e-6f * this.coalEmissionFactor * heatValueCoal * kgCoal
    }

    fun calculateOilEmission(kgOil: Double, heatValueOil: Double): Double {
         return 1e-6f * this.oilEmissionFactor * heatValueOil * kgOil
    }

    fun calculateGasEmission(kgGas: Double, heatValueGas: Double): Double {
        return 1e-6f * this.gasEmissionFactor * heatValueGas * kgGas
    }

    fun calculateTotalEmission(coalEmission: Double, oilEmission: Double, gasEmission: Double): Double {
        return coalEmission + oilEmission + gasEmission
    }

    fun getCoalEmissionFactor(): Double {
        return coalEmissionFactor.toDouble()
    }

    fun getOilEmissionFactor(): Double {
        return oilEmissionFactor
    }

    fun getGasEmissionFactor(): Double {
        return gasEmissionFactor
    }
}

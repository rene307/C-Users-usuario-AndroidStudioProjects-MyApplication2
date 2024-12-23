
package com.example.myapplication2
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.example.myapplication2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restobar)


        val contadorCuranto: NumberPicker = findViewById(R.id.valorcuranto)
        val contadorCazuela: NumberPicker = findViewById(R.id.valorcazuela)
        val totalSinPropina: TextView = findViewById(R.id.cajadetotalsinpropina)
        val totalConPropina: TextView = findViewById(R.id.cajadetotalconpropina)
        val switchPropina: SwitchCompat = findViewById(R.id.propina2)
        val botonPagar: Button = findViewById(R.id.botonpagar)


        contadorCuranto.minValue = 0
        contadorCuranto.maxValue = 10
        contadorCazuela.minValue = 0
        contadorCazuela.maxValue = 10

        val precioCuranto = 13000
        val precioCazuela = 6500

        botonPagar.setOnClickListener {
            val cantidadCuranto = contadorCuranto.value
            val cantidadCazuela = contadorCazuela.value

            val total = (cantidadCuranto * precioCuranto) + (cantidadCazuela * precioCazuela)

            // Verificar si se incluye propina
            if (switchPropina.isChecked) {
                // Con propina (10%)
                val totalConPropinaCalculado = (total * 1.1).toInt()
                totalSinPropina.text = "$total"
                totalConPropina.text = "$totalConPropinaCalculado"
            } else {
                // Sin propina
                totalSinPropina.text = "$total"
                totalConPropina.text = "$total"
            }
        }
    }
}




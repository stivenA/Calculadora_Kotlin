package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var resultado_textView: TextView
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val unoBoton = findViewById<Button>(R.id.unoBoton)
        val dosBoton = findViewById<Button>(R.id.dosBoton)
        val tresBoton = findViewById<Button>(R.id.tresBoton)
        val cuatroBoton = findViewById<Button>(R.id.cuatroBoton)
        val cincoBoton = findViewById<Button>(R.id.cincoBoton)
        val seixBoton = findViewById<Button>(R.id.seixBoton)
        val sieteBoton = findViewById<Button>(R.id.sieteBoton)
        val ochoBoton = findViewById<Button>(R.id.ochoBoton)
        val nueveBoton = findViewById<Button>(R.id.nueveBoton)
        val ceroBoton = findViewById<Button>(R.id.ceroBoton)
        val sumaBoton = findViewById<Button>(R.id.sumaBoton)
        val restaBoton = findViewById<Button>(R.id.restaBoton)
        val multBoton = findViewById<Button>(R.id.multiplicatBoton)
        val divisionBoton = findViewById<Button>(R.id.divisionBoton)
        val clearBoton = findViewById<Button>(R.id.clearBoton)
        val igualBoton = findViewById<Button>(R.id.igualBoton)

        resultado_textView = findViewById<TextView>(R.id.resultado_textView)

        unoBoton.setOnClickListener{numeroPresionado("1") }
        dosBoton.setOnClickListener{numeroPresionado("2") }
        tresBoton.setOnClickListener{numeroPresionado("3") }
        cuatroBoton.setOnClickListener{numeroPresionado("4") }
        cincoBoton.setOnClickListener{numeroPresionado("5") }
        seixBoton.setOnClickListener{numeroPresionado("6") }
        sieteBoton.setOnClickListener{numeroPresionado("7") }
        ochoBoton.setOnClickListener{numeroPresionado("8") }
        nueveBoton.setOnClickListener{numeroPresionado("9") }
        ceroBoton.setOnClickListener{numeroPresionado("0") }

        sumaBoton.setOnClickListener{operacionPresionada(SUMA)}
        restaBoton.setOnClickListener{operacionPresionada(RESTA)}
        divisionBoton.setOnClickListener{operacionPresionada(DIVISION)}
        multBoton.setOnClickListener{operacionPresionada(MULTIPLICACION)}

        clearBoton.setOnClickListener{
            num1 = 0.0
            num2 = 0.0
            resultado_textView.text = "0"
            operacion = No_OPERACION
        }

        igualBoton.setOnClickListener{
            var resultado = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }
            resultado_textView.text = resultado.toString()
        }

        //Ooeraciones



    }

    private  fun  numeroPresionado(digito: String){
        resultado_textView.text = "${resultado_textView.text}$digito"
        if (operacion == No_OPERACION) {
            num1 = resultado_textView.text.toString().toDouble()
        }else{
            num2 = resultado_textView.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion
        resultado_textView.text = "0"
    }
    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val No_OPERACION = 0
    }


}
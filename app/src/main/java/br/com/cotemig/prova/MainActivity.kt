package br.com.cotemig.prova

import android.icu.number.NumberFormatter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

//Autor do projeto
//Numero de chamada: 7
//Matricula: 22002324
//Nome: Arthur Santiago Aguiar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calcular = findViewById<Button>(R.id.calcular)
        var editAltura = findViewById<EditText>(R.id.altura)
        var editPeso = findViewById<EditText>(R.id.peso)
        var imc = findViewById<TextView>(R.id.imc)

        calcular.setOnClickListener{
            var altura = editAltura.text.toString()
            var peso = editPeso.text.toString()

            if(altura == "" || altura.toDouble() <= 0){
                Toast.makeText(this, "Insira valores válidos!!",Toast.LENGTH_LONG).show()
                editAltura.requestFocus();
            }else if(peso == "" || peso.toDouble() <= 0 ){
                Toast.makeText(this, "Insira valores válidos!!",Toast.LENGTH_LONG).show()
                editPeso.requestFocus()
            }else{
                var resultado = peso.toDouble() / (altura.toDouble() * altura.toDouble())
                imc.text = (BigDecimal(resultado).setScale(2, RoundingMode.DOWN)).toString()
            }
        }
    }
}
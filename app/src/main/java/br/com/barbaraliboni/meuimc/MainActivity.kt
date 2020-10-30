package br.com.barbaraliboni.meuimc

import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.math.roundToInt
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val txtMainAfinal: TextView = findViewById(R.id.txtMainAfinal);
        val txtMainAConta: TextView = findViewById(R.id.txtMainAConta);
        val txtMainLegal: TextView = findViewById(R.id.txtMainLegal);
        val edtnMainAltura: EditText = findViewById(R.id.edtnMainAltura);
        val edtnMainPeso: EditText = findViewById(R.id.edtnMainPeso);
        val txtMainObsAltura: TextView = findViewById(R.id.txtMainObsAltura);
        val txtMainObsPeso: TextView = findViewById(R.id.txtMainObsPeso);
        val btnMainCalcular: Button = findViewById(R.id.btnMainCalcular);
        val txtMainCopy : TextView = findViewById(R.id.txtMainCopy);


        btnMainCalcular.setOnClickListener {
            val altura = edtnMainAltura.text.toString()
            val peso = edtnMainPeso.text.toString()

            if (altura.isEmpty()) {
                edtnMainAltura.error = "Preencha este campo";
                edtnMainAltura.requestFocus();
            }
            else if (peso.isEmpty()) {
                edtnMainPeso.error = "Preencha este campo";
                edtnMainPeso.requestFocus();
            }
            else {

                val imc = peso.toDouble() / (altura.toDouble() * altura.toDouble());
                val decimal = BigDecimal(imc).setScale(2, RoundingMode.HALF_EVEN)


                if (imc < 18.5) {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("IMC")
                        .setMessage("Seu IMC é de $decimal. Você está abaixo do peso! 😕")
                        .setPositiveButton("Voltar") { _, _ ->
                        }
                    alert.show();
                }
                else if (imc >= 18.5 && imc <= 24.9) {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("IMC")
                        .setMessage("Seu IMC é de $decimal. Você está no seu peso ideal! 🤑")
                        .setPositiveButton("Voltar") { _, _ ->
                        }
                    alert.show();
                }
                else if (imc >= 25 && imc <= 29.9) {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("IMC")
                        .setMessage("Seu IMC é de $decimal. Você está sobrepeso! 😕")
                        .setPositiveButton("Voltar") { _, _ ->
                        }
                    alert.show();
                }
                else if (imc >= 30 && imc <= 34.9) {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("IMC")
                        .setMessage("Seu IMC é de $decimal. Você está com obesidade grau I 😰")
                        .setPositiveButton("Voltar") { _, _ ->
                        }
                    alert.show();
                }
                else if (imc >= 35 && imc <= 39.9) {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("IMC")
                        .setMessage("Seu IMC é de $decimal. Você está com obesidade grau II 😨")
                        .setPositiveButton("Voltar") { _, _ ->
                        }
                    alert.show();
                }
                else {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("IMC")
                        .setMessage("Seu IMC é de $decimal. Você está com obesidade mórbida 😱")
                        .setPositiveButton("Voltar") { _, _ ->
                        }
                    alert.show();
                }
            }
        }
    }
}


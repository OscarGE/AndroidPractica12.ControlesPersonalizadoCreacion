package com.example.practica12_controlespersonalizadocreacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var txtCalendario: TextView
    private lateinit var formulario: FormControl
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var nombreCre: TextView
    private lateinit var apellidoCre: TextView
    private lateinit var fechaCre: TextView
    private lateinit var sexoCre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCalendario=findViewById(R.id.txtCalendario)
        txtCalendario.setOnClickListener{showDatePickerDialog()}

        formulario=findViewById(R.id.ctlForm)
        img1=findViewById(R.id.img1)
        img2=findViewById(R.id.img2)
        nombreCre=findViewById(R.id.nombreCre)
        apellidoCre=findViewById(R.id.apellidoCre)
        fechaCre=findViewById(R.id.fechaCre)
        sexoCre=findViewById(R.id.sexoCre)

        formulario.setOnEnviarListener { nombre, apellidos, nacimeinto, sexo ->
            nombreCre.text=nombre
            apellidoCre.text=apellidos
            fechaCre.text=nacimeinto
            sexoCre.text=sexo
            when(sexo){
                "Hombre" -> {img1.setImageResource(R.drawable.hombre)
                            img2.setImageResource(R.drawable.hombre)}
                "Mujer" -> {img1.setImageResource(R.drawable.mujer)
                            img2.setImageResource(R.drawable.mujer)}
            }
        }



    }
    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        txtCalendario.setText("$day/$month/$year")
    }
}
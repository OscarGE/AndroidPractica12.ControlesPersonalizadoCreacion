package com.example.practica12_controlespersonalizadocreacion

import android.app.DatePickerDialog
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.*
import java.util.*
import java.sql.Date
import java.text.SimpleDateFormat
import kotlin.properties.Delegates

class FormControl: LinearLayout {
    //Constructores
    constructor(ctx: Context): super(ctx){
        inicializar()
    }
    constructor(ctx: Context, attrs: AttributeSet): super(ctx, attrs){
        inicializar()
    }
    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int): super(ctx, attrs, defStyleAttr){
        inicializar()
    }
    //Variables de controles view
    private lateinit var txtNombre: EditText
    private lateinit var txtApelli: EditText
    private lateinit var txtCalendario: TextView
    private lateinit var rgSexo: RadioGroup
    private lateinit var rbMujer: RadioButton
    private lateinit var rbHombre: RadioButton
    private lateinit var btnEnviar: Button
    private lateinit var btnLimpiar: Button

    //Interfaz para Listener
    interface OnEnviarListener{
        fun onEnviar(nombre: String, apellidos: String, nacimeinto:String, sexo:String)
    }
    fun inicializar(){
        //Utilizamos el layout 'form_control.xml' como interfaz del control
        val li= LayoutInflater.from(context)
        li.inflate(R.layout.form_control, this, true)

        //Obtenemos las referencias a los distintos controles
        txtNombre=findViewById(R.id.txtNombre) as EditText
        txtApelli=findViewById(R.id.txtApelli) as EditText
        txtCalendario=findViewById(R.id.txtCalendario) as TextView
        rgSexo=findViewById(R.id.rgSexo) as RadioGroup
        rbMujer=findViewById(R.id.rbMujer) as RadioButton
        rbHombre=findViewById(R.id.rbHombre) as RadioButton
        btnEnviar=findViewById(R.id.btnEnviar) as Button
        btnLimpiar=findViewById(R.id.btnLimpiar) as Button

        asignarEvento()
    }

    var listener:OnEnviarListener?=null
    fun setOnEnviarListener(enviar:(String, String, String, String)->Unit){
        listener=object:OnEnviarListener{
            override fun onEnviar(nombre: String, apellidos: String,
                                  nacimeinto:String, sexo:String) {
                enviar(nombre,apellidos,nacimeinto,sexo)
            }
        }
    }

    fun asignarEvento(){
        btnEnviar.setOnClickListener{
            listener?.onEnviar(txtNombre.text.toString(), txtApelli.text.toString(),
                txtCalendario.text.toString(),getSexo())
        }
        btnLimpiar.setOnClickListener{
            txtNombre.getText().clear()
            txtApelli.getText().clear()
            txtCalendario.setText("dd/mm/aaaa")
            rgSexo.clearCheck()
        }
    }

    private fun getSexo(): String {
        when(rgSexo.getCheckedRadioButtonId()){
            rbHombre.id -> return "Hombre"
            rbMujer.id-> return "Mujer"
            else -> return "Indefinido"
        }
    }
}
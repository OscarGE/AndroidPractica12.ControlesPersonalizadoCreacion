package com.example.practica12_controlespersonalizadocreacion

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.*

class credencialControl:androidx.constraintlayout.widget.ConstraintLayout  {
    //Constructores
    constructor(ctx: Context): super(ctx){
        inicializar()
    }
    constructor(ctx: Context, attrs: AttributeSet): super(ctx, attrs){
        inicializar()
    }
    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int):
            super(ctx, attrs, defStyleAttr){
        inicializar()
    }
    fun inicializar(){
        //Utilizamos el layout 'form_control.xml' como interfaz del control
        val li= LayoutInflater.from(context)
        li.inflate(R.layout.credencial, this, true)

    }
}
package com.example.practica12_controlespersonalizadocreacion

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet

class CustomEditText: androidx.appcompat.widget.AppCompatEditText {
    constructor(ctx: Context): super(ctx)
    constructor(ctx: Context, attrs: AttributeSet): super(ctx, attrs)
    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int):
            super(ctx, attrs, defStyleAttr)

    val escala: Float= resources.displayMetrics.density
    val p1: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color= Color.GRAY
        textSize=35f
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText("" + text.toString().length,
            width - 20*escala,
            30*escala, p1)
    }
}
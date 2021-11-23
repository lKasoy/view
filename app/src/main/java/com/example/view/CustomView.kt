package com.example.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.properties.Delegates

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private var radiusRounding: Float
    private val p = Paint()

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.CustomView, 0, 0
        ).apply {
            try {
                radiusRounding = getDimension(R.styleable.CustomView_radiusRounding, -1f)
                p.strokeWidth = getDimension(R.styleable.CustomView_lineWidth, -1f)
                p.color = getColor(R.styleable.CustomView_paintColor, -1)
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRoundRect(100f, 100f, 600f, 400f, radiusRounding, radiusRounding, p)
    }
}
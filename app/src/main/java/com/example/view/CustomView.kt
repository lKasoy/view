package com.example.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private val radiusRounding: Float
    private val p = Paint()

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.CustomView, 0, 0
        ).apply {
            try {
                radiusRounding = getDimension(R.styleable.CustomView_radiusRounding, 100f)
                p.strokeWidth = getDimension(R.styleable.CustomView_lineWidth, 10f)
                p.color = getColor(R.styleable.CustomView_paintColor, Color.rgb(1, 2, 2))
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val w = (this.measuredWidth - paddingRight - paddingLeft).toFloat()
        val h = (this.measuredHeight - paddingBottom - paddingTop).toFloat()
        canvas.drawRoundRect(
            paddingLeft.toFloat(),
            paddingTop.toFloat(),
            w,
            h,
            radiusRounding, radiusRounding, p
        )
    }
}
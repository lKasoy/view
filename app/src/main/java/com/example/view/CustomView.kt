package com.example.view

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

val Int.dp: Float
    get() = Resources.getSystem().displayMetrics.density * this
val Int.sp: Float
    get() = Resources.getSystem().displayMetrics.scaledDensity * this

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private val radiusRounding: Float
    private val p = Paint().apply {
        style = Paint.Style.STROKE
    }

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.CustomView, 0, 0
        ).apply {
            try {
                radiusRounding = getDimension(R.styleable.CustomView_radiusRounding, 40.dp)
                p.strokeWidth = getDimension(R.styleable.CustomView_lineWidth, 8.dp)
                p.color = getColor(R.styleable.CustomView_paintColor, Color.rgb(1, 2, 2))
            } finally {
                recycle()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val w = this.measuredWidth - paddingRight - paddingLeft - p.strokeWidth
        val h = this.measuredHeight - paddingBottom - paddingTop - p.strokeWidth
        val left = paddingLeft.toFloat() + p.strokeWidth/2
        val top = paddingTop.toFloat() + p.strokeWidth/2
        canvas.drawRoundRect(
            left,
            top,
            left + w,
            top + h,
            radiusRounding, radiusRounding, p
        )
    }
}
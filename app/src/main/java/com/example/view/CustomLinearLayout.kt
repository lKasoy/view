package com.example.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding

open class CustomLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private val _textSize: Float
    private val _backGroundColor: Int
    private val _textColor: Int
    private val _padding: Float

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.CustomLinearLayout, 0, 0
        ).apply {
            try {
                _textSize = getDimension(R.styleable.CustomLinearLayout_aTextSize, 10f)
                _backGroundColor = getColor(
                    R.styleable.CustomLinearLayout_aBackgroundColor,
                    Color.rgb(0, 0, 192)
                )
                _textColor = getColor(
                    R.styleable.CustomLinearLayout_aTextColor,
                    Color.rgb(192, 0, 0)
                )
                _padding = getDimension(R.styleable.CustomLinearLayout_aPadding, 10f)
            } finally {
                recycle()
            }
        }
        this.orientation = VERTICAL
    }

    fun addItem(item: String) {
        val textView = TextView(context)
        textView.textSize = _textSize
        textView.setBackgroundColor(_backGroundColor)
        textView.setTextColor(_textColor)
        textView.setPadding(_padding.toInt())
        textView.text = item
        addView(textView)
    }
}

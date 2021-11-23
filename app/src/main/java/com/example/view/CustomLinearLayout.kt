package com.example.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding

class CustomLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    private var _textSize: Float
    private var _backGroundColor: Int
    private var _textColor: Int
    private var _padding: Float

    init {
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.CustomLinearLayout, 0, 0
        ).apply {
            try {
                _textSize = getDimension(R.styleable.CustomLinearLayout_aTextSize, -1f)
                _backGroundColor = getColor(R.styleable.CustomLinearLayout_aBackgroundColor, -1)
                _textColor = getColor(R.styleable.CustomLinearLayout_aTextColor, -1)
                _padding = getDimension(R.styleable.CustomLinearLayout_aPadding, -1f)
            } finally {
                recycle()
            }
        }
        this.orientation = VERTICAL
        addItem("Apple")
        addItem("Samsung")
        addNewItem("newItem")
        addItem("Kolodyaz'")
    }

    private fun addNewItem(item: String) {
        val textView = TextView(context)
        textView.text = item
        addView(textView)
    }

    private fun addItem(item: String) {
        val textView = TextView(context)
        textView.textSize = _textSize
        textView.setBackgroundColor(_backGroundColor)
        textView.setTextColor(_textColor)
        textView.setPadding(_padding.toInt())
        textView.text = item
        addView(textView)
    }
}
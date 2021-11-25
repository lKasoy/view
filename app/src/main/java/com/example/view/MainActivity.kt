package com.example.view

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        addNewItems()
    }

    private fun addNewItems() {
        binding.customLinearLayout.apply {
            addItem("YES")
            addItem("APPLE")
            addItem("SAMSUNG")
        }
    }
}

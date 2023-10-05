package com.example.quiziha.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiziha.R
import com.example.quiziha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
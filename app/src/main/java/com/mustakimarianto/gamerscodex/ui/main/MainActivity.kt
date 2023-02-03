package com.mustakimarianto.gamerscodex.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mustakimarianto.gamerscodex.R
import com.mustakimarianto.gamerscodex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
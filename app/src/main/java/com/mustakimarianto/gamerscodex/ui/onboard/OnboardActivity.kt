package com.mustakimarianto.gamerscodex.ui.onboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mustakimarianto.gamerscodex.R
import com.mustakimarianto.gamerscodex.databinding.ActivityOnboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
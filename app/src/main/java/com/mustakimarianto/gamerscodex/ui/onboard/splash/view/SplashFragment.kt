package com.mustakimarianto.gamerscodex.ui.onboard.splash.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mustakimarianto.gamerscodex.databinding.FragmentSplashBinding
import com.mustakimarianto.gamerscodex.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animateAppText()
    }

    /**
     * Navigate to main activity.
     */
    private fun navigateToMain() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)

        requireActivity().finish()
    }

    /**
     * Animating app logo and go to main activity.
     */
    private fun animateAppText() {
        val duration: Long = 1500

        binding.tvSplashAppLogo.alpha = 0f

        // Animate transparency of logo
        binding.tvSplashAppLogo.animate().alpha(1f).setDuration(duration).withEndAction {

            // Add fade in and fade out animation when navigating
            activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            // Navigate to main activity
            navigateToMain()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.mustakimarianto.gamerscodex.ui.main.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mustakimarianto.gamerscodex.databinding.FragmentHomeBinding
import com.mustakimarianto.gamerscodex.utils.Constant
import com.mustakimarianto.gamerscodex.utils.extension.navigateToDirection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private var platforms = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkSelectedPlatforms()
    }

    private fun checkSelectedPlatforms() {
        binding.btnHomeWindows.setOnClickListener(this)
        binding.btnHomeMacos.setOnClickListener(this)
        binding.btnHomeLinux.setOnClickListener(this)
        binding.btnHomePs4.setOnClickListener(this)
        binding.btnHomePs5.setOnClickListener(this)
        binding.btnHomeIos.setOnClickListener(this)
        binding.btnHomeAndroid.setOnClickListener(this)
        binding.btnHomeXboxsx.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.btnHomeWindows -> {
                platforms = Constant.PLATFORM_PC
            }
            binding.btnHomeMacos -> {
                platforms = Constant.PLATFORM_MAC
            }
            binding.btnHomeLinux -> {
                platforms = Constant.PLATFORM_LINUX
            }
            binding.btnHomePs4 -> {
                platforms = Constant.PLATFORM_PS4
            }
            binding.btnHomePs5 -> {
                platforms = Constant.PLATFORM_PS5
            }
            binding.btnHomeXboxsx -> {
                platforms = Constant.PLATFORM_XBOX_SX
            }
            binding.btnHomeIos -> {
                platforms = Constant.PLATFORM_IOS
            }
            binding.btnHomeAndroid -> {
                platforms = Constant.PLATFORM_ANDROID
            }
        }

        val direction = HomeFragmentDirections.actionToGameList(platforms)
        direction.navigateToDirection(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
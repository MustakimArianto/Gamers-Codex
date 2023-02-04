package com.mustakimarianto.gamerscodex.ui.main.gamelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mustakimarianto.gamerscodex.databinding.FragmentGameListBinding
import com.mustakimarianto.gamerscodex.ui.main.gamelist.viewmodel.GameListViewModel
import com.mustakimarianto.gamerscodex.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameListFragment : Fragment() {
    private var _binding: FragmentGameListBinding? = null

    private val binding get() = _binding!!

    private val viewModel: GameListViewModel by viewModels()

    private var isLoading = false

    private val args: GameListFragmentArgs by navArgs()

    private lateinit var platforms: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameListBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        platforms = args.platforms

        getGamesByPlatform()
    }

    private fun getGamesByPlatform() {
        viewModel.getGamesByPlatform(platforms)

        viewModel.games.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    binding.pbGameListLoading.visibility = View.INVISIBLE
                    isLoading = false

                    it.data?.let { response ->
                        binding.tvGameList.text = response.toString()
                    }
                }

                is Resource.Error -> {
                    binding.pbGameListLoading.visibility = View.INVISIBLE
                    isLoading = true

                    it.message?.let { message ->
                        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                    }
                }

                is Resource.Loading -> {
                    binding.pbGameListLoading.visibility = View.VISIBLE
                }
            }
        }
    }
}
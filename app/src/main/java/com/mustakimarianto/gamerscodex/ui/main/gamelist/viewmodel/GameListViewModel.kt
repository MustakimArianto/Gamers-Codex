package com.mustakimarianto.gamerscodex.ui.main.gamelist.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustakimarianto.gamerscodex.data.model.games.GamesResponse
import com.mustakimarianto.gamerscodex.repository.RawgRepository
import com.mustakimarianto.gamerscodex.utils.NetworkUtil
import com.mustakimarianto.gamerscodex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class GameListViewModel @Inject constructor(
    private val repository: RawgRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {
    val games: MutableLiveData<Resource<GamesResponse>> = MutableLiveData()
    var gamesResponse: GamesResponse? = null

    // Games
    fun getGamesByPlatform(platforms: String) = viewModelScope.launch {
        safeGetGamesByPlatformCall(platforms)
    }

    private suspend fun safeGetGamesByPlatformCall(platforms: String) {
        games.postValue(Resource.Loading())

        try {
            if (NetworkUtil.hasInternetConnection(context)) {
                val response = repository.getGamesByPlatform(platforms)
                games.postValue(handleGetGamesByPlatformResponse(response))
            } else {
                games.postValue(Resource.Error("No Internet Connection"))
            }
        } catch (e: Exception) {
            when (e) {
                is IOException -> games.postValue(Resource.Error("Network Failure"))
                else -> games.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private fun handleGetGamesByPlatformResponse(response: Response<GamesResponse>): Resource<GamesResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                gamesResponse = result
                return Resource.Success(gamesResponse!!)
            }
        }

        return Resource.Error(response.message())
    }
}
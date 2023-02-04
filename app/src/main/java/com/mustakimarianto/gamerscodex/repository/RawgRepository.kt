package com.mustakimarianto.gamerscodex.repository

import com.mustakimarianto.gamerscodex.data.model.games.GamesResponse
import com.mustakimarianto.gamerscodex.data.remote.RawgApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RawgRepository @Inject constructor(
    private val api: RawgApi
) {
    /**
     * Get list of games by platform.
     */
    suspend fun getGamesByPlatform(platforms : String) : Response<GamesResponse> {
        return api.getGamesByPlatform(platforms = platforms)
    }

}
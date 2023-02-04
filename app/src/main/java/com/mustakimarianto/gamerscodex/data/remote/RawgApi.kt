package com.mustakimarianto.gamerscodex.data.remote

import com.mustakimarianto.gamerscodex.BuildConfig
import com.mustakimarianto.gamerscodex.data.model.games.GamesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {

    /**
     * Get list of games by platform.
     */
    @GET(BuildConfig.GAMES)
    suspend fun getGamesByPlatform(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("platforms") platforms : String
    ) : Response<GamesResponse>
}
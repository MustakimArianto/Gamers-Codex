package com.mustakimarianto.gamerscodex.data.model.games


import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @SerializedName("count")
    val count: Int, // 53964
    @SerializedName("next")
    val next: String, // https://api.rawg.io/api/games?key=APIKEY&page=2&platforms=21
    @SerializedName("previous")
    val previous: Any?, // null
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("user_platforms")
    val userPlatforms: Boolean // false
) {
    data class Result(
        @SerializedName("added")
        val added: Int, // 14334
        @SerializedName("added_by_status")
        val addedByStatus: AddedByStatus,
        @SerializedName("background_image")
        val backgroundImage: String, // https://media.rawg.io/media/games/7fa/7fa0b586293c5861ee32490e953a4996.jpg
        @SerializedName("clip")
        val clip: Any?, // null
        @SerializedName("dominant_color")
        val dominantColor: String, // 0f0f0f
        @SerializedName("esrb_rating")
        val esrbRating: EsrbRating?,
        @SerializedName("genres")
        val genres: List<Genre>,
        @SerializedName("id")
        val id: Int, // 13536
        @SerializedName("metacritic")
        val metacritic: Int?, // 90
        @SerializedName("name")
        val name: String, // Portal
        @SerializedName("parent_platforms")
        val parentPlatforms: List<ParentPlatform>,
        @SerializedName("platforms")
        val platforms: List<Platform>,
        @SerializedName("playtime")
        val playtime: Int, // 4
        @SerializedName("rating")
        val rating: Double, // 4.51
        @SerializedName("rating_top")
        val ratingTop: Int, // 5
        @SerializedName("ratings")
        val ratings: List<Rating>,
        @SerializedName("ratings_count")
        val ratingsCount: Int, // 4257
        @SerializedName("released")
        val released: String, // 2007-10-09
        @SerializedName("reviews_count")
        val reviewsCount: Int, // 4289
        @SerializedName("reviews_text_count")
        val reviewsTextCount: Int, // 23
        @SerializedName("saturated_color")
        val saturatedColor: String, // 0f0f0f
        @SerializedName("score")
        val score: Any?, // null
        @SerializedName("short_screenshots")
        val shortScreenshots: List<ShortScreenshot>,
        @SerializedName("slug")
        val slug: String, // portal
        @SerializedName("stores")
        val stores: List<Store>,
        @SerializedName("suggestions_count")
        val suggestionsCount: Int, // 279
        @SerializedName("tags")
        val tags: List<Tag>,
        @SerializedName("tba")
        val tba: Boolean, // false
        @SerializedName("updated")
        val updated: String, // 2023-02-02T18:30:24
        @SerializedName("user_game")
        val userGame: Any? // null
    ) {
        data class AddedByStatus(
            @SerializedName("beaten")
            val beaten: Int, // 4440
            @SerializedName("dropped")
            val dropped: Int, // 332
            @SerializedName("owned")
            val owned: Int, // 8890
            @SerializedName("playing")
            val playing: Int, // 67
            @SerializedName("toplay")
            val toplay: Int, // 217
            @SerializedName("yet")
            val yet: Int // 388
        )

        data class EsrbRating(
            @SerializedName("id")
            val id: Int, // 3
            @SerializedName("name")
            val name: String, // Teen
            @SerializedName("name_en")
            val nameEn: String, // Teen
            @SerializedName("name_ru")
            val nameRu: String, // С 13 лет
            @SerializedName("slug")
            val slug: String // teen
        )

        data class Genre(
            @SerializedName("id")
            val id: Int, // 3
            @SerializedName("name")
            val name: String, // Adventure
            @SerializedName("slug")
            val slug: String // adventure
        )

        data class ParentPlatform(
            @SerializedName("platform")
            val platform: Platform
        ) {
            data class Platform(
                @SerializedName("id")
                val id: Int, // 1
                @SerializedName("name")
                val name: String, // PC
                @SerializedName("slug")
                val slug: String // pc
            )
        }

        data class Platform(
            @SerializedName("platform")
            val platform: Platform
        ) {
            data class Platform(
                @SerializedName("id")
                val id: Int, // 4
                @SerializedName("name")
                val name: String, // PC
                @SerializedName("slug")
                val slug: String // pc
            )
        }

        data class Rating(
            @SerializedName("count")
            val count: Int, // 2618
            @SerializedName("id")
            val id: Int, // 5
            @SerializedName("percent")
            val percent: Double, // 61.04
            @SerializedName("title")
            val title: String // exceptional
        )

        data class ShortScreenshot(
            @SerializedName("id")
            val id: Int, // -1
            @SerializedName("image")
            val image: String // https://media.rawg.io/media/games/7fa/7fa0b586293c5861ee32490e953a4996.jpg
        )

        data class Store(
            @SerializedName("store")
            val store: Store
        ) {
            data class Store(
                @SerializedName("id")
                val id: Int, // 1
                @SerializedName("name")
                val name: String, // Steam
                @SerializedName("slug")
                val slug: String // steam
            )
        }

        data class Tag(
            @SerializedName("games_count")
            val gamesCount: Int, // 201988
            @SerializedName("id")
            val id: Int, // 31
            @SerializedName("image_background")
            val imageBackground: String, // https://media.rawg.io/media/games/310/3106b0e012271c5ffb16497b070be739.jpg
            @SerializedName("language")
            val language: String, // eng
            @SerializedName("name")
            val name: String, // Singleplayer
            @SerializedName("slug")
            val slug: String // singleplayer
        )
    }
}
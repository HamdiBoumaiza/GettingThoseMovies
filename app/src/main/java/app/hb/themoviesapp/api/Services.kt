package app.hb.themoviesapp.api

import app.hb.themoviesapp.api.response.TopMoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("movie/top_rated")
    fun getTopMovies(@Query("api_key") apiKey: String,
                     @Query("page") pageId: Int)
            : Single<TopMoviesResponse>

}
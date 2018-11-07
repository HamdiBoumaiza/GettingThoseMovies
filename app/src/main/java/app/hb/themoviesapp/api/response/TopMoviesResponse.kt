package app.hb.themoviesapp.api.response

import app.hb.themoviesapp.model.MovieModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class TopMoviesResponse(@SerializedName("page")
                             @Expose
                             var page: Int? = null,

                             @SerializedName("results")
                             @Expose
                             var results: List<MovieModel> = ArrayList(),

                             @SerializedName("total_results")
                             @Expose
                             var totalResults: Int? = null,

                             @SerializedName("total_pages")
                             @Expose
                             var totalPages: Int? = null)




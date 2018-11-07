package app.hb.themoviesapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import app.hb.themoviesapp.BuildConfig
import app.hb.themoviesapp.api.Client
import app.hb.themoviesapp.api.Services
import app.hb.themoviesapp.model.MovieModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MoviesRepository {


    fun getMoviesWS(page: Int): LiveData<List<MovieModel>> {
        val data = MutableLiveData<List<MovieModel>>()
        val apiService = Client().getClient().create(Services::class.java)

        apiService.getTopMovies(
                BuildConfig.API_KEY, page)
                .retry(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response ->
                    data.setValue(response.results)

                }, { throwable ->
                    Timber.e("onError ws :: " + throwable.message)
                })
        return data
    }


}
package app.hb.thenewsapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import app.hb.thenewsapp.BuildConfig
import app.hb.thenewsapp.api.Client
import app.hb.thenewsapp.api.Services
import app.hb.thenewsapp.model.MovieModel
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
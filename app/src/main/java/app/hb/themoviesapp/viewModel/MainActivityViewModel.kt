package app.hb.themoviesapp.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import app.hb.themoviesapp.repository.MoviesRepository
import app.hb.themoviesapp.model.MovieModel


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val photosRepository = MoviesRepository()


    fun getArrayPhotos(page: Int): LiveData<List<MovieModel>> {
        return photosRepository.getMoviesWS(page)
    }








    /*
    fun getAdapter(): MovieAdapter {
        return adapter
    }

     fun setData(list: List<MovieModel>?) {
         arrayMovies =  list!!
    }


    fun init(){
       // adapter = MovieAdapter(this, this, arrayMovies!!)
    }

*/
}
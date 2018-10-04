package app.hb.thenewsapp.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import app.hb.thenewsapp.IUserClickListener
import app.hb.thenewsapp.repository.MoviesRepository
import app.hb.thenewsapp.adapter.UserAdapter
import app.hb.thenewsapp.model.MovieModel


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val photosRepository = MoviesRepository()


    fun getArrayPhotos(page: Int): LiveData<List<MovieModel>> {
        return photosRepository.getMoviesWS(page)
    }








    /*
    fun getAdapter(): UserAdapter {
        return adapter
    }

     fun setData(list: List<MovieModel>?) {
         arrayMovies =  list!!
    }


    fun init(){
       // adapter = UserAdapter(this, this, arrayMovies!!)
    }

*/
}
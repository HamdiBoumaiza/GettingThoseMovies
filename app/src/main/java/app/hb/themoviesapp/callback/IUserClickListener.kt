package app.hb.themoviesapp.callback

import app.hb.themoviesapp.model.MovieModel

interface IUserClickListener{
    fun clickTitle(movie:MovieModel)
    fun clickImage(postion:Int)
}
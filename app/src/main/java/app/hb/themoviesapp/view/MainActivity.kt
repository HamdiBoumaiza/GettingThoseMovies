package app.hb.themoviesapp.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import app.hb.themoviesapp.R
import app.hb.themoviesapp.adapter.MovieAdapter
import app.hb.themoviesapp.callback.IUserClickListener
import app.hb.themoviesapp.databinding.ActivityMainBinding
import app.hb.themoviesapp.model.MovieModel
import app.hb.themoviesapp.utils.toast
import app.hb.themoviesapp.viewModel.MainActivityViewModel


class MainActivity : AppCompatActivity(), IUserClickListener {
    override fun clickTitle(movieModel: MovieModel) {
        this.toast("Movie Title :: " + movieModel.title)
    }

    override fun clickImage(position: Int) {
        this.toast("image clicked " + position)
    }


    private lateinit var activityBinding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var adapter: MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        subscribeToModel()
    }


    private fun subscribeToModel() {
        mainActivityViewModel.getArrayPhotos(1).observe(this, object : Observer<List<MovieModel>> {
            override fun onChanged(list: List<MovieModel>?) {
                if (list != null) {
                    init(list)
                }
            }
        })
    }

    fun init(arrayMovies: List<MovieModel>) {
        val linearLayoutManager = LinearLayoutManager(this)
        activityBinding.rvSources.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(activityBinding.rvSources.getContext(), linearLayoutManager.orientation)
        activityBinding.rvSources.addItemDecoration(dividerItemDecoration)

        adapter = MovieAdapter(this, arrayMovies)
        activityBinding.rvSources.adapter = adapter

    }


}

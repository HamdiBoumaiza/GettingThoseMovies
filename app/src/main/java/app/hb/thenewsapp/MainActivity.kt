package app.hb.thenewsapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import app.hb.thenewsapp.adapter.UserAdapter
import app.hb.thenewsapp.databinding.ActivityMainBinding
import app.hb.thenewsapp.model.MovieModel
import app.hb.thenewsapp.utils.toast
import app.hb.thenewsapp.viewModel.MainActivityViewModel


class MainActivity : AppCompatActivity(), IUserClickListener {
    override fun clickTitle(postion: Int) {
        this.toast("title clicked "+postion)
    }

    override fun clickImage(postion: Int) {
        this.toast("image clicked "+postion)
    }


    private lateinit var activityBinding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var adapter: UserAdapter


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

        adapter = UserAdapter(this, arrayMovies)
        activityBinding.rvSources.adapter = adapter

    }


}

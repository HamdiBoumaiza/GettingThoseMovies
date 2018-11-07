package app.hb.themoviesapp.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.hb.themoviesapp.BR
import app.hb.themoviesapp.callback.IUserClickListener
import app.hb.themoviesapp.R
import app.hb.themoviesapp.databinding.ItemSourceBinding
import app.hb.themoviesapp.model.MovieModel

class MovieAdapter(var monClickListener: IUserClickListener,
                   var mListUser: List<MovieModel>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemSourceBinding: ItemSourceBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_source, parent, false)
        return ViewHolder(itemSourceBinding)
    }


    override fun getItemCount(): Int {
        return  mListUser.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mListUser[position],position)

    }

    inner class ViewHolder(view: ItemSourceBinding) : RecyclerView.ViewHolder(view.root) {
        private var itemSourceBinding: ItemSourceBinding

        init {
            itemSourceBinding = view
        }

        fun bind(model: MovieModel,position: Int) {
            itemSourceBinding.setMovies(model)
            itemSourceBinding.setVariable(BR.position,position)
            itemSourceBinding.setVariable(BR.clickListener,monClickListener)
        }
    }


}
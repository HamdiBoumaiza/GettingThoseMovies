package app.hb.thenewsapp.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.hb.thenewsapp.BR
import app.hb.thenewsapp.IUserClickListener
import app.hb.thenewsapp.R
import app.hb.thenewsapp.databinding.ItemSourceBinding
import app.hb.thenewsapp.model.MovieModel

class UserAdapter(var monClickListener: IUserClickListener,
                  var mListUser: List<MovieModel>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

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


    inner class ViewHolder(view: ItemSourceBinding) : RecyclerView.ViewHolder(view.root), View.OnClickListener {
        private var itemSourceBinding: ItemSourceBinding

        init {
            itemSourceBinding = view
            view.nom.setOnClickListener(this)
        }

        fun bind(model: MovieModel,position: Int) {
            itemSourceBinding.setMovies(model)
            itemSourceBinding.setVariable(BR.position,position)
            itemSourceBinding.setVariable(BR.clickListener,monClickListener)
        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.nom -> monClickListener.clickTitle(adapterPosition)
            }
        }

    }


}
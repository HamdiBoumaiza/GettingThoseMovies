package app.hb.thenewsapp.utils

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

@BindingAdapter(value = *arrayOf("imageUrl", "bind:movieIndicator"))
fun bindArticleImage(articleImage: ImageView, url: String, progressWheel: ProgressBar) {
    if (!TextUtils.isEmpty(url)) {
        Glide.with(articleImage.context)
                .load(Constants().IMAGE_PREFIX + url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable>,
                                              isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>,
                                                 dataSource: DataSource, isFirstResource: Boolean): Boolean {
                        progressWheel.setVisibility(View.GONE)
                        return false
                    }
                })
                .into(articleImage)
    }

}

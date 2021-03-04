package tech.gamedev.pewdiepietv.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.firebase.ui.firestore.paging.FirestorePagingAdapter
import com.firebase.ui.firestore.paging.FirestorePagingOptions
import kotlinx.android.synthetic.main.item_featured.view.*
import tech.gamedev.pewdiepietv.R
import tech.gamedev.pewdiepietv.data.models.Video



class FeaturedItemsAdapter (options: FirestorePagingOptions<Video>, private val glide: RequestManager) : FirestorePagingAdapter<Video, FeaturedItemsAdapter.FeaturedViewHolder>(options) {


    inner class FeaturedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedViewHolder {
        return FeaturedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_featured, parent, false))
    }

    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int, model: Video) {
        holder.itemView.apply {
            glide.load(model.thumbnailUrl).into(ivThumbnail)
            tvTitle.text = model.videoTitle
        }

        Log.d("VIEWPAGER", model.toString())
    }
}



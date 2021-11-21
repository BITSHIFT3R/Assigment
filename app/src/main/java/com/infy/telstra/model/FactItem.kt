package com.infy.telstra.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.infy.telstra.R

@Entity
data class FactItem(
    val title: String?,
    val description: String?,
    val imageHref: String?
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0 //**do not made it val**
    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl: String?) {
            if (imageUrl != null) {
                Glide.with(imageView).load(imageUrl).error(R.drawable.ic_baseline_block_24)
                    .placeholder(R.drawable.ic_baseline_block_24)
                    .into(imageView)
            } else {
                imageView.setImageResource(R.drawable.ic_baseline_block_24)
            }
        }
    }
}
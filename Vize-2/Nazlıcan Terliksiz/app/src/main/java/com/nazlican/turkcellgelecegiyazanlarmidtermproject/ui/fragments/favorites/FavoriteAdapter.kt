package com.nazlican.turkcellgelecegiyazanlarmidtermproject.ui.fragments.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.data.model.Product
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.databinding.ItemViewFavoriteBinding

class FavoriteAdapter(
    private val onProductClickListener: (Int) -> Unit,
    private val onProductDeleteClickListener: (Int) -> Unit,
) :

    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    private val favoriteList = ArrayList<Product>()

    inner class FavoriteViewHolder(val binding: ItemViewFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteAdapter.FavoriteViewHolder {
        val binding =
            ItemViewFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun getItemCount(): Int = favoriteList.size

    override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteViewHolder, position: Int) {
        val product = favoriteList[position]

        product.images.get(0)?.let { imageUrl ->
            Glide.with(holder.binding.favoriteProductIv)
                .load(imageUrl)
                .into(holder.binding.favoriteProductIv)
        }
        holder.binding.favoriteProductNameTv.text = product.title
        holder.binding.priceTv.text = product.price.toString()
        holder.binding.ratingBar.rating = product.rating.toFloat()

        holder.binding.root.setOnClickListener {
            onProductClickListener.invoke(product.id)
        }
        holder.binding.favoriteIv.setOnClickListener {
            onProductDeleteClickListener.invoke(product.id)
        }
    }
    fun updateList(updateList: List<Product>) {
        favoriteList.clear()
        favoriteList.addAll(updateList)
        notifyDataSetChanged()
    }
}
package com.bugcompany.dummyjsonapp.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.bugcompany.dummyjsonapp.data.model.product.Product
import com.bugcompany.dummyjsonapp.databinding.ProductCardBinding
import com.bumptech.glide.Glide

//Bu özel RecyclerView adaptörü, veriler değiştiğinde RecyclerView'i verimli bir şekilde güncellemek için DiffUtil kullanır.
// Bu, büyük veri kümeleri için önemli bir performans iyileştirmesidir.
// Normal Recyclerview de kullanılan notifyDataSetChanged() yöntemi büyük veri kümelerinde performans kaybı yaşatabilir.

class ProductListAdapter : ListAdapter<Product, ProductListAdapter.ProductViewHolder>(ProductDiffUtilCallback) {

    var onProductClick: (Product) -> Unit = {}

    class ProductViewHolder(private val binding: ProductCardBinding, private val onProductClick: (Product) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            with(binding) {
                txtTitle.text = product.title
                txtPrice.text = "${product.price} $"
                Glide.with(imgProduct).load(product.images?.get(0)).into(imgProduct)
                //Cardview tıklanınca detaya gidecektir.
                  cardview.setOnClickListener {onProductClick(product)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ProductCardBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(binding,onProductClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(currentList[position])

}

object ProductDiffUtilCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem

}
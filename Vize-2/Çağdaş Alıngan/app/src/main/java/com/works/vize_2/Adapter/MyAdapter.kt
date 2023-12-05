package com.works.vize_2.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.works.vize_2.ProductDetail
import com.works.vize_2.databinding.RecyclerItemBinding
import com.works.vize_2.models.Product

class MyAdapter (private val list : List<Product>) : RecyclerView.Adapter<MyAdapter.Hold> () {
    class Hold(val binding : RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Hold {
        val infilater = LayoutInflater.from(parent.context)
        val view = RecyclerItemBinding.inflate(infilater,parent,false)
        return Hold(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Hold, position: Int) {
        val currentItem = list[position]

        holder.binding.apply {
            txtUrun.text = currentItem.title
            txtFiyat.text = "Price : ${currentItem.price}"
            txtDetay.text = currentItem.description
            txtRate.text = "Rating : ${currentItem.rating}"

            Glide.with(root.context)
                .load(currentItem.thumbnail)
                .into(imageView)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDetail::class.java)
            intent.putExtra("product" , currentItem)
            holder.itemView.context.startActivity(intent)
        }

    }

}
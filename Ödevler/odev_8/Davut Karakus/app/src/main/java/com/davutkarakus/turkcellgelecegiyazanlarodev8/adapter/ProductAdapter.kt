package com.davutkarakus.turkcellgelecegiyazanlarodev8.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davutkarakus.turkcellgelecegiyazanlarodev8.Util.downloadFromUrl
import com.davutkarakus.turkcellgelecegiyazanlarodev8.Util.placeholderProgressBar
import com.davutkarakus.turkcellgelecegiyazanlarodev8.databinding.RecyclerRowBinding
import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.Product
import com.davutkarakus.turkcellgelecegiyazanlarodev8.view.DetailActivity

class ProductAdapter(private var productList:List<Product>) : RecyclerView.Adapter<ProductAdapter.RvHolder>() {
    class RvHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view = RecyclerRowBinding.inflate(inflater,parent,false)
        return RvHolder(view)
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        holder.binding.imageView.downloadFromUrl(productList[position].thumbnail,
            placeholderProgressBar(holder.itemView.context))
        holder.binding.nameText.text = "${productList[position].title}"
        holder.binding.priceText.text = "Price : ${productList[position].price} $"
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("product_id", productList[position].id)
            intent.putExtra("product_name",productList[position].title)
            holder.itemView.context.startActivity(intent)
        }
    }
}
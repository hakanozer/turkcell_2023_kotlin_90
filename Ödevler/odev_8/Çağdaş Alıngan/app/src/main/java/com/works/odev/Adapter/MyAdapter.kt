package com.works.odev.Adapter


import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.works.odev.ProductDetail
import com.works.odev.databinding.RecyclerItemBinding
import com.works.odev.model.Product


class MyAdapter(private var list :List<Product>) : RecyclerView.Adapter<MyAdapter.Hold>() {

    class Hold(val binding: RecyclerItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Hold {
        val inflater = LayoutInflater.from(parent.context)
        val view = RecyclerItemBinding.inflate(inflater,parent,false)
        return Hold(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Hold, position: Int) {
        val currentItem = list[position]


        holder.binding.apply {
            // Örneğin, ürün adını bağlama
            txtBaslK.text = currentItem.title

            // Ürün fiyatını bağlama
            txtFiyat.text = "Price: ${currentItem.price}"

            // Ürün resmini Glide kütüphanesi kullanarak bağlama
            Glide.with(root.context)
                .load(currentItem.thumbnail)
                .into(imgUrun)

    }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,ProductDetail::class.java )
            intent.putExtra("product", currentItem)
            holder.itemView.context.startActivity(intent)
        }


}
    fun updateList(newList: List<Product>) {
        list = newList
        notifyDataSetChanged()
    }

}
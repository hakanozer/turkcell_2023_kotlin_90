package com.example.esmasalkim_vize2


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esmasalkim_vize2.models.Product
import com.squareup.picasso.Picasso
import java.io.Serializable


// receyclerView için özel bir adapter oluşturuldu.

class ProductAdapter(private var productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTittle: TextView = itemView.findViewById(R.id.txtTittle)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        val txtRating: TextView = itemView.findViewById(R.id.txtRating)
        val imageViewProduct: ImageView = itemView.findViewById(R.id.imageViewProduct)



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]


        Picasso.get()
            .load(product.images.firstOrNull())
            .into(holder.imageViewProduct)

        holder.txtTittle.text = product.title
        holder.txtPrice.text = "Price: ${product.price}\$"
        holder.txtRating.text = "Raiting: ${product.rating}/5"

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDetay::class.java)

            intent.putExtra("product",product as Serializable)
            holder.itemView.context.startActivity(intent)



        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateData(products: List<Product>) {
        productList = products
        notifyDataSetChanged()

    }



}
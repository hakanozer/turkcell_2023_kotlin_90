package com.example.muhammed_zeyd_satilmis_odev8.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.muhammed_zeyd_satilmis_odev8.R
import com.example.muhammed_zeyd_satilmis_odev8.databinding.CardProductRecyclerBinding
import com.example.muhammed_zeyd_satilmis_odev8.fragments.ProductFragmentDirections
import com.example.muhammed_zeyd_satilmis_odev8.models.Product


class RecyclerProductAdapter(private var dataList: List<Product>) :
    RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder>() {


    class ViewHolder(private val binding: CardProductRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imgProduct: ImageView = binding.imgProduct
        var txtPrice: TextView = binding.txtPrice
        var txtTitle: TextView = binding.txtTitle1


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerProductAdapter.ViewHolder {
        val productViewBinding = CardProductRecyclerBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,
            false
        )
        return ViewHolder(productViewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerProductAdapter.ViewHolder, position: Int) {
        val currentData = dataList[position]

        holder.txtPrice.text = "$${currentData.price}"
        holder.txtTitle.text = currentData.title

        Glide.with(holder.imgProduct).load(currentData.images[0]).placeholder(R.drawable.pass)
            .into(holder.imgProduct)

        holder.itemView.setOnClickListener {
            val route = ProductFragmentDirections.routeDetail(currentData)
            Navigation.findNavController(it).navigate(route)
        }


    }

    fun setFilteredList(filteredList: ArrayList<Product>) {

        this.dataList = filteredList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

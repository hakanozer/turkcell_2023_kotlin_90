package com.appsroved.muhammed_zeyd_satilmis_vize2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.appsroved.muhammed_zeyd_satilmis_vize2.R
import com.appsroved.muhammed_zeyd_satilmis_vize2.databinding.CardProductListRvBinding
import com.appsroved.muhammed_zeyd_satilmis_vize2.models.Product
import com.appsroved.muhammed_zeyd_satilmis_vize2.views.ProductsListFragment
import com.appsroved.muhammed_zeyd_satilmis_vize2.views.ProductsListFragmentDirections
import com.bumptech.glide.Glide

class CustomRVProductListAdapter(private var dataList: ArrayList<Product>) :
    RecyclerView.Adapter<CustomRVProductListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: CardProductListRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imgProduct: ImageView = binding.imgProduct
        var txtPrice: TextView = binding.txtPrice
        var txtTitle: TextView = binding.textViewTitle

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomRVProductListAdapter.ViewHolder {

        val productListView =
            CardProductListRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(productListView)
    }

    override fun onBindViewHolder(holder: CustomRVProductListAdapter.ViewHolder, position: Int) {
        val dataIndex = dataList[position]

        holder.txtPrice.text = "$${dataIndex.price}"
        holder.txtTitle.text = dataIndex.title

        Glide.with(holder.imgProduct).load(dataIndex.images[0]).placeholder(R.drawable.place_holder)
            .into(holder.imgProduct)

        holder.itemView.setOnClickListener {
            val route = ProductsListFragmentDirections.routeDetail(dataIndex)
            Navigation.findNavController(it).navigate(route)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

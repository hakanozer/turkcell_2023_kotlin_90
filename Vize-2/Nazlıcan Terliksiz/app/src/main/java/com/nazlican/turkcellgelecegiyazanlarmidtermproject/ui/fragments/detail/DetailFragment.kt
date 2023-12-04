package com.nazlican.turkcellgelecegiyazanlarmidtermproject.ui.fragments.detail

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.R
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.common.RetrofitClient
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.common.viewBinding
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.data.model.Product
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.databinding.FragmentDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val productService = RetrofitClient
    private lateinit var sp: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productId = arguments?.let { DetailFragmentArgs.fromBundle(it).id }

        if (productId != null) {
            getProduct(productId)

            binding.ivFav.setOnClickListener {
                favoriteProduct(productId)
                findNavController().navigate(R.id.action_detailFragment_to_favoritesFragment)
            }
        }

    }

    fun getProduct(id: Int) {
        productService.service?.getProductDetail(id)?.enqueue(object : Callback<Product> {

            override fun onResponse(
                call: Call<Product>,
                response: Response<Product>
            ) {
                if (response.isSuccessful) {
                    val product = response.body()
                    if (product != null) {

                        product.images.get(0)?.let { imageUrl ->
                            Glide.with(binding.productIv)
                                .load(imageUrl)
                                .into(binding.productIv)
                        }
                        binding.productTitleTv.text = product.title
                        binding.productRatingBar.rating = product.rating.toFloat()
                        binding.productDetailTv.text = product.description
                        binding.productPriceTv.text = product.price.toString()

                    } else {
                        Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
            }
        })
    }

    private fun favoriteProduct(productId: Int) {
        val sp = requireContext().getSharedPreferences("favoriteProducts", Context.MODE_PRIVATE)

        if (!sp.contains(productId.toString())) {
            sp.edit().putBoolean(productId.toString(), true).apply()
        }
    }
}
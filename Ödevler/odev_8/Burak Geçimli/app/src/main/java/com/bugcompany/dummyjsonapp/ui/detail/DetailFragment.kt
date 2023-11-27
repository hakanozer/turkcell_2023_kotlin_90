package com.bugcompany.dummyjsonapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bugcompany.dummyjsonapp.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    //args ile gelen verileri alırız.(product nesnesi gönderildi)
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.product.let { product ->
            with(binding) {
                txtDetailProductTitle.text = product.title
                txtDetailProductCategory.text = product.category
                txtDetailProductPrice.text = product.price.toString()
                Glide.with(imgDetailProduct).load(product.images?.get(0)).into(imgDetailProduct)
                txtDetailProductStock.text = product.stock.toString()
                txtDetailProductBrand.text = product.brand
                txtDetailproductDescription.text = product.description

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
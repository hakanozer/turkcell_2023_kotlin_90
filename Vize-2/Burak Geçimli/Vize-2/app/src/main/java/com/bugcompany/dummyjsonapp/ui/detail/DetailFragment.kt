package com.bugcompany.dummyjsonapp.ui.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bugcompany.dummyjsonapp.R
import com.bugcompany.dummyjsonapp.databinding.FragmentDetailBinding
import com.bugcompany.dummyjsonapp.ui.product.ProductLisViewModel
import com.bugcompany.dummyjsonapp.ui.product.ProductListFragmentDirections
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.productId
        val productDetailViewModel = DetailViewModel(id)


        productDetailViewModel.productDetail.observe(viewLifecycleOwner) { product ->
            with(binding) {
                txtDetailProductTitle.text = product?.title
                txtDetailProductCategory.text = product?.category
                txtDetailProductPrice.text = product?.price.toString()
                Glide.with(imgDetailProduct).load(product?.images?.get(0)).into(imgDetailProduct)
            }
        }

        binding.like.setOnClickListener {
            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
            val likedProducts =
                sharedPref?.getStringSet("liked_products", mutableSetOf()) ?: mutableSetOf()
            likedProducts.add(id.toString())
            sharedPref?.edit()?.putStringSet("liked_products", likedProducts)?.apply()
            Toast.makeText(requireContext(), "Like Fragment Add", Toast.LENGTH_SHORT).show()
        }


        binding.gotoLikeFragment.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToLikeFragment()
            findNavController().navigate(action)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
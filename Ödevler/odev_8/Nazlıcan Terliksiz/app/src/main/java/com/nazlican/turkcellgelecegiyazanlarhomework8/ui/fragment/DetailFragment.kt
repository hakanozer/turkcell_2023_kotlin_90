package com.nazlican.turkcellgelecegiyazanlarhomework8.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.nazlican.turkcellgelecegiyazanlarhomework8.R
import com.nazlican.turkcellgelecegiyazanlarhomework8.common.viewBinding
import com.nazlican.turkcellgelecegiyazanlarhomework8.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: DetailFragmentArgs by navArgs()
        Picasso.get().load(bundle.product.images.get(0)).into(binding.productIv)
        binding.productTitleTv.text = bundle.product.title
        binding.productPriceTv.text = bundle.product.price.toString()
    }
}
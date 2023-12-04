package com.appsroved.muhammed_zeyd_satilmis_vize2.views

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.appsroved.muhammed_zeyd_satilmis_vize2.R
import com.appsroved.muhammed_zeyd_satilmis_vize2.databinding.FragmentProductDetailBinding
import com.bumptech.glide.Glide


class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private val bundle: ProductDetailFragmentArgs by navArgs()
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailBinding.inflate(layoutInflater, container, false)

        viewInit()

        val sharedPreferences: SharedPreferences? =
            (context?.getSharedPreferences("ids", Context.MODE_PRIVATE))
                .also {
                    editor = it!!.edit()
                }



        binding.btnAdd.setOnClickListener {
            val id = bundle.product.id.toString()
            val setIds = mutableSetOf<String>()

            setIds.add(id)

            editor.putStringSet("id", setIds)

            Toast.makeText(context, "Favorilere Eklendi: $setIds", Toast.LENGTH_SHORT)
                .show()
        }

        return binding.root
    }

    private fun viewInit() {

        Glide.with(this).load(bundle.product.images[0]).placeholder(R.drawable.place_holder)
            .into(binding.imageView)

        binding.txtDtTitle.text = bundle.product.title
        binding.txtDtStock.text = bundle.product.stock.toString()
        binding.txtDtBrand.text = bundle.product.brand
        binding.txtDtPrice.text = bundle.product.price.toString()
        binding.txtDtRating.text = bundle.product.rating.toString()
        binding.txtDtDescription.text = bundle.product.description

    }


}

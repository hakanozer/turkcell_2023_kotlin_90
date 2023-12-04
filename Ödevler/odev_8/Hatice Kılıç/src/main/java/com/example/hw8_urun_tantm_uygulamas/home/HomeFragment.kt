package com.example.hw8_urun_tantm_uygulamas.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw8_urun_tantm_uygulamas.adapter.ProductAdapter
import com.example.hw8_urun_tantm_uygulamas.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val productAdapter by lazy { ProductAdapter() }
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    //kminchelle
    //0lelplR

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getProductResponse()

        binding.searchViewProduct.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    viewModel.getProductResponse()
                } else {
                    viewModel.getProductSearchResponse(newText)
                }
                return true
            }
        })

        binding.recyclerViewProduct.adapter = productAdapter
        productAdapter.onClickListener = {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    it
                )
            )
        }
        viewModel.productList.observe(viewLifecycleOwner) {
            it?.let {
                productAdapter.submitList(it)
                binding.recyclerViewProduct.adapter = productAdapter
            }
        }
    }
}
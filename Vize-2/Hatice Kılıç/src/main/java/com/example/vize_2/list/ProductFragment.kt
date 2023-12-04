package com.example.vize_2.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.vize_2.adapter.ProductAdapter
import com.example.vize_2.databinding.FragmentProductBinding


class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    private val productAdapter by lazy { ProductAdapter() }
    private val viewModel: ListViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProductBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
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
                ProductFragmentDirections.actionProductFragmentToDetailFragment(
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


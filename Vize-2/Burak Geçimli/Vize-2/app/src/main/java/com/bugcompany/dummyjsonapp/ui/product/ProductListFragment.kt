package com.bugcompany.dummyjsonapp.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bugcompany.dummyjsonapp.databinding.FragmentProductListBinding


class ProductListFragment : Fragment() {
    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private val productListAdapter by lazy { ProductListAdapter() }
    private val productListViewModel: ProductLisViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productListAdapter.onProductClick = { product ->
            val action =
                ProductListFragmentDirections.actionHomeFragmentToDetailFragment(product.id!!)
            findNavController().navigate(action)
        }


        productListViewModel.productList.observe(viewLifecycleOwner) {
            if (it != null) {
                productListAdapter.submitList(it)
                binding.rv.adapter = productListAdapter
                binding.rv.setHasFixedSize(true)
            } else {
                Toast.makeText(requireContext(), "Empty List", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // Bellek sızıntılarını önlemek için.
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}


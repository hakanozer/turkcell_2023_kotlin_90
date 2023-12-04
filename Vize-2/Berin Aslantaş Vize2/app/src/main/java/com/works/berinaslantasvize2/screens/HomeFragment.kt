package com.works.berinaslantasvize2.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.works.berinaslantasvize2.R
import com.works.berinaslantasvize2.adapters.CustomProductsAdapter
import com.works.berinaslantasvize2.config.ApiClient
import com.works.berinaslantasvize2.databinding.FragmentHomeBinding
import com.works.berinaslantasvize2.services.IProductService
import com.works.berinaslantasvize2.utils.Util.showToast
import com.works.berinaslantasvize2.viewModels.HomeViewModel


class HomeFragment : Fragment() {

    private  var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var customProductAdapter: CustomProductsAdapter
    private lateinit var navController: NavController
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerEvents()
        listenEvents()
    }

    private fun init(view : View){
        navController = Navigation.findNavController(view)
        customProductAdapter = CustomProductsAdapter(requireContext())
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.productService = ApiClient.getClient().create(IProductService::class.java)
        homeViewModel.getProducts()
    }

    private fun registerEvents(){
        binding.productsListView.adapter = customProductAdapter
        binding.productsListView.setOnItemClickListener { parent, view, position, id ->
            homeViewModel.products.value?.let {products ->
                val bundle = Bundle()
                bundle.putInt("productId", products[position].id)
                navController.navigate(R.id.action_homeFragment_to_productDetailFragment2,bundle)
            }
            true
        }

        binding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_cartFragment)
        }
    }

    private fun listenEvents(){
        homeViewModel.products.observe(viewLifecycleOwner){result ->
            result?.let { productList->
                customProductAdapter.submitList(productList)
                if(productList.isEmpty()){
                    binding.productsListView.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }else{
                    binding.productsListView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
            }
        }

        homeViewModel.isFailed.observe(viewLifecycleOwner){isFailed->
            if(isFailed){
                showToast("products could not be delivered")
                //homeViewModel.getProducts()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}


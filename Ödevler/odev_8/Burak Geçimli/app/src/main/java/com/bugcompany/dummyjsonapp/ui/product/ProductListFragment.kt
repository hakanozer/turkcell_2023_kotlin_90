package com.bugcompany.dummyjsonapp.ui.product

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugcompany.dummyjsonapp.databinding.FragmentProductListBinding
import com.bugcompany.dummyjsonapp.util.getShare

class ProductListFragment : Fragment() {
    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    //İlk kez erişilediğinde oluşturularak gereksiz performans kaybı önlenir.
    private val productListAdapter by lazy { ProductListAdapter() }
    private val productListViewModel: ProductLisViewModel by viewModels()

    //onCreateView içinde sadece binding bağlama işlemi yapılır.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Context sınıfına yazılan getShare adında ki extension fonksiyonu kullanıldı.
        val user = requireActivity().getShare()
        if (user != null) {
            user.token?.let { Log.d("token", it) }
        }

        //İlgili product nesnesinin DetailFragmentine taşınmasını sağlayan kod.
        productListAdapter.onProductClick = { product ->
            val action = ProductListFragmentDirections.actionHomeFragmentToDetailFragment(product)
            findNavController().navigate(action)
        }


        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    productListViewModel.products() //Kullanıcı seçimini temizlerse tüm listenin gelmesini sağlayan kod.
                } else {
                    productListViewModel.searchProducts(newText) //Kullanıcının seçimine göre filtrelenen listenin gelmesini sağlayan kod.
                }
                return true
            }
        })


        //ProductListViewModel'dan gelen productList LiveDatasını gözlemler ve ürün listesi değiştiğinde RecyclerView'i günceller.
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


package com.works.berinaslantasvize2.screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.vize2.viewModels.ProductDetailViewModel
import com.works.berinaslantasvize2.R
import com.works.berinaslantasvize2.config.ApiClient
import com.works.berinaslantasvize2.databinding.FragmentProductDetailBinding
import com.works.berinaslantasvize2.models.CartPostProduct
import com.works.berinaslantasvize2.models.Product
import com.works.berinaslantasvize2.services.ILikedProductsService
import com.works.berinaslantasvize2.services.IProductService
import com.works.berinaslantasvize2.utils.Util.showToast

class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private lateinit var productDetailViewModel: ProductDetailViewModel
    private var productId: Int? = null
    private var product: Product? = null

    private lateinit var sharedPreferences: SharedPreferences
    private val likedProductsKey = "likedProducts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            productId = bundle.getInt("productId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        registerEvents()
        listenEvents()
    }

    private fun init(view: View) {
        navController = Navigation.findNavController(view)
        productDetailViewModel = ViewModelProvider(this)[ProductDetailViewModel::class.java]
        productDetailViewModel.productService = ApiClient.getClient().create(IProductService::class.java)
        productDetailViewModel.cartService = ApiClient.getClient().create(ILikedProductsService::class.java)
        if (productId != null) {
            productDetailViewModel.getProduct(productId!!)
        }

        sharedPreferences =
            requireActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
    }

    private fun registerEvents() {
        binding.btnFav.setOnClickListener {
            product?.let {
                var cartPostProductList = mutableListOf<CartPostProduct>()
                val cartPostProduct = CartPostProduct(it.id, 1)
                cartPostProductList.add(cartPostProduct)

                likeProduct(it.id.toString())

                productDetailViewModel.addToCart(cartPostProductList)

                val resId = R.id.likedProductsFragment
                navController.navigate(resId)
            }
        }
    }

    private fun setProductFields() {
        product?.let { currentProduct ->
            Glide.with(this).load(currentProduct.images[0]).into(binding.imgProductImage)
            binding.txtTitle.text = currentProduct.title
            binding.txtDescription.text = currentProduct.description
            binding.txtPrice.text = "Price: " + currentProduct.price.toString() + " $"
            binding.txtRate.text = currentProduct.rating.toString()
            binding.txtBrand.text = currentProduct.brand
            binding.txtStock.text = "Stock: " + currentProduct.stock
        }
    }

    private fun listenEvents() {
        productDetailViewModel.product.observe(viewLifecycleOwner) { result ->
            result?.let { currentProduct ->
                product = currentProduct
                setProductFields()
            }
        }

        productDetailViewModel.isAddFailed.observe(viewLifecycleOwner) { result ->
            result?.let {
                if (it) {
                    showToast("Order Success")
                } else {
                    showToast("Order Failed")
                }
            }
        }
    }

    private fun likeProduct(productId: String) {
        val likedProducts = getLikedProducts()

        if (!likedProducts.contains(productId)) {
            likedProducts.add(productId)

            val editor = sharedPreferences.edit()
            editor.putStringSet(likedProductsKey, likedProducts)
            editor.apply()

            showToast("Ürün başarıyla beğenildi!")
        } else {
            showToast("Bu ürün zaten beğenildi!")
        }
    }

    private fun getLikedProducts(): MutableSet<String> {
        return sharedPreferences.getStringSet(likedProductsKey, mutableSetOf()) ?: mutableSetOf()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

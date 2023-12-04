package com.example.vize2.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.works.berinaslantasvize2.models.Cart
import com.works.berinaslantasvize2.models.CartPost
import com.works.berinaslantasvize2.models.CartPostProduct
import com.works.berinaslantasvize2.models.Product
import com.works.berinaslantasvize2.services.ILikedProductsService
import com.works.berinaslantasvize2.services.IProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailViewModel : ViewModel() {

    var product = MutableLiveData<Product?>()
    var productService : IProductService? = null
    var cartService : ILikedProductsService? = null
    var isFailed = MutableLiveData<Boolean>()
    var isAddFailed = MutableLiveData<Boolean>()

    fun getProduct(id : Int){
        productService?.getProductById(id)?.enqueue(object : Callback<Product?>{
            override fun onResponse(call: Call<Product?>, response: Response<Product?>) {
                val response = response.body()
                if(response != null){
                    product.value = response
                    isFailed.value = false
                }
            }

            override fun onFailure(call: Call<Product?>, t: Throwable) {
                isFailed.value = true
            }

        })
    }

    fun addToCart(cartPostProducts : List<CartPostProduct>){
        val cartPost = CartPost(1,cartPostProducts)
        cartService?.addToCart(cartPost)?.enqueue(object : Callback<Cart>{
            override fun onResponse(call: Call<Cart>, response: Response<Cart>) {
                val response = response.body()
                Log.e("response",response.toString())
                if(response != null){
                    isAddFailed.value = false
                }
            }

            override fun onFailure(call: Call<Cart>, t: Throwable) {
                isAddFailed.value = true
            }

        })
    }
}
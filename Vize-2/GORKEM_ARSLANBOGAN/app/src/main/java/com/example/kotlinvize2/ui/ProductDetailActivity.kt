package com.example.kotlinvize2.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinvize2.R
import com.example.kotlinvize2.databinding.ActivityProductDetailBinding
import com.example.kotlinvize2.helper.Utils
import com.example.kotlinvize2.helper.shared.SharedManagment
import com.example.kotlinvize2.model.Product
import com.example.kotlinvize2.viewmodel.ProductDetaiViewModel
import com.google.gson.Gson

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    private var product: Product? = null
    private lateinit var viewModel: ProductDetaiViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentDataAndTurnProductModel()
        viewModel = ViewModelProvider(this)[ProductDetaiViewModel::class.java]
        //viewmodel aracığıyla shared'tan verileri alıp kontrol ediyorum.

        product.let {
            viewModel.checkProductIsFavorite(product!!.id.toString())
        }
        //eğer ürün id'leri shared'ta bulunuyorsa favoriye ekleme butonunu gizliyoruz.
        viewModel.productsIsFavorite.observe(this){
            binding.addFavorite.visibility = if(it) View.GONE else View.VISIBLE
        }

        //favori butonuna tıklanırsa viewmodel ile shared'a datayı gönderiyoruz.
        binding.addFavorite.setOnClickListener {
            product.let {
                if(viewModel.addFavorite(product!!)){
                    Utils.showShortToast(applicationContext, applicationContext.getString(R.string.str_favorilere_eklendi))
                    binding.addFavorite.visibility = View.GONE
                }else {
                    Utils.showShortToast(applicationContext, applicationContext.getString(R.string.str_hata))
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setProductDataInUIComponent(product: Product){
        binding.productNameTextview.text = product.title
        binding.productDescTextview.text = product.description
        binding.productPriceTextview.text = "${applicationContext.getString(R.string.str_fiyat)}: ${product.price} ${applicationContext.getString(R.string.str_tl)}"
        binding.productStockTextview.text = "${applicationContext.getString(R.string.str_stok)}: ${product.price}"
        binding.productRate.text = "${applicationContext.getString(R.string.str_puan)}: ${product.rating}"
        binding.productCategory.text = "${applicationContext.getString(R.string.str_kategori)}: ${product.category}"
        if(product.images.isNotEmpty()) {
            Utils.getImageByURL(applicationContext, product.images[0], binding.productImage)
        }
    }


    private fun getIntentDataAndTurnProductModel(){
        val productJson = intent.getStringExtra(Utils.INTENT_DATA_KEY)
        if(!productJson.isNullOrEmpty()) {
            product = Gson().fromJson(productJson, Product::class.java)
            product.let {
                setProductDataInUIComponent(product!!)
            }
        }
    }
}
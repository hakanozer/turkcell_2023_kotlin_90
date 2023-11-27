package com.bugcompany.dummyjsonapp.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bugcompany.dummyjsonapp.data.source.repository.ProductRepository
import com.bugcompany.dummyjsonapp.data.model.product.Product

//Bu sınıf, ürünlerle ilgili verileri yönettiğimiz bir ViewModel classıdır.
//productRepository adında bir ProductRepository nesnesi kullanarak,
// API'den ürün verilerini alır ve bu verileri LiveData nesnelerinde saklar.

class ProductLisViewModel : ViewModel() {
    val productRepository = ProductRepository()
    private var _productList = MutableLiveData<List<Product>?>()

    val productList: LiveData<List<Product>?>
        get() = _productList

    //products() metodu ProductLisViewModel sınıfının  dışında çağrılsaydı, her seferinde ürün verileri alınırdı.
    // Bu, gereksiz API çağrılarına ve performans kaybına neden olabilirdi.
    // init bloğu ile ProductLisViewModel sınıfı oluşturulduğunda bir kez çağrılır. Bu, ürün verilerinin yalnızca bir kez alınmasını sağlar.
    init {
        products()
    }

    fun products() {
        productRepository.getProducts()
        _productList = productRepository.productList
    }

    fun searchProducts(query: String) {
        productRepository.searchProducts(query)
        _productList=productRepository.productList
    }
}
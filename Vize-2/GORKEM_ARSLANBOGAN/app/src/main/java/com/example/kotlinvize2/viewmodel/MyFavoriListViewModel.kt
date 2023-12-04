import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinvize2.helper.shared.SHARED_KEY
import com.example.kotlinvize2.helper.shared.SharedManagment
import com.example.kotlinvize2.model.Product
import com.example.kotlinvize2.repository.DummyServiceRepository
import kotlinx.coroutines.launch

class MyFavoriListViewModel : ViewModel() {
    private val repository: DummyServiceRepository by lazy { DummyServiceRepository() }
    private val _products = MutableLiveData<MutableList<Product>>()
    val products: LiveData<MutableList<Product>> get() = _products
    var singleProductLiveData = MutableLiveData<Product>()

    init {
        loadProducts()
    }

    //bütün ürünleri apiden çektikten sonra ekrana haber verip kullanıcıya gösteriyoruz.
    fun loadProducts() {
        viewModelScope.launch {
            val productIds = SharedManagment.getMyFavoriteList(SHARED_KEY.SAVE_ALL_PRODUCT.name)
            val updatedList = mutableListOf<Product>()
            productIds.forEach { productId ->
                val product = repository.getProductById(productId.toString())
                updatedList.add(product)
            }
            _products.postValue(updatedList)
        }
    }

    fun getProductById(productId: String) {
        viewModelScope.launch{
            val product = repository.getProductById(productId)
            product.let {
                singleProductLiveData.postValue(product)
            }
        }
    }
}

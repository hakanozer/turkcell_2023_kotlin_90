package com.example.esmasalkim_odev8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.esmasalkim_odev8.models.Product
import org.json.JSONArray
import org.json.JSONObject



class ProductActivity : AppCompatActivity() {

    private lateinit var productAdapter: ProductAdapter
    private lateinit var allProducts: List<Product>
    private lateinit var product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)



        val searchView: SearchView = findViewById(R.id.searchView)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)



        productAdapter = ProductAdapter(emptyList())
        recyclerView.adapter = productAdapter

        val queue: RequestQueue = Volley.newRequestQueue(this)
        val url = "https://dummyjson.com/products?limit=10"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                allProducts = parseProducts(response)
                productAdapter.updateData(allProducts)
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
            }
        )

        queue.add(jsonObjectRequest)

        // SearchView için dinleyici eklendi
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Arama sırasında filtreleme işlemi
                val filteredProducts = filterProducts(newText.orEmpty())
                productAdapter.updateData(filteredProducts)
                return true
            }
        })

    }



    private fun filterProducts(query: String): List<Product> {
        return allProducts.filter { it.title.contains(query, ignoreCase = true) }
    }

    private fun parseProducts(json: JSONObject): List<Product> {
        val productsList = mutableListOf<Product>()
        val productsArray: JSONArray = json.getJSONArray("products")

        for (i in 0 until productsArray.length()) {
            val productObject = productsArray.getJSONObject(i)
            val id = productObject.getLong("id")
            val title = productObject.getString("title")
            val description = productObject.getString("description")
            val price = productObject.getLong("price")
            val discountPercentage = productObject.getDouble("discountPercentage")
            val rating = productObject.getDouble("rating")
            val stock = productObject.getLong("stock")
            val brand = productObject.getString("brand")
            val category = productObject.getString("category")
            val thumbnail = productObject.getString("thumbnail")
            val imagesArray = productObject.getJSONArray("images")
            val images = mutableListOf<String>()

            for (j in 0 until imagesArray.length()) {
                images.add(imagesArray.getString(j))
            }

            val product = Product(id, title, description, price, discountPercentage, rating, stock, brand, category,  thumbnail, images)
            productsList.add(product)
        }

        return productsList
    }
}


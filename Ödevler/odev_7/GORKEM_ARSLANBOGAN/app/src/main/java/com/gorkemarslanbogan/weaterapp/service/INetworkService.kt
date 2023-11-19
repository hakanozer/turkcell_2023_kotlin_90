package com.gorkemarslanbogan.weaterapp.service

import com.gorkemarslanbogan.weaterapp.model.DocumentModel
import com.gorkemarslanbogan.weaterapp.model.WeatherModel
import org.jsoup.select.Elements
import org.w3c.dom.Document

//burada 2 farklı interface'in kullanılma sebebi gereksiz kod tekrarı önlemektir
// INetworkService, IDataParser servis işlemleriyle ilgili ama tek bir interface'te kullansaydım
// DataParser sınıfında getWeaterOfCity gereksiz yere implements edilecek
// ve NetworkManager sınıfında weatherDataParser gereksiz yere implements edilip tek sorumluluk ilkesine
// aykırı davranıcaktı..

interface INetworkService {
    fun getWeaterOfCity() : Elements?
}

interface IDataParser {
    fun weatherDataParser() : List<WeatherModel>
 }
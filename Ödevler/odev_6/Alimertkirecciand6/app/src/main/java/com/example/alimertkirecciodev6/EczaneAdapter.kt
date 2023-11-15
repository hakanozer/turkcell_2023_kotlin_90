package com.example.alimertkirecciodev6

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
/*
@SuppressLint("ViewHolder") ifadesi,
 Android Studio tarafından sunulan bir kod uyarısı
 (lint warning) için bir "suppress" (bastırma) işlemidir. B
 u ifade, Android Studio'nun kod analizi sırasında belirli bir
 uyarıyı görmezden gelmenizi sağlar.
* */
class EczaneAdapter (context: Context, val eczaneListeleri: List<NobetciEczane>) : ArrayAdapter<NobetciEczane>(context, R.layout.nobetci_eczane_listesi, eczaneListeleri) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val eczane = getItem(position)
/*
* Bu kodda ViewHolder sınıfının içinde kullanılan yapı,
* Android Studio'nun bazen "ViewHolder inner class should be static"
*  şeklinde bir uyarı vermesine neden olabilir.
* */
        val view: View = LayoutInflater.from(context).inflate(R.layout.nobetci_eczane_listesi, parent, false)
        val ilceTextView: TextView = view.findViewById(R.id.nobetci_eczane_bilgi)

        if(eczane!!.Hakkında.contains("NÖBETÇİ ECZANELER")) {
            ilceTextView.setBackgroundColor(context.getColor(R.color.black))
            ilceTextView.setTextColor(context.getColor(R.color.white))
        }
        ilceTextView.text = eczane.Hakkında

        return view
    }

}
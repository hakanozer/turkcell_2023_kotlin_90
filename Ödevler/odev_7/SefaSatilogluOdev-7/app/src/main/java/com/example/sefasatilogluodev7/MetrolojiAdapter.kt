package com.example.sefasatilogluodev7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sefasatilogluodev7.models.Metroloji
import com.example.sefasatilogluodev7.xml.XmlMetroloji
import java.util.Locale

class MetrolojiAdapter(private val mContext: Context,private var sehirlerListesi:List<Metroloji>):RecyclerView.Adapter<MetrolojiAdapter.MetrolojiVerileriniTutucusu>() {

    inner class MetrolojiVerileriniTutucusu(view:View):RecyclerView.ViewHolder(view){


        var imgWeather:ImageView
        var txtBolge:TextView
        var txtCity:TextView
        var txtMin:TextView
        var txtMax:TextView
        var txtDurum:TextView

        init {
            imgWeather = view.findViewById(R.id.imgWeather)
            txtBolge = view.findViewById(R.id.txtBolge)
            txtCity = view.findViewById(R.id.txtCity)
            txtMin = view.findViewById(R.id.txtMin)
            txtMax = view.findViewById(R.id.txtMax)
            txtDurum = view.findViewById(R.id.txtDurum)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetrolojiVerileriniTutucusu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_metroloji_tasarim,parent,false)
        return MetrolojiVerileriniTutucusu(tasarim)
    }

    override fun getItemCount(): Int {
        return sehirlerListesi.size
    }

    override fun onBindViewHolder(holder: MetrolojiVerileriniTutucusu, position: Int) {
        val metrolojiVerileri = sehirlerListesi[position]
        holder.txtCity.text = metrolojiVerileri.il
        holder.txtBolge.text = metrolojiVerileri.bolge
        holder.txtMin.text = metrolojiVerileri.minSicaklik
        holder.txtMax.text = metrolojiVerileri.maxSicaklik
        holder.txtDurum.text = metrolojiVerileri.durum
    }
    fun filterCity(charString: String) {
        if (charString.isNotEmpty()) {
            val filter = sehirlerListesi.filter {
                it.il.toLowerCase(Locale.ROOT).contains(charString.toLowerCase(Locale.ROOT))
            }
            sehirlerListesi = filter
        }
        else {
            //Eger search bos ise verileri tekrardan goster
            sehirlerListesi = XmlMetroloji().verileriAl() as ArrayList<Metroloji>
        }
        notifyDataSetChanged()
    }

}
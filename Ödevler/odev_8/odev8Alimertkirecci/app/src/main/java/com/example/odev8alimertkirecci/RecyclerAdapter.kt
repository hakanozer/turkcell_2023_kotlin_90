package com.example.odev8alimertkirecci

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView




class RecyclerAdapter(val arabalistesi:ArrayList<String>, val arabaresimleri:ArrayList<Int>) :RecyclerView.Adapter<RecyclerAdapter.ArabalarVH>(){
    class ArabalarVH(itemView:  View) :RecyclerView.ViewHolder(itemView) {
        init{

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArabalarVH {
        //Inflater

        val Sed =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return ArabalarVH(Sed)
    }
    override fun getItemCount(): Int {
   return arabalistesi.size
    }

    override fun onBindViewHolder(holder: ArabalarVH, position: Int) {

        holder.itemView.recyclerViewTextView.text=arabalistesi.get(position)
        holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context,TanitimActivity::class.java)
            intent.putExtra("Arabaİsimleri",arabalistesi.get(position))
          /*  val singleton=SingletonClass.Secilenaraba
            singleton.resim=arabaresimleri.get(position)*/
            intent.putExtra("Araba Resimleri",arabaresimleri.get(position))


            holder.itemView.context.startActivity(intent)

        }
    }

}
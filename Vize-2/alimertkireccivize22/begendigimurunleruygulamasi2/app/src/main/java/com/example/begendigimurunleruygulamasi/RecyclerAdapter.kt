package com.example.begendigimurunleruygulamasi

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.begendigimurunleruygulamasi.Model.MeyveModel
import com.example.begendigimurunleruygulamasi.databinding.ActivityMainBinding
import com.example.begendigimurunleruygulamasi.databinding.ReyclerRowBinding


class RecyclerAdapter (val meyvelistesi:ArrayList<String>,val meyveresimleri:ArrayList<Bitmap>):RecyclerView.Adapter<RecyclerAdapter.MeyveVH>(){
    lateinit var binding: ReyclerRowBinding
    class MeyveVH(itemView: View) :RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeyveVH {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.reycler_row,parent,false)
  return MeyveVH(itemView)
    }

    override fun getItemCount(): Int {
       return meyvelistesi.size
    }

    override fun onBindViewHolder(holder: MeyveVH, position: Int) {
binding.recyclerViewTextView.text=meyvelistesi.get(position)

        holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context,tanitimActivity::class.java)
            holder.itemView.context.startActivity(intent)
            fun bind(meyveModel: MeyveModel){

                binding.textprice.text=meyveModel.price
            }
        }
    }
}
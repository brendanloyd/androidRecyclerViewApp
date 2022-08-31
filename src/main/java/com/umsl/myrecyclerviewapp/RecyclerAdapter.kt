package com.umsl.myrecyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private var titles = arrayOf("Title 1", "Title 2", "Title 3", "Title 4" , "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10")
    private var details = arrayOf("Title Details 1", "Title Details 2", "Title Details 3", "Title Details 4" , "Title Details 5", "Title Details 6", "Title Details 7", "Title Details 8", "Title Details 9", "Title Details 10")
    private var images = arrayOf(R.drawable.android, R.drawable.android, R.drawable.android, R.drawable.android, R.drawable.android, R.drawable.android, R.drawable.android, R.drawable.android, R.drawable.android, R.drawable.android)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle:  TextView = itemView.findViewById(R.id.item_title)
        var itemDetail: TextView = itemView.findViewById(R.id.item_detail)

        init {
            itemView.setOnClickListener{
                val position: Int = bindingAdapterPosition

                Toast.makeText(itemView.context, "Clicked on ${titles[position]}",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

}
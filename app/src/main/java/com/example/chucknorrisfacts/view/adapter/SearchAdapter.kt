package com.example.chucknorrisfacts.view.adapter

import android.content.Intent
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisfacts.R
import com.example.chucknorrisfacts.model.Result

class SearchAdapter(val facts: List<Result>
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fact_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        holder.bind(facts[position])
    }

    override fun getItemCount(): Int {
        return facts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(fact: Result) = with(itemView){


            if(fact.value.length > 80){
                findViewById<TextView>(R.id.tvChuckJoke).setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            }
            findViewById<TextView>(R.id.tvChuckJoke).text = fact.value

            val empty = "uncategorized"
            if(fact.categories.isNullOrEmpty()) {
                findViewById<TextView>(R.id.tvCategory).text = empty
            }
            else {
                findViewById<TextView>(R.id.tvCategory).text = fact.categories[0]
            }





            findViewById<ImageView>(R.id.ivShareButton).setOnClickListener{
                val intent= Intent()
                val link = fact.url
                intent.action = Intent.ACTION_SEND
                intent.type= "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,"Chuck Norris Fact #${fact.id} :\n $link")
                context.startActivity(Intent.createChooser(intent, "Compartilhar com"))
            }




        }

    }
}
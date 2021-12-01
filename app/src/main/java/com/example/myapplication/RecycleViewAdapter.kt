package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row2.view.*


//guess the phrase
class RecycleViewAdapter(private val results: List<String>):RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleViewAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row2, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecycleViewAdapter.ViewHolder, position: Int) {
        val result = results[position]

        holder.itemView.apply {
            tvPhrase.text = result

            if (result.startsWith("Wrong") || result.startsWith("Game"))
                tvPhrase.setTextColor(Color.RED)
            else if (result.startsWith("Found"))
                tvPhrase.setTextColor(Color.GREEN)
            else
                tvPhrase.setTextColor(Color.BLACK)
        }
    }

    override fun getItemCount(): Int = results.size
}
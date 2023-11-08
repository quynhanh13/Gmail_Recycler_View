package com.example.myandroidexercise

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mygmailapp.R

class RVEmailItemAdapter(private val items: ArrayList<EmailModel>): RecyclerView.Adapter<RVEmailItemAdapter.RVEmailItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVEmailItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return RVEmailItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVEmailItemViewHolder, position: Int) {
        holder.nameIcon.text = items[position].senderName[0].toString().uppercase()

        val letter = items[position].senderName[0].toString().uppercase()
        var c = 0;
        if (letter[0] <= 'E') c = Color.parseColor("#F83F3F")
        else if (letter[0] <= 'J') c = Color.parseColor("#FF00AEFF")
        else if (letter[0] <= 'O') c = Color.parseColor("#FFF2F838")
        else if (letter[0] <= 'T') c = Color.parseColor("#FF60FF4E")
        else c = Color.parseColor("#FFDA6BF3")
        holder.nameIcon.background.setTint(c)

        holder.senderName.text = items[position].senderName
        holder.title.text = items[position].title
        holder.body.text = items[position].body
        holder.checkbox.isChecked = items[position].fav
    }

    class RVEmailItemViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameIcon: TextView = itemView.findViewById(R.id.name_icon)
        val senderName: TextView = itemView.findViewById(R.id.name_textview)
        val title: TextView = itemView.findViewById(R.id.title_textview)
        val body: TextView = itemView.findViewById(R.id.body_textview)
        val checkbox: CheckBox = itemView.findViewById(R.id.star_checkbox)
    }
}
package com.example.notes.screens.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.models.AppNote

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private var mListNotes = emptyList<AppNote>()

    class MainHolder(view: View): RecyclerView.ViewHolder(view) {
        val titleNote: TextView = view.findViewById(R.id.itemNoteTitle)
        val textNote: TextView = view.findViewById(R.id.itemNoteText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.titleNote.text = mListNotes[position].title
        holder.textNote.text = mListNotes[position].text
    }

    override fun getItemCount(): Int = mListNotes.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }
}
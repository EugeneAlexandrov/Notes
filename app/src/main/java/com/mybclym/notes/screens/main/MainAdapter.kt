package com.mybclym.notes.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mybclym.notes.R
import com.mybclym.notes.models.AppNote
import kotlinx.android.synthetic.main.note_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        val noteTitle = view.item_note_name
        val noteText = view.item_note_text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.noteTitle.text = mListNotes[position].title
        holder.noteText.text = mListNotes[position].text
    }

    override fun getItemCount(): Int {
        return mListNotes.size
    }

    fun setList(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }
}
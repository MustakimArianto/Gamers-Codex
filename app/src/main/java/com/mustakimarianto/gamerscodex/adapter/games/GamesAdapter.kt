package com.mustakimarianto.gamerscodex.adapter.games

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mustakimarianto.gamerscodex.R
import com.mustakimarianto.gamerscodex.data.model.games.GamesResponse
import com.mustakimarianto.gamerscodex.databinding.ItemGamesPreviewBinding

class GamesAdapter(private val games: List<GamesResponse.Result>) :
    RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemGamesPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gamesPosition = games[position]

        holder.binding.tvItemGamesPreviewTitle.text = gamesPosition.name
        Glide.with(holder.itemView)
            .load(games[position].backgroundImage)
            .placeholder(android.R.drawable.ic_menu_view)
            .into(holder.binding.imgItemGamePreviewThumbnail)
    }

    override fun getItemCount(): Int = games.size

    inner class ViewHolder(val binding: ItemGamesPreviewBinding) :
        RecyclerView.ViewHolder(binding.root)
}
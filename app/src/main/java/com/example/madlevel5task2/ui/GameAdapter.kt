package com.example.madlevel5task2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.ItemGameBinding
import com.example.madlevel5task2.model.Game
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class GameAdapter(private val game: List<Game>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return game.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(game[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemGameBinding.bind(itemView)

        fun databind(game: Game) {
            binding.tvGameTitle.text = game.title
            binding.tvGamePlatform.text = game.platform
            binding.tvGameDate.text =
                game.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))
        }
    }
}
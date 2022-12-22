package com.example.tp_clash_of_battle.listPlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_clash_of_battle.databinding.ViewCardPlayerBinding
import com.example.tp_clash_of_battle.models.Player
import com.example.tp_clash_of_battle.utils.loadImage


class ListPlayerAdapter : ListAdapter<Player, PlayerViewHolder>(PlayerDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class PlayerViewHolder private constructor(private val binding: ViewCardPlayerBinding)
    : RecyclerView.ViewHolder(binding.root) {


    companion object {
        fun create(parent: ViewGroup): PlayerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ViewCardPlayerBinding.inflate(layoutInflater, parent, false)
            return PlayerViewHolder(binding)
        }
    }

    fun bind(item: Player) {
        binding.TVNom.text = item.name
        //binding.TVNomClasse.text = item.
        loadImage(binding.IVImage, item.imageUrl)
    }
}


class PlayerDiffUtil: DiffUtil.ItemCallback<Player>() {

    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem == newItem
    }

}
package com.example.tp_clash_of_battle.capabilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tp_clash_of_battle.databinding.ViewCapabilityBinding
import com.example.tp_clash_of_battle.models.Capability
import com.example.tp_clash_of_battle.utils.getColor
import com.example.tp_clash_of_battle.utils.getDescriptionId
import com.example.tp_clash_of_battle.utils.getNameId

class SelectCapabilityAdapter(private val clickListener: (Capability) -> Unit) :
    ListAdapter<Capability, CapabilityViewHolder>(CapabilityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapabilityViewHolder {
        return CapabilityViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CapabilityViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position))
    }
}


class CapabilityViewHolder private constructor(private val binding: ViewCapabilityBinding) :
    ViewHolder(binding.root) {

    fun bind(clickListener: (Capability) -> Unit, item: Capability) {
        binding.capabilityName.setText(item.getNameId())
        binding.capabilityDescription.setText(item.getDescriptionId())
        binding.capabilityName.setTextColor(item.getColor(binding.root.context))
        binding.root.setOnClickListener {
            clickListener(item)
        }
    }

    companion object {
        fun from(parent: ViewGroup): CapabilityViewHolder {
            val binding = ViewCapabilityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return CapabilityViewHolder(binding)
        }
    }
}

class CapabilityDiffCallback : DiffUtil.ItemCallback<Capability>() {

    override fun areItemsTheSame(oldItem: Capability, newItem: Capability): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Capability, newItem: Capability): Boolean {
        return oldItem == newItem
    }
}
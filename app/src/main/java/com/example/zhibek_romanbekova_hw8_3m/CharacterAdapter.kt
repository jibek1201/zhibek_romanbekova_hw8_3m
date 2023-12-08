package com.example.zhibek_romanbekova_hw8_3m

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.zhibek_romanbekova_hw8_3m.databinding.ItemCharacterBinding

class CharacterAdapter(
    private var characterList: ArrayList<CharacterModel>,
    val onClick: (model: CharacterModel) -> Unit
) : Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }


    inner class ViewHolder(private var binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterModel) {
            binding.tvCharacterName.text = item.name
            binding.tvCharacter.text = item.info
            Glide.with(binding.imgCharacter).load(item.image).into(binding.imgCharacter)

            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }

    }
}
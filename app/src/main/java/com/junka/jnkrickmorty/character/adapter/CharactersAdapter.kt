package com.junka.jnkrickmorty.character.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junka.jnkrickmorty.common.downloadImage
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.databinding.LayoutItemCharacterBinding
import com.junka.jnkrickmorty.main.base.BaseViewHolder
import kotlin.properties.Delegates

class CharactersAdapter(
    characters: List<CharacterRemote> = emptyList(),
    val onClickListener: (CharacterRemote) -> Unit
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    var characters: List<CharacterRemote> by Delegates.observable(characters) { _, _, _ ->
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: LayoutItemCharacterBinding) : BaseViewHolder<CharacterRemote>(binding.root){

        override fun bind(item: CharacterRemote, position: Int) {
            with(binding) {

                characterImage.downloadImage(item.image,true)
                characterName.text = item.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: LayoutItemCharacterBinding = LayoutItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        when(holder){
            is ViewHolder -> {

                val item = characters[position]
                holder.bind(item, position)
                holder.itemView.setOnClickListener {
                    onClickListener(item)
                }
            }
        }
    }
}

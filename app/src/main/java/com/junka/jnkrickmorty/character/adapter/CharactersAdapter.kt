package com.junka.jnkrickmorty.character.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.databinding.ItemCharacterBinding
import com.junka.jnkrickmorty.main.base.BaseViewHolder
import kotlin.properties.Delegates

class CharactersAdapter(
    characters: List<CharacterRemote> = emptyList(),
    val onClickListener: (CharacterRemote) -> Unit
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    var characters: List<CharacterRemote> by Delegates.observable(characters) { _, _, _ ->
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCharacterBinding) : BaseViewHolder<CharacterRemote>(binding.root){

        override fun bind(item: CharacterRemote, position: Int) {
            with(binding) {

                Glide.with(this.root).load(item.image).into(characterImage)
                //characterImage.load(item.image)
                characterName.text = item.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: ItemCharacterBinding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        when(holder){
            is ViewHolder ->{
                val item = characters[position]

                holder.bind(item,position)
                holder.itemView.setOnClickListener {
                    onClickListener(item)
                }
            }
        }



    }
}

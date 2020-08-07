package com.junka.jnkrickmorty.presenter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.databinding.ItemCharacterBinding
import com.junka.jnkrickmorty.presenter.ui.base.BaseViewHolder
import com.junka.jnkrickmorty.presenter.ui.load
import kotlin.properties.Delegates

class CharactersAdapter(
    characters: List<Character> = emptyList(),
    val onClickListener: (Character) -> Unit
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    var characters: List<Character> by Delegates.observable(characters) { _, _, _ ->
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCharacterBinding) : BaseViewHolder<Character>(binding.root){

        override fun bind(item: Character, position: Int) {
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

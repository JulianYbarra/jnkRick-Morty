package com.junka.jnkrickmorty.episodes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junka.jnkrickmorty.character.adapter.CharactersAdapter
import com.junka.jnkrickmorty.common.downloadImage
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.EpisodeRemote
import com.junka.jnkrickmorty.databinding.LayoutItemCharacterBinding
import com.junka.jnkrickmorty.databinding.LayoutItemEpisodeBinding
import com.junka.jnkrickmorty.main.base.BaseViewHolder
import kotlin.properties.Delegates

class EpisodeAdapter(
    episodes: List<EpisodeRemote> = emptyList(),
    val onClickListener: (EpisodeRemote) -> Unit
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    var episodes: List<EpisodeRemote> by Delegates.observable(episodes) { _, _, _ ->
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: LayoutItemEpisodeBinding) : BaseViewHolder<EpisodeRemote>(binding.root){

        override fun bind(item: EpisodeRemote, position: Int) {
            with(binding) {
                dateTextView.text = item.airDate
                titleTextView.text = "${item.episode} | ${item.name}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeAdapter.ViewHolder {

        val binding = LayoutItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

        when(holder){
            is EpisodeAdapter.ViewHolder -> {

                val item = episodes[position]
                holder.bind(item, position)
                holder.itemView.setOnClickListener {
                    onClickListener(item)
                }
            }
        }
    }
}
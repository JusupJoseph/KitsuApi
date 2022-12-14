package com.example.kitsu.ui.adapters.anime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kitsu.base.BaseDiffUtilItemCallback
import com.example.kitsu.databinding.ItemAnimeListBinding
import com.example.kitsu.models.KitsuModel

class AnimeAdapter :
    ListAdapter<KitsuModel, AnimeAdapter.AnimeViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AnimeViewHolder(
        ItemAnimeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeListBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: KitsuModel) {
            binding.tvAnimeTitle.text = model.attributes.titles.ja_jp
            binding.ivPosterImage.load(model.attributes.posterImage.large)
        }


    }


}



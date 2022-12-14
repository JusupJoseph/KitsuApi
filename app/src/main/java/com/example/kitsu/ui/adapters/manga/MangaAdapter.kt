package com.example.kitsu.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.kitsu.base.BaseDiffUtilItemCallback
import com.example.kitsu.databinding.ItemMangaListBinding
import com.example.kitsu.models.manga.MangaModel

class MangaAdapter :
    ListAdapter<MangaModel, MangaAdapter.FilmsViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmsViewHolder(
        ItemMangaListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class FilmsViewHolder(private val binding: ItemMangaListBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: MangaModel) {
            binding.tvMangaTitle.text = model.attributes.titles.ja_jp
            binding.ivPosterImage.load(model.attributes.posterImage.large)
            setupView(model)
        }

        private fun setupView(model: MangaModel) {
            if (binding.tvMangaTitle.maxLines != 1) {
                binding.tvMangaTitle.maxLines = 1
                binding.tvMangaTitle.text = model.attributes.titles.ja_jp + "..."
            }
        }
    }


}
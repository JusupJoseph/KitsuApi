package com.example.kitsu.ui.fragments

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.databinding.FragmentMangaBinding
import com.example.kitsu.ui.adapters.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment :
    BaseFragment<MangaViewModel, FragmentMangaBinding>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val adapter = MangaAdapter()
    private var offset: Int = 0


    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToManga()
    }

    override fun setupListener() {
        binding.rvManga.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    binding.progressBar.visibility = View.VISIBLE
                    offset += 20
                    subscribeToManga()
                } else {
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvManga.adapter = adapter
    }

    private fun subscribeToManga() {
        viewModel.fetchManga(20, offset).subscribe(
            onSuccess = {
                adapter.submitList(it.result)
            },
            onError = {
                Log.e("manga", it )
            }
        )
    }
}


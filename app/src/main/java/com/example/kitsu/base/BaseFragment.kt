package com.example.kitsu.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.kitsu.common.Resource
import java.util.concurrent.Flow

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListener()
        setupRequest()
        setupSubscribe()
    }

    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupRequest() {}

    protected open fun setupSubscribe() {}

    protected fun <T> LiveData<Resource<T>?>.subscribe(
        onSuccess: (result: T) -> Unit,
        onError: (message: String) -> Unit
    ) {
        observe(viewLifecycleOwner) {
            it.let {
                when (it) {
                    is Resource.Error -> {
                        onError(it.message.toString())
                    }
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.let { data -> onSuccess(data) }
                    }
                    null -> TODO()
                }
            }
        }
    }
}
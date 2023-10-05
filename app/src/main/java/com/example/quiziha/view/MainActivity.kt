package com.example.quiziha.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.quiziha.R
import com.example.quiziha.core.AppBaseActivity
import com.example.quiziha.core.AppConstants
import com.example.quiziha.databinding.ActivityMainBinding
import com.example.quiziha.framework.OnClickEvent
import com.example.quiziha.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppBaseActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initializeBinding() {
        binding.lifecycleOwner = this
    }

    override fun initializeHandlers() {
        viewModel.event.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                handleAction(it)
            }
        }
    }

    override fun initializeViewModel() {
        if (binding.viewModel == null) binding.viewModel = viewModel

    }

    private fun handleAction(onClickEvent: OnClickEvent) {
        when (onClickEvent) {
            is OnClickEvent.OnClick -> {
                when (onClickEvent.clickId) {
                    AppConstants.ON_MORE_CLICK -> {
                        //do something
                    }
                }
            }

            is OnClickEvent.Back -> {
                finish()
            }
        }
    }
}
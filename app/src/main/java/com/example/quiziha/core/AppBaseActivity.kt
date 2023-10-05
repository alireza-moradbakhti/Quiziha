package com.example.quiziha.core

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import com.example.quiziha.viewmodel.BaseActivityViewModel
import org.greenrobot.eventbus.EventBus

abstract class AppBaseActivity <TViewBinding : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: TViewBinding

    private val viewModel: BaseActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        initializeViewModel()
        initializeBinding()
        initializeHandlers()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    protected abstract fun getLayoutId(): Int;
    protected abstract fun initializeBinding(): Unit;
    protected abstract fun initializeHandlers();
    protected abstract fun initializeViewModel();
    inline fun <reified VM : AndroidViewModel> getViewModel(): VM {
        val v: VM by viewModels<VM>();
        return v;
    }

}
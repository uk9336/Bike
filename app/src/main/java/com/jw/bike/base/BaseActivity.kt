package com.jw.bike.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

/**
 * Created by LJW on 2022/06/19.
 *
 * Description :
 */
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes val layoutId: Int
) : AppCompatActivity() {

    lateinit var binding: B
    lateinit var viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        viewModel = defineViewModel().apply {
            lifecycleOwner = this@BaseActivity
        }
        binding.setVariable(BR.viewModel, viewModel)
    }

    /**
     * ViewModel
     */
    protected abstract fun defineViewModel(): VM
    fun <VMC : BaseViewModel> getViewModel(viewModelClass: Class<VMC>): VMC {
        return ViewModelProvider(this)[viewModelClass]
    }
}
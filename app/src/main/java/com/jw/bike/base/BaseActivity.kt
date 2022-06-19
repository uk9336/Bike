package com.jw.bike.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.jw.bike.BR

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

        // onCreate
        onCreated(savedInstanceState)
    }

    /**
     * onCreate() 를 하위 객체로 연계, activity 의 시작을 이 메서드로 한다.
     */
    protected abstract fun onCreated(savedInstanceState: Bundle?)


    /**
     * ViewModel
     */
    protected abstract fun defineViewModel(): VM
    fun <VMC : BaseViewModel> getViewModel(viewModelClass: Class<VMC>): VMC {
        return ViewModelProvider(this)[viewModelClass]
    }
}
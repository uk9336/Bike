package com.jw.bike.feature.main

import androidx.lifecycle.MutableLiveData
import com.jw.bike.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by LJW on 2022/06/20.
 *
 * Description : 메인 ViewModel
 */
@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    val loading = MutableLiveData<Boolean>()
}
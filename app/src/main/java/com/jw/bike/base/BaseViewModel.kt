package com.jw.bike.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

/**
 * Created by LJW on 2022/06/19.
 *
 * Description :
 */
abstract class BaseViewModel : ViewModel(), LifecycleEventObserver {


    var lifecycleOwner: LifecycleOwner? = null
        set(value) {
            field = value
            field?.lifecycle?.addObserver(this)
        }

    /**************************
     * LifecycleEventObserver
     *************************/
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            // onCreate
            Lifecycle.Event.ON_CREATE -> {}
            // onStart
            Lifecycle.Event.ON_START -> {}
            // onResume
            Lifecycle.Event.ON_RESUME -> {}
            // onPause
            Lifecycle.Event.ON_PAUSE -> {}
            // onStop
            Lifecycle.Event.ON_STOP -> {}
            // onDestroy
            Lifecycle.Event.ON_DESTROY -> {}
            // onAny
            Lifecycle.Event.ON_ANY -> {}
        }
    }

}
package com.jw.bike.feature.main

import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.MutableLiveData

/**
 * Created by LJW on 2022/06/22.
 *
 * Description :
 */
class MainWebClient(private val loading: MutableLiveData<Boolean>) : WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        loading.value = true
        // 앱 종료 시에도 쿠키 유지
        CookieManager.getInstance().flush()
    }
}
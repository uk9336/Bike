package com.jw.bike.feature.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.*
import com.jw.bike.R
import com.jw.bike.base.BaseActivity
import com.jw.bike.base.BaseInfo.BASE_URL
import com.jw.bike.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    override fun defineViewModel() = MainViewModel()

    override fun onCreated(savedInstanceState: Bundle?) {
        setWebview()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebview() {
        binding.wv.apply {
            webViewClient = MainWebClient()
            with(settings) {
                javaScriptEnabled = true                     // 자바스크립트 사용 여부
                javaScriptCanOpenWindowsAutomatically = true // 자바스크립트가 창을 자동으로 열 수 있게 할 지 여부
                loadsImagesAutomatically = true              // 이미지 자동 로드
                useWideViewPort = true                       // Wide ViewPort 설정
                loadWithOverviewMode = true                  // 컨텐츠가 웹뷰보다 클 때 스크린 크기에 맞추기
                setSupportZoom(false)                        // 줌 설정
                builtInZoomControls = true                   // 줌 아이콘
                cacheMode = WebSettings.LOAD_NO_CACHE        // 캐시 설정
                clearCache(true)
                clearHistory()
                isVerticalScrollBarEnabled = false
                isHorizontalScrollBarEnabled = false
                textZoom = 100
                // LOAD_CACHE_ELSE_NETWORK : 캐시 기간만료 시 네트워크 접속
                // LOAD_CACHE_ONLY : 캐시만 불러옴 (네트워크 사용 X)
                // LOAD_DEFAULT : 기본 모드, 캐시 사용, 기간 만료 시 네트워크 사용
                // LOAD_NO_CACHE : 캐시모드 사용안함
                // LOAD_NORMAL : 기본모드 캐시 사용 @Deprecated
                loadUrl(BASE_URL)
            }
        }
    }
}
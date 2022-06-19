package com.jw.bike

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.*
import com.jw.bike.base.BaseActivity
import com.jw.bike.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    val URL: String = "http://139.150.75.192:3000"
//    val URL: String = "https://www.naver.com"
    lateinit var client: WebViewClient


    override fun defineViewModel() = MainViewModel()

    override fun onCreated(savedInstanceState: Bundle?) {
        setClient()
        setWv()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun setWv() {
        binding.wv.apply {
            webViewClient = client
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
                loadUrl(URL)
            }
        }
    }

    fun setClient() {
        client = object : WebViewClient() {

            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                // 앱 종료 시에도 쿠키 유지
                CookieManager.getInstance().flush()
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)

            }
        }
    }
}
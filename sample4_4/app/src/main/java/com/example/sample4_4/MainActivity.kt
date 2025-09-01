package com.example.sample4_4

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var web1: WebView  = findViewById(R.id.web)
        web1.webViewClient = WebViewClient()
        web1.loadUrl("https://m.daum.net")
        web1.settings.javaScriptEnabled = true


        // button 이벤트처리
        val back_btn = findViewById<Button>(R.id.back)
        back_btn.setOnClickListener {
            // 버튼이 클리되었을때 처리되는 내용
            web1.goBack()
        }
        val home_btn = findViewById<Button>(R.id.home)
        home_btn.setOnClickListener {
            web1.loadUrl("https://m.daum.net")
        }

        val reload_btn = findViewById<Button>(R.id.reload)
        reload_btn.setOnClickListener {
            web1.reload()
        }
        val go_btn = findViewById<Button>(R.id.go)
        go_btn.setOnClickListener {
            web1.goForward()
        }

    }
}
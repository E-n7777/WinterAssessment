package com.example.myapplication.Util;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;
/**
 * description ：WebView
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class WebViewUtil extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = findViewById(R.id.webView);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mWebView.loadUrl(url);
    }
//判断webView能否返回
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.getKeyCode()){
            if(mWebView.canGoBack()){
                mWebView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
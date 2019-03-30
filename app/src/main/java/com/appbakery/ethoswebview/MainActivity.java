package com.appbakery.ethoswebview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    private WebView webView;
    final String password ="GIPETOPerito84";
    final String username ="9936267742050";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);





        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setDomStorageEnabled(true);
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("https://www.ethos.it/ethos-card");
            }
        });

        webView.setWebViewClient(new myWebClient());



    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    class LoadListener{
        @JavascriptInterface
        public void processHTML(String html)
        {
            // html qui è il sorgente html
        }
    }

    public void due(WebView view){

        view.loadUrl("javascript: var x = document.getElementById('ethos-username').value = '" + username + "';" +
                "var y = document.getElementById('ethos-password').value = '" + password + "';" +
                "var form1 = document.getElementById('arec-login').click();");
        }


    private class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            due(webView);


        }
    }




}
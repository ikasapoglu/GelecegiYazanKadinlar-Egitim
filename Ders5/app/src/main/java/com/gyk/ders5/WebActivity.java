package com.gyk.ders5;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = findViewById(R.id.wv_web);
        String gelenURL = getIntent().getStringExtra("URL");

        WebSayfasiniAc(gelenURL);
    }

    private void WebSayfasiniAc(String url) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        final ProgressDialog progressDialog =
                ProgressDialog.show(this,
                        "Lütfen Bekleyin", "Sayfa Yükleniyor..", false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                Toast.makeText(getApplicationContext(),
                        "Sayfa Yüklendi",
                        Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressDialog.dismiss();
            }
        });
    }
}

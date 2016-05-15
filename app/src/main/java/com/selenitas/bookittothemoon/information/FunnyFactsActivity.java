package com.selenitas.bookittothemoon.information;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.selenitas.bookittothemoon.R;

public class FunnyFactsActivity extends Activity {

    private WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny_facts);

        // Map browser
        this.browser = (WebView) findViewById(R.id.funnyFactsWebView);
        browser.addJavascriptInterface(new WebAppInterface(this), "Android");
        browser.setWebViewClient(new MyBrowser());
        WebSettings mySettings = browser.getSettings();
        mySettings.setJavaScriptEnabled(true);
        mySettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mySettings.setAllowFileAccess(true);
        mySettings.setAllowUniversalAccessFromFileURLs(true);
        mySettings.setAllowFileAccessFromFileURLs(true);

        browser.loadUrl("file:///android_asset/html/funny_facts/index.html");
    }

    public class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("funny_facts")) {
                return false;
            }

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }
    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }
}

package com.selenitas.bookittothemoon.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.selenitas.bookittothemoon.R;
import com.selenitas.bookittothemoon.favourites.Image;
import com.selenitas.bookittothemoon.favourites.MyFavourites;


public class GalleryActivity extends Activity {

    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);

        browser = (WebView) findViewById(R.id.gallleryWebview);
        browser.addJavascriptInterface(new WebAppInterface(this), "Android");
        browser.setWebViewClient(new MyBrowser());
        WebSettings mySettings = browser.getSettings();
        mySettings.setJavaScriptEnabled(true);
        mySettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mySettings.setAllowFileAccess(true);
        mySettings.setAllowUniversalAccessFromFileURLs(true);
        mySettings.setAllowFileAccessFromFileURLs(true);

        browser.loadUrl("file:///android_asset/html/gallery/index.html");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (browser.canGoBack()) {
                        browser.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


    public class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("gallery")) {
                return false;
            }
            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
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

        //#TODO Improve the dependency injection
        @JavascriptInterface
        public void savedImageToFavourites(String information) {
            String[] params = information.split("\t");
            Image image = new Image(params[0], params[1], params[2]);
            MyFavourites.list.add(image);
            this.showToast("Image added to favourites");
        }
    }

}

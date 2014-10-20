package com.teamtreehouse.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class BlogWebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web_view);
//     here we just get all info from the intent of the mainactivity file

        Intent intent = getIntent();
        Uri blogUri = intent.getData();

        WebView webView = (WebView) findViewById(R.id.webView2);
        webView.loadUrl(blogUri.toString());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blog_web_view, menu);
        return true;
    }


}

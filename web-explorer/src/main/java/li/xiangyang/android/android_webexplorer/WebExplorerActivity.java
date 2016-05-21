package li.xiangyang.android.android_webexplorer;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


public class WebExplorerActivity extends Activity {

    public final static String EXTRA_URL = "url";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_explorer);
        webView = getWebView();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                setTitle(title);
                super.onReceivedTitle(view, title);
            }
        });

        getBackView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBack();
            }
        });
        getCloseView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent in = getIntent();
        webView.loadUrl(in.getStringExtra(EXTRA_URL));
    }

    public static void open(Context context, String url) {
        Intent in = new Intent(context, WebExplorerActivity.class);
        in.putExtra(EXTRA_URL, url);
        context.startActivity(in);
    }

    protected WebView getWebView() {
        return (WebView) findViewById(R.id.webExplorerView);
    }

    protected View getBackView() {
        return findViewById(R.id.btnBack);
    }

    protected View getCloseView() {
        return findViewById(R.id.btnClose);
    }

    protected void setTitle(String title){
        ((TextView)findViewById(R.id.txtTitle)).setText(title);
    }

    private void clickBack() {
        if (webView.canGoBack()) {
            getCloseView().setVisibility(View.VISIBLE);
            webView.goBack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            clickBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

package apps.gdtidm.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar horizontalProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        horizontalProgress = findViewById(R.id.linear_progress);

        webView.loadUrl("https://developer.android.com/");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                horizontalProgress.setProgress(newProgress);
                if (newProgress == 100) {
                    horizontalProgress.setVisibility(View.GONE);
                } else {
                    horizontalProgress.setVisibility(View.VISIBLE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }
}
package li.xiangyang.android.web_explorer_samples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import li.xiangyang.android.android_webexplorer.WebExplorerActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebExplorerActivity.open(MainActivity.this, "http://hao123.com");
            }
        });
    }
}

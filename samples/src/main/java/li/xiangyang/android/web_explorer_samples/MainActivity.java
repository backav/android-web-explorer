package li.xiangyang.android.web_explorer_samples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import li.xiangyang.android.android_webexplorer.WebExplorerActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> headers = new HashMap<>(1);
                headers.put("X-IR-USER-TOKEN", "");
                WebExplorerActivity.open(MainActivity.this, "http://passport.qicyc.com/privacy/data/interest",headers);
            }
        });
    }
}

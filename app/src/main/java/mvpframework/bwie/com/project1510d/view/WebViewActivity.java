package mvpframework.bwie.com.project1510d.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import mvpframework.bwie.com.project1510d.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
        Intent intent=getIntent();
        //得到传过来的值
        String str=intent.getStringExtra("url");
        Log.i("TAG",str);
        mWb.loadUrl(str);
    }

    private void initView() {
        mWb = (WebView) findViewById(R.id.wb);
    }

}

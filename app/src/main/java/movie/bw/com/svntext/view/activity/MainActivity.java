package movie.bw.com.svntext.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import movie.bw.com.svntext.R;
import movie.bw.com.svntext.base.BaseActivity;
import movie.bw.com.svntext.base.BasePresenter;

public class MainActivity extends BaseActivity {

    private int i = 3;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            i--;
            handler.sendEmptyMessageDelayed(0,1000);
            if (i == 0){
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void initData() {
        handler.sendEmptyMessageDelayed(0,1000);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}

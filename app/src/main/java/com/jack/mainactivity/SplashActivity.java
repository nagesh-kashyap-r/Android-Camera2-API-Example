package com.jack.mainactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jack.mainactivity.databinding.SplashLayoutBinding;
import com.wajahatkarim3.easyflipview.EasyFlipView;

public class SplashActivity extends AppCompatActivity {

    private SplashLayoutBinding splashLayoutBinding;
    private Handler delayHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSystemUI(getWindow());
        splashLayoutBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.splash_layout, null, false);

        setContentView(splashLayoutBinding.getRoot());

        delayHandler.postDelayed(() -> {
            Intent intent = new Intent(this, LandingActivity.class);
            inAndOut(this);
            startActivity(intent);
            finish();
        }, 5000);

        delayHandler.postDelayed(() -> {
            EasyFlipView mYourFlipView = splashLayoutBinding.flipView;
            mYourFlipView.flipTheView();
        }, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        delayHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideSystemUI(getWindow());
    }

    public static void hideSystemUI(Window window) {
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    public static void inAndOut(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.in_out_enter, R.anim.in_out_exit);
    }
}

package com.jack.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jack.mainactivity.databinding.SplashLayoutBinding;

public class SplashActivity extends AppCompatActivity {

    private SplashLayoutBinding splashLayoutBinding;
    private Handler delayHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashLayoutBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.splash_layout, null, false);

        setContentView(splashLayoutBinding.getRoot());

        delayHandler.postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        delayHandler.removeCallbacksAndMessages(null);
    }
}

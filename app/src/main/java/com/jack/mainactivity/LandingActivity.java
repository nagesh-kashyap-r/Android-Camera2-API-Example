package com.jack.mainactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jack.mainactivity.databinding.LandingLayoutBinding;

public class LandingActivity extends AppCompatActivity {

    private LandingLayoutBinding landingLayoutBinding;
    private Handler delayHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        landingLayoutBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.landing_layout, null, false);

        setContentView(landingLayoutBinding.getRoot());

        ProgressBar progressbar = landingLayoutBinding.progressBar;
        progressbar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#FFFFFF"), android.graphics.PorterDuff.Mode.SRC_IN);

        landingLayoutBinding.demo.setOnClickListener(v -> {
            landingLayoutBinding.progressBar.setVisibility(View.VISIBLE);
            delayHandler.postDelayed(this::handleDemoMode, 3000);

        });

        landingLayoutBinding.launch.setOnClickListener(v -> {
            landingLayoutBinding.progressBar.setVisibility(View.VISIBLE);
            delayHandler.postDelayed(this::handleNormalLaunch, 3000);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        delayHandler.removeCallbacksAndMessages(null);
    }

    private void handleDemoMode() {
        landingLayoutBinding.progressBar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("demo", true);
        startActivity(intent);
    }

    private void handleNormalLaunch() {
        landingLayoutBinding.progressBar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("demo", false);
        startActivity(intent);
    }
}

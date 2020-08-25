package com.jack.mainactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jack.mainactivity.databinding.ActivityLandingBinding;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLandingBinding activityLandingBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_landing, null, false);

        setContentView(activityLandingBinding.getRoot());

        activityLandingBinding.demo.setOnClickListener(v -> {
            handleDemoMode();
        });

        activityLandingBinding.demoOut.setOnClickListener(v -> {
            handleDemoMode();
        });

        activityLandingBinding.launch.setOnClickListener(v -> {
            handleNormalLaunch();
        });

        activityLandingBinding.launchOut.setOnClickListener(v -> {
            handleNormalLaunch();
        });
    }

    private void handleDemoMode() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("demo", true);
        startActivity(intent);
    }

    private void handleNormalLaunch() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("demo", false);
        startActivity(intent);
    }
}

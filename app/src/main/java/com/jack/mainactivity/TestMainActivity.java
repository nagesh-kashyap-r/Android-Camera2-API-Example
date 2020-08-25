package com.jack.mainactivity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jack.mainactivity.adapter.CompositionAdapter;
import com.jack.mainactivity.databinding.ActivityMainTestBinding;
import com.jack.mainactivity.model.CompositionData;

public class TestMainActivity extends AppCompatActivity {

    ActivityMainTestBinding activityMainBinding;
    private CompositionAdapter compositionAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        compositionAdapter = new CompositionAdapter(this, CompositionData.DEFAULT);

        activityMainBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main_test, null, false);
        setContentView(activityMainBinding.getRoot());

/*        activityMainBinding.outer.post(() -> {
            CompositionData.SCREEN_WIDTH = activityMainBinding.outer.getWidth();
            CompositionData.SCREEN_HEIGHT = activityMainBinding.outer.getHeight();

            //loadCompositeDataToImageView(compositionAdapter.getCurrentCompositionData(), CompositionData.Type.DARK);

            activityMainBinding.compositionImageView.setImageDrawable(compositionAdapter.getCurrentDrawable(CompositionData.Type.DARK));
        });

        activityMainBinding.compositionImageView.post(() -> {

        });*/

    }

    /*private void loadCompositeDataToImageView(CompositionData compositionData, CompositionData.Type type) {

        int resId = type == CompositionData.Type.LIGHT ? compositionData.getCompositionDrawableResIdLight() : compositionData.getCompositionDrawableResIdDark();

        Glide.with(this).asBitmap().load(resId).into(new CustomTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                // creating the image that maintain aspect ratio with width of image is set to screenwidth.
                resource = Bitmap.createScaledBitmap(resource, CompositionData.SCREEN_WIDTH, CompositionData.SCREEN_HEIGHT, false);
                activityMainBinding.compositionImageView.setImageBitmap(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        });
    }*/
}
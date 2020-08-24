package com.jack.mainactivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jack.mainactivity.databinding.ActivityMainBinding;
import com.jack.mainactivity.databinding.ActivityMainTestBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMainActivity extends AppCompatActivity {

    ActivityMainTestBinding activityMainBinding;
    private CompositionAdapter compositionAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        compositionAdapter = new CompositionAdapter(this);

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
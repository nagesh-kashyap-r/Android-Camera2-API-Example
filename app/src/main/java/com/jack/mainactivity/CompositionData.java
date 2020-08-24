package com.jack.mainactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;

public class CompositionData {

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;

    private @DrawableRes
    int compositionDrawableResIdDark;

    public int getCompositionDrawableResIdDark() {
        return compositionDrawableResIdDark;
    }

    public int getCompositionDrawableResIdLight() {
        return compositionDrawableResIdLight;
    }

    public int getRotationAngle() {
        return rotationAngle;
    }

    private @DrawableRes
    int compositionDrawableResIdLight;
    private int rotationAngle = 0;

    public Drawable getDrawableBasedOnType(Context context, Type type) {
        switch (type) {
            case DARK:
                return getDarkDrawable(context);

            case LIGHT:
                return getLightDrawable(context);

            default:
                return null;
        }
    }

    public Drawable getDarkDrawable(Context context) {
        Drawable drawable = context.getDrawable(compositionDrawableResIdDark);

        if (toRotate()) {
            drawable =  getRotateDrawable(drawable, rotationAngle);
        }

        return drawable;
    }

    public Drawable getLightDrawable(Context context) {
        Drawable drawable = context.getDrawable(compositionDrawableResIdLight);

        if (toRotate()) {
            drawable =  getRotateDrawable(drawable, rotationAngle);
        }

        return drawable;
    }

    private boolean toRotate() {
        return rotationAngle != 0;
    }

    private Drawable getRotateDrawable(final Drawable d, final float angle) {
        final Drawable[] arD = {d};
        return new LayerDrawable(arD) {
            @Override
            public void draw(final Canvas canvas) {
                canvas.save();
                canvas.rotate(angle, SCREEN_WIDTH, SCREEN_HEIGHT);

                super.draw(canvas);
                canvas.restore();
            }
        };
    }

    public static List<CompositionData> getCompositionDataList() {
        List<CompositionData> compositionDataList = new ArrayList<>();

        //Golden Triangle
        CompositionData compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setCompositionDrawableResIdDark(R.drawable.ic_golden_triangle_bottom_dark)
                .setCompositionDrawableResIdLight(R.drawable.ic_golden_triangle_bottom_light)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //Golden Triangle
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setCompositionDrawableResIdDark(R.drawable.ic_golden_triangle_top_dark)
                .setCompositionDrawableResIdLight(R.drawable.ic_golden_triangle_top_light)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //Golden Triangle
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setCompositionDrawableResIdDark(R.drawable.ic_golden_triangle_dark)
                .setCompositionDrawableResIdLight(R.drawable.ic_golden_triangle_light)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //3x3 portrait rule of thirds
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setCompositionDrawableResIdDark(R.drawable.ic_photo_3_3_portrait_dark)
                .setCompositionDrawableResIdLight(R.drawable.ic_photo_3_3_portrait_light)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //3x2 portrait
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setCompositionDrawableResIdDark(R.drawable.ic_photo_3_2_portrait_dark)
                .setCompositionDrawableResIdLight(R.drawable.ic_photo_3_2_portrait_light)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //Fibinocci
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setCompositionDrawableResIdDark(R.drawable.ic_fibonacci_spiral_dark)
                .setCompositionDrawableResIdLight(R.drawable.ic_fibonacci_spiral_light)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        return compositionDataList;
    }

    public static final class CompositionDataBuilder {
        private int compositionDrawableResIdDark;
        private int compositionDrawableResIdLight;
        private int rotationAngle = 0;

        private CompositionDataBuilder() {
        }

        public static CompositionDataBuilder aCompositionData() {
            return new CompositionDataBuilder();
        }

        public CompositionDataBuilder setCompositionDrawableResIdDark(int compositionDrawableResIdDark) {
            this.compositionDrawableResIdDark = compositionDrawableResIdDark;
            return this;
        }

        public CompositionDataBuilder setCompositionDrawableResIdLight(int compositionDrawableResIdLight) {
            this.compositionDrawableResIdLight = compositionDrawableResIdLight;
            return this;
        }

        public CompositionDataBuilder setRotationAngle(int rotationAngle) {
            this.rotationAngle = rotationAngle;
            return this;
        }

        public CompositionData build() {
            CompositionData compositionData = new CompositionData();
            compositionData.rotationAngle = this.rotationAngle;
            compositionData.compositionDrawableResIdLight = this.compositionDrawableResIdLight;
            compositionData.compositionDrawableResIdDark = this.compositionDrawableResIdDark;
            return compositionData;
        }
    }

    public enum Type {
        DARK,
        LIGHT
    }
}

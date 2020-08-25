package com.jack.mainactivity.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.jack.mainactivity.R;

import java.util.ArrayList;
import java.util.List;

public class CompositionData {

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;

    public static CompositionData DEFAULT = new CompositionData.CompositionDataBuilder()
            .setComposition(Composition.GOLDEN_TRIANGLE_BOTTOM)
            .build();

    private @DrawableRes int compositionDrawableResIdDark;

    public int getCompositionDrawableResIdDark() {
        return compositionDrawableResIdDark;
    }

    public int getCompositionDrawableResIdLight() {
        return compositionDrawableResIdLight;
    }

    public int getRotationAngle() {
        return rotationAngle;
    }

    private @DrawableRes int compositionDrawableResIdLight;

    private int rotationAngle = 0;

    private Composition composition;

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

        //Golden Triangle bottom
        CompositionData compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setComposition(Composition.GOLDEN_TRIANGLE_BOTTOM)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //Golden Triangle top
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setComposition(Composition.GOLDEN_TRIANGLE_TOP)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //Golden Triangle
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setComposition(Composition.GOLDEN_TRIANGLE)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //3x3 portrait rule of thirds
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setComposition(Composition.RULE_OF_THIRDS_3x3)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //3x2 portrait
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setComposition(Composition.RULE_OF_THIRDS_3x2)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        //Fibinocci
        compositionData = CompositionData.CompositionDataBuilder
                .aCompositionData()
                .setComposition(Composition.FIBINOCCI)
                .setRotationAngle(0)
                .build();

        compositionDataList.add(compositionData);

        return compositionDataList;
    }

    public enum Type {
        DARK,
        LIGHT
    }

    public enum Composition {
        GOLDEN_TRIANGLE_BOTTOM(R.drawable.ic_golden_triangle_bottom_light, R.drawable.ic_golden_triangle_bottom_dark),
        GOLDEN_TRIANGLE_TOP(R.drawable.ic_golden_triangle_top_light, R.drawable.ic_golden_triangle_top_dark),
        GOLDEN_TRIANGLE(R.drawable.ic_golden_triangle_light, R.drawable.ic_golden_triangle_dark),
        RULE_OF_THIRDS_3x3(R.drawable.ic_photo_3_3_portrait_light, R.drawable.ic_photo_3_3_portrait_dark),
        RULE_OF_THIRDS_3x2(R.drawable.ic_photo_3_2_portrait_light, R.drawable.ic_photo_3_2_portrait_dark),
        FIBINOCCI(R.drawable.ic_fibonacci_spiral_light, R.drawable.ic_fibonacci_spiral_dark);

        private @DrawableRes int light;

        Composition(int light, int dark) {
            this.light = light;
            this.dark = dark;
        }

        private @DrawableRes int dark;
    }

    public static final class CompositionDataBuilder {
        private int compositionDrawableResIdDark;
        private int compositionDrawableResIdLight;
        private int rotationAngle = 0;
        private Composition composition;

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

        public CompositionDataBuilder setComposition(Composition composition) {
            this.composition = composition;
            compositionDrawableResIdDark = composition.dark;
            compositionDrawableResIdLight = composition.light;
            return this;
        }

        public CompositionData build() {
            CompositionData compositionData = new CompositionData();
            compositionData.compositionDrawableResIdLight = this.compositionDrawableResIdLight;
            compositionData.compositionDrawableResIdDark = this.compositionDrawableResIdDark;
            compositionData.rotationAngle = this.rotationAngle;
            compositionData.composition = this.composition;
            return compositionData;
        }
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CompositionData) {
            CompositionData otherCompositionData = (CompositionData) obj;
            return this.composition.equals(otherCompositionData.composition);
        }
        return false;
    }
}

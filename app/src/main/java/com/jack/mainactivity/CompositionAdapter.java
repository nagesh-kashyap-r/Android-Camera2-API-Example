package com.jack.mainactivity;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class CompositionAdapter {
    private List<CompositionData> compositionDataList = new ArrayList<>();
    private int currentDrawableIndex = 0;
    private CompositionData currentCompositionData;
    private Context context;

    public CompositionAdapter(Context context) {
        this.context = context;
        compositionDataList.addAll(CompositionData.getCompositionDataList());

        currentCompositionData = compositionDataList.get(currentDrawableIndex);
    }

    public CompositionData getCurrentCompositionData() {
        return currentCompositionData;
    }

    public Drawable getCurrentDrawable(CompositionData.Type type) {
        return currentCompositionData.getDrawableBasedOnType(context, type);
    }

    public Drawable getNextDrawable(CompositionData.Type type) {
        positiveCycle();
        CompositionData compositionData = compositionDataList.get(currentDrawableIndex);
        return compositionData.getDrawableBasedOnType(context, type);
    }

    public CompositionData getNextCompositionData() {
        positiveCycle();
        CompositionData compositionData = compositionDataList.get(currentDrawableIndex);
        return compositionData;
    }

    public CompositionData getPreviousCompositionData() {
        negativeCycle();
        CompositionData compositionData = compositionDataList.get(currentDrawableIndex);
        return compositionData;
    }

    public Drawable getPreviousDrawable(CompositionData.Type type) {
        negativeCycle();
        CompositionData compositionData = compositionDataList.get(currentDrawableIndex);
        return compositionData.getDrawableBasedOnType(context, type);
    }

    private void negativeCycle() {
        currentDrawableIndex--;
        if (currentDrawableIndex == -1) {
            currentDrawableIndex = compositionDataList.size();
        }
    }

    private void positiveCycle() {
        currentDrawableIndex++;
        if (currentDrawableIndex == compositionDataList.size()) {
            currentDrawableIndex = 0;
        }
    }
}

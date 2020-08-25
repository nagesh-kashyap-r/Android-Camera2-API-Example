package com.jack.mainactivity.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jack.mainactivity.model.CompositionData;

public class CompositionDataViewModel extends ViewModel {
    private MutableLiveData<CompositionData> compositionDataMutableLiveData = new MutableLiveData<>(CompositionData.DEFAULT);
    public CompositionData.Type curentType = CompositionData.Type.LIGHT;

    public MutableLiveData<CompositionData> getCompositionDataMutableLiveData() {
        return compositionDataMutableLiveData;
    }
}

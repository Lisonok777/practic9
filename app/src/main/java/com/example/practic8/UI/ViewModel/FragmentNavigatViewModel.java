package com.example.practic8.UI.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.practic8.DATA.Model.FragmentNavigatData;

public class FragmentNavigatViewModel extends ViewModel {

    private MutableLiveData<FragmentNavigatData> data = new MutableLiveData<>();
    public FragmentNavigatViewModel() {
        data.setValue(new FragmentNavigatData());
    }
    public MutableLiveData<FragmentNavigatData> getData() {
        return data;
    }
}

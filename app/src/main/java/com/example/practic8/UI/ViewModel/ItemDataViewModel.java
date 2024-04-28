package com.example.practic8.UI.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practic8.DATA.DataSources.Repositoriy;
import com.example.practic8.DATA.Model.DataList;
import com.example.practic8.R;

public class ItemDataViewModel extends ViewModel {
    private Repositoriy repository = new Repositoriy();
    public LiveData<DataList> getItem(int itemId) {
        return repository.getItem(itemId);
    }
}

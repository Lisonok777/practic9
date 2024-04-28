package com.example.practic8.DATA.DataSources;

import androidx.lifecycle.LiveData;
import com.example.practic8.DATA.Model.DataList;
import com.example.practic8.DATA.Model.Item;
import java.util.List;
public interface DataSource {
    LiveData<List<DataList>> getItems();
    LiveData<DataList> getItem(int itemId);
}

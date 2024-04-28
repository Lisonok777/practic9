package com.example.practic8.UI.View;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.practic8.DATA.DataSources.Room.Entities.Category;
import com.example.practic8.R;
import com.example.practic8.UI.ViewModel.ItemViewModel;
import java.util.HashMap;
import java.util.Map;
public class Fragment5 extends Fragment {
    private ItemViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5, container, false);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 203; i++) {
            String text = "Владелец №" + (i + 1);
            map.put(text, R.drawable.vladeleccat);
        }
        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity()
                        .getApplication())).get(ItemViewModel.class);
        viewModel.createList(this.getContext(), map);
        String itemName = getArguments().getString("itemName");
        TextView itemN = view.findViewById(R.id.text_view);
        ImageView itemDescription = view.findViewById(R.id.image_view);
        viewModel.getLiveData().observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                Category list = item.getCategory(itemName);
                itemN.setText(list.catName);
                itemDescription.setImageResource(list.img);
            }});
        Button toFour = view.findViewById(R.id.to_four);
        toFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.Fragment4);
            }});
        Button but = view.findViewById(R.id.share);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, itemN.getText().toString());
                startActivity(Intent.createChooser(shareIntent, "Поделиться через"));
            }});
        return view;
    }
}
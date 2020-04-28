package com.iavariav.learnjsonstunting.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iavariav.learnjsonstunting.R;
import com.iavariav.learnjsonstunting.adapter.StuntingAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private StuntingAdapter stuntingAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(true);

        homeViewModel.getStunding().observe(getActivity(), stuntingModels -> {
            stuntingAdapter = new StuntingAdapter(getActivity(), stuntingModels);
            recyclerView.setAdapter(stuntingAdapter);
        });
        return root;
    }
}
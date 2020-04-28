package com.iavariav.learnjsonstunting.ui.dashboard;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iavariav.learnjsonstunting.R;
import com.iavariav.learnjsonstunting.adapter.StuntingAdapter;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private StuntingAdapter stuntingAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        RecyclerView recyclerView = findViewById(R.id.apaaa); // berguna di activity
        final RecyclerView recyclerView = root.findViewById(R.id.rv);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(true);

        dashboardViewModel.getStunding().observe(getActivity(), stuntingModel -> {
            stuntingAdapter = new StuntingAdapter(getActivity(), stuntingModel);
            recyclerView.setAdapter(stuntingAdapter);
        });

        return root;
    }
}
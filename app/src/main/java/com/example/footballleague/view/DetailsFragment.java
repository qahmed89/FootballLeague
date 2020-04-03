package com.example.footballleague.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.footballleague.BaseApplication;
import com.example.footballleague.R;
import com.example.footballleague.adapter.PlayerAdapter;
import com.example.footballleague.databinding.FragmentDetailsBinding;
import com.example.footballleague.viewmodel.FootballLeagueViewModel;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
    @Inject
    ViewModelProvider.Factory viewModelProvider;
    FootballLeagueViewModel footballLeagueViewModel;
    String token = "12faf50c4edc47d2bdc76add010fc0c1";
    int ids = 2021;
    FragmentDetailsBinding binding;
    LinearLayoutManager mLayoutManager;
    int postion = -1;
    NavController navController;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_details, container, false);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((BaseApplication) getActivity().getApplication()).getAppComponent().injectFragment(this);
        mLayoutManager = new LinearLayoutManager(getContext());
        MainFragmentArgs x = MainFragmentArgs.fromBundle(getArguments());
        navController = Navigation.findNavController(view);

        postion = x.getPostion();
        footballLeagueViewModel = new ViewModelProvider(getActivity(), viewModelProvider).get(FootballLeagueViewModel.class);
        footballLeagueViewModel.getTeamsResponce(token, ids).observe(getViewLifecycleOwner(), teams -> {

            binding.setDetailsteams(teams.getDetailsTeams().get(postion));
            PlayerAdapter playerAdapter = new PlayerAdapter(teams.getDetailsTeams().get(postion).getSquad(), getContext());
            binding.recyclerviewPlayer.setLayoutManager(mLayoutManager);
            binding.recyclerviewPlayer.setAdapter(playerAdapter);


        });


    }


}

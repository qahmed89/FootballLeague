package com.example.footballleague.view;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballleague.BaseApplication;
import com.example.footballleague.R;
import com.example.footballleague.adapter.TeamsAdapter;
import com.example.footballleague.databinding.FragmentMainBinding;
import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.teams.Teams;
import com.example.footballleague.model.teams.TeamsItem;
import com.example.footballleague.viewmodel.FootballLeagueViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements TeamsAdapter.OnTeamslistener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Teams myteams;
    LinearLayoutManager mLayoutManager;
    TeamsAdapter teamsAdapter;
    @Inject
    ViewModelProvider.Factory viewModelProvider;
    FootballLeagueViewModel footballLeagueViewModel;
    String token = "12faf50c4edc47d2bdc76add010fc0c1";
    int id = 2021;
    FragmentMainBinding binding;
    NavController navController;
    int froms = 0;
    int fromss = 0;
    int lasts = 5;
    int lastss = 5;
    View view;
    private static final String TAG = "MainFragment";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            binding = DataBindingUtil.inflate(
                    inflater, R.layout.fragment_main, container, false);
            view = binding.getRoot();
        }
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.findFirstCompletelyVisibleItemPosition();
        ((BaseApplication) getActivity().getApplication()).getAppComponent().injectFragment(this);

        footballLeagueViewModel = new ViewModelProvider(getActivity(), viewModelProvider).get(FootballLeagueViewModel.class);
        binding.prograssbar.show();
        getMessageError();
        getTeams();

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTeams();

            }
        });
        binding.recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                if (islastindex(recyclerView)) {

                    if (teamsAdapter.getItemCount() < 20) {

                        List<TeamsItem> list1 = getItemList(myteams.getTeams(), 6, froms, lasts);
                        List<DetailsTeams> list2 = getplayerList(myteams.getDetailsTeams(), 6, fromss, lastss);

                        teamsAdapter.addItems(list1, list2);

                    }

                }
            }
        });

    }

    private void getMessageError() {
        footballLeagueViewModel.errorMessage().observe(getViewLifecycleOwner(), s -> {
            binding.prograssbar.hide();
           if(teamsAdapter==null) {
               Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
               if (!(s.equals(null))) {
                   Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
               }

           }
        });
    }

    private void getTeams() {
        footballLeagueViewModel.getTeamsResponce(token, id).observe(getViewLifecycleOwner(), teams -> {
            Log.d(TAG, "onViewCreated: teamsList " + teams.getTeams().get(0).getName());
            Log.d(TAG, "onViewCreated: detailsTeamList " + teams.getDetailsTeams().get(0).getName());
            myteams = teams;
            binding.prograssbar.hide();
            binding.floatingActionButton.setVisibility(View.GONE);
            if (teamsAdapter == null) {
                teamsAdapter = new TeamsAdapter(getItemList(teams.getTeams(), 6, froms, lasts), getplayerList(teams.getDetailsTeams(), 6, fromss, lastss), getContext(), this::onTeamsClick);
                binding.recyclerview.setLayoutManager(mLayoutManager);
                binding.prograssbar.hide();
                binding.recyclerview.setAdapter(teamsAdapter);
            }

        });
    }

    private boolean islastindex(RecyclerView recycer) {
        if (recycer.getAdapter().getItemCount() != 0) {
            int intlastindex = ((LinearLayoutManager) recycer.getLayoutManager()).findLastCompletelyVisibleItemPosition();
            return intlastindex != RecyclerView.NO_POSITION && intlastindex == recycer.getAdapter().getItemCount() - 1;
        }
        return false;

    }


    public List<TeamsItem> getItemList(List<TeamsItem> aa, int page, int from, int last) {
        if (from == 0) {
            froms = last + 1;
            lasts = (froms + page);
            Log.i(TAG, "First Page" + (myteams.getTeams().size()));
            List<TeamsItem> x = new ArrayList<>();
            for (int i = from; i <= last; i++) {
                x.add(aa.get(i));

            }
            Log.i(TAG, "First Page" + (myteams.getTeams().size()));

            return x;


        } else {
            froms = Math.min((from + page) + 1, myteams.getTeams().size());
            lasts = (from + page);
            Log.i(TAG, "After Insert Page" + (myteams.getTeams().size()));

            Log.i(TAG, "After Insert Page aa size" + (aa.size()));
            Log.i(TAG, "After Insert Page itemlist" + (myteams.getTeams().size()));
            List<TeamsItem> x = new ArrayList<>();
            for (int i = from; i <= Math.min((from + page), myteams.getTeams().size() - 1); i++) {
                x.add(aa.get(i));

            }
            return x;


        }


    }

    public List<DetailsTeams> getplayerList(List<DetailsTeams> aa, int page, int from, int last) {
        if (from == 0) {
            fromss = last + 1;
            lastss = (froms + page);
            Log.i(TAG, "First Page" + (myteams.getDetailsTeams().size()));
            List<DetailsTeams> x = new ArrayList<>();
            for (int i = from; i <= last; i++) {
                x.add(aa.get(i));

            }
            Log.i(TAG, "First Page" + (myteams.getDetailsTeams().size()));

            return x;


        } else {
            fromss = Math.min((from + page) + 1, myteams.getDetailsTeams().size());
            lastss = (from + page);
            Log.i(TAG, "After Insert Page" + (myteams.getDetailsTeams().size()));

            Log.i(TAG, "After Insert Page aa size" + (aa.size()));
            Log.i(TAG, "After Insert Page itemlist" + (myteams.getDetailsTeams().size()));
            List<DetailsTeams> x = new ArrayList<>();
            for (int i = from; i <= Math.min((from + page), myteams.getDetailsTeams().size() - 1); i++) {
                x.add(aa.get(i));

            }
            return x;


        }


    }

    @Override
    public void onTeamsClick(int postion, TextView teamsHolder) {

        navController.navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment2().setPostion(postion));
    }
}

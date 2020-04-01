package com.example.footballleague.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballleague.BaseApplication;
import com.example.footballleague.R;
import com.example.footballleague.adapter.Paginator;
import com.example.footballleague.adapter.TeamsAdapter;
import com.example.footballleague.databinding.ActivityMainBinding;
import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.teams.TeamsItem;
import com.example.footballleague.viewmodel.FootballLeagueViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements TeamsAdapter.OnTeamslistener {
    ActivityMainBinding activityMainBinding;
    @Inject
    ViewModelProvider.Factory viewModelProvider;
    FootballLeagueViewModel footballLeagueViewModel;
    String token = "12faf50c4edc47d2bdc76add010fc0c1";
    int id = 2021;
    List<TeamsItem> itemList;
    List<TeamsItem> itemLiswt;
    int pagecount = 1;
    int startindex = 0, lastindex = 6;
    LinearLayoutManager mLayoutManager;
    TeamsAdapter teamsAdapter;
    Paginator p;

    List<DetailsTeams> detailsTeams2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        detailsTeams2 = new ArrayList<>();
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mLayoutManager = new LinearLayoutManager(this);
        itemLiswt = new ArrayList<>();
        mLayoutManager.findFirstCompletelyVisibleItemPosition();

        footballLeagueViewModel = new ViewModelProvider(this, viewModelProvider).get(FootballLeagueViewModel.class);
        itemList = new ArrayList<>();
        activityMainBinding.prograssbar.show();

        footballLeagueViewModel.getTeamsResponce(token, id, activityMainBinding.getRoot()).observe(this, teams -> {
            itemList.addAll(teams.getTeams());
          //  p = new Paginator(itemList);
           // intrecycler(getPage(itemList, pagecount, 5));
          //  fetshDAta(itemList);
            //     getPage(itemList,pagecount,6);
            Log.i("Activtty",itemLiswt.toString());
//            teamsAdapter = new TeamsAdapter(itemList,this);
//            activityMainBinding.recyclerview.setLayoutManager(mLayoutManager);
//            activityMainBinding.recyclerview.setAdapter(teamsAdapter);

        });

//        activityMainBinding.recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
//                                                                 @Override
//                                                                 public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                                                                     super.onScrollStateChanged(recyclerView, newState);
//                                                                 }
//
//                                                                 @Override
//                                                                 public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                                                                     super.onScrolled(recyclerView, dx, dy);
//
//                                                                     if (islastindex(recyclerView)) {
//                                                                         activityMainBinding.prograssbar.show();
//
//                                                                         Log.i("ListActivity", "loadmore");
//                                                                         if (pagecount < 5) {
//                                                                             pagecount++;
//                                                                             if (teamsAdapter.getItemCount() <= 20) {
////
//                                                                                 intrecycler2(getPage(itemList, pagecount, 5));
//                                                                                 activityMainBinding.prograssbar.hide();
//
//                                                                             }
////                        teamsAdapter.notifyDataSetChanged();
//
//
//                                                                         }
//
//                                                                     }
//                                                                 }
//                                                             }
//        );
    }


//    private boolean islastindex(RecyclerView recycer) {
//        if (activityMainBinding.recyclerview.getAdapter().getItemCount() != 0) {
//            int intlastindex = ((LinearLayoutManager) recycer.getLayoutManager()).findLastCompletelyVisibleItemPosition();
//            return intlastindex != RecyclerView.NO_POSITION && intlastindex == recycer.getAdapter().getItemCount() - 1;
//        }
//        return false;
//
//    }


//    public void intrecycler(List<TeamsItem> list) {
//        teamsAdapter = new TeamsAdapter(list, MainActivity.this);
//        // teamsAdapter = new TeamsAdapter(itemList, detailsTeams2, this);
//
//        activityMainBinding.recyclerview.setLayoutManager(mLayoutManager);
//        activityMainBinding.recyclerview.setAdapter(teamsAdapter);
//        startindex = lastindex + 1;
//        lastindex = lastindex * 2 + 1;
//    }

//    public void intrecycler2(List<TeamsItem> list) {
//        lastindex = teamsAdapter.getItemCount();
//        activityMainBinding.recyclerview.setLayoutManager(mLayoutManager);
//        RecyclerView.LayoutManager myLayoutManage2r = activityMainBinding.recyclerview.getLayoutManager();
//        if (startindex < 19) {0
//            teamsAdapter.addItems(list);
//            startindex = lastindex + 1;
//            lastindex = itemList.size() - teamsAdapter.getItemCount();
//        }
//        //  teamsAdapter.addItems(list);
//        teamsAdapter.notifyDataSetChanged();
//        //  teamsAdapter.notifyItemRangeChanged(teamsAdapter.getItemCount(), list.size()-1 );
//
//    }

//    public void fetshDAta(List<TeamsItem> teamsItems) {
//        for (int i = 0; i < teamsItems.size(); i++) {
//
//            footballLeagueViewModel.getDetailsTeamsResponce(token, teamsItems.get(i).getId(), activityMainBinding.getRoot()).observe(this, detailsTeams -> {
//                detailsTeams2.add(detailsTeams);
//
//                HashSet<DetailsTeams> hashSet = new HashSet<DetailsTeams>();
//                hashSet.addAll(detailsTeams2);
//                detailsTeams2.clear();
//                detailsTeams2.addAll(hashSet);
//                if (detailsTeams2.size() == teamsItems.size()) {
//                       teamsAdapter = new TeamsAdapter(itemList, detailsTeams2, this,this::onTeamsClick);
//                    activityMainBinding.recyclerview.setLayoutManager(mLayoutManager);
//                    activityMainBinding.recyclerview.setAdapter(teamsAdapter);
//                    activityMainBinding.prograssbar.hide();
//
//                }
//            });
//
//        }
//    }

//    public static <TeamsItem> List<com.example.footballleague.model.teams.TeamsItem> getPage(List<com.example.footballleague.model.teams.TeamsItem> sourceList, int page, int pageSize) {
//        if (pageSize <= 0 || page <= 0) {
//            throw new IllegalArgumentException("invalid page size: " + pageSize);
//        }
//
//
//    int fromIndex = (page - 1) * pageSize;
//        if (sourceList == null || sourceList.size() < fromIndex) {
//        return Collections.emptyList();
//    }
//
//    // toIndex exclusive
//        return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
//}

    @Override
    public void onTeamsClick(int postion, TextView view2) {


        Intent intent = new Intent(getApplicationContext(), DetailsTeamActivity.class);
        intent.putExtra("id", itemList.get(postion).getId());
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

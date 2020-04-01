package com.example.footballleague.viewmodel;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.sss.Alldata;
import com.example.footballleague.model.teams.Teams;
import com.example.footballleague.model.teams.TeamsItem;
import com.example.footballleague.repository.FootballLeagueRepository;
import com.google.android.material.snackbar.Snackbar;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class FootballLeagueViewModel extends ViewModel {

    Context context;
    private FootballLeagueRepository footballLeagueRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<Teams> teamsMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<DetailsTeams> detailsTeamsMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Alldata> alldataMutableLiveData = new MutableLiveData<>();

    private Teams myTeams = new Teams();
    private TeamsItem myTeamsItem = new TeamsItem();
    private List<TeamsItem> teamsItemList = new ArrayList<>();

    @Inject
    public FootballLeagueViewModel(FootballLeagueRepository footballLeagueRepository) {
        this.footballLeagueRepository = footballLeagueRepository;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public LiveData<Teams> getTeamsResponce(String token, int id, View v) {
        teamsResponce(token, id, v);
        return teamsMutableLiveData;
    }

    public LiveData<DetailsTeams> getDetailsTeamsResponce(String token, int id, View v) {
        detailsTeamsResponce(token, id, v);
        return detailsTeamsMutableLiveData;
    }

    private void detailsTeamsResponce(String token, int id, View v) {
        disposable.add(footballLeagueRepository.DetailsTeams(token, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DetailsTeams>() {


                    @Override
                    public void onNext(DetailsTeams detailsTeams) {
                        detailsTeamsMutableLiveData.setValue(detailsTeams);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(v, "Something wrong happen", Snackbar.LENGTH_LONG).show();

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

//           @RequiresApi(api = Build.VERSION_CODES.N)
//        private  void getCompined(String token, int id, View v){
//            Single<Teams> teams=footballLeagueRepository.Teams(token, id);
//            Single<DetailsTeams> detailsTeams=footballLeagueRepository.DetailsTeams(token, id);
//            disposable.add(Observable.zip(teams.toObservable(),detailsTeams.toObservable(),new BiFunction<Teams,DetailsTeams,Alldata>(){
//
//
//                @Override
//                public Alldata apply(Teams teams, DetailsTeams detailsTeams) {
//
//
//        return
//    }
//
//    @Override
//    public <V> BiFunction<Teams, DetailsTeams, V> andThen(Function<? super Alldata, ? extends V> after) {
//        return ;
//    }
//})


    //   }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void teamsResponce(String token, int id, View v) {
        disposable.add(footballLeagueRepository.Teams(token, id).flatMap(new Function<Teams, ObservableSource<TeamsItem>>() {
            @Override
            public ObservableSource<TeamsItem> apply(Teams teams) throws Exception {
                myTeams=teams;
                return Observable.fromIterable(teams.getTeams());
            }
        }).flatMap(new Function<TeamsItem, ObservableSource<DetailsTeams>>() {
            @Override
            public ObservableSource<DetailsTeams> apply(TeamsItem teamsItem) throws Exception {
                myTeamsItem=teamsItem;
                teamsItemList.add(myTeamsItem);
                return footballLeagueRepository.DetailsTeams(token, teamsItem.getId());
            }
        })  .subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DetailsTeams>() {


                    @Override
                    public void onNext(DetailsTeams detailsTeams) {
myTeamsItem.setDetailsTeams(detailsTeams);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(v, "Something wrong happen", Snackbar.LENGTH_LONG).show();
Log.i("error",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        myTeams.setTeams(teamsItemList);

                        teamsMutableLiveData.setValue(myTeams);

                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null)
            disposable.clear();
    }

}

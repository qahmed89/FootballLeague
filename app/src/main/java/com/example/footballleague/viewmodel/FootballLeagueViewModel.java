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
import com.example.footballleague.model.teams.Teams;
import com.example.footballleague.model.teams.TeamsItem;
import com.example.footballleague.repository.FootballLeagueRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class FootballLeagueViewModel extends ViewModel {

    Context context;
    private FootballLeagueRepository footballLeagueRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<Teams> teamsMutableLiveData = new MutableLiveData<>();


    private Teams myTeams = new Teams();

    @Inject
    public FootballLeagueViewModel(FootballLeagueRepository footballLeagueRepository) {
        this.footballLeagueRepository = footballLeagueRepository;
    }

    public LiveData<Teams> getTeamsResponce(String token, int id) {
        if (teamsMutableLiveData.getValue() == null) {
            teamsResponce(token, id);
            return teamsMutableLiveData;
        } else {
            return teamsMutableLiveData;
        }
    }

    public LiveData<String> errorMessage() {
        return errorMessage;
    }


    private void teamsResponce(String token, int id) {


        disposable.add(footballLeagueRepository.Teams(token, id).flatMap((Function<Teams, ObservableSource<TeamsItem>>) teams -> {
            myTeams = teams;
            return Observable.fromIterable(teams.getTeams());
        }).concatMap((Function<TeamsItem, ObservableSource<DetailsTeams>>) teamsItem -> {

            return footballLeagueRepository.DetailsTeams(token, teamsItem.getId());
        }).toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DetailsTeams>>() {

                    @Override
                    public void onSuccess(List<DetailsTeams> detailsTeams) {
                        myTeams.setDetailsTeams(detailsTeams);
                        teamsMutableLiveData.setValue(myTeams);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("FootballViewModel", "onError: " + e);
                        Log.d("FootballViewModel", "onError: " + e.getMessage());
                        Log.d("FootballViewModel", "onError: " + e.getLocalizedMessage());
                        Log.d("FootballViewModel", "onError: " + e.getCause());

                        if (e.getMessage().equals("Unable to resolve host \"api.football-data.org\": No address associated with hostname")) {
                            errorMessage.setValue("you have Poor Internet");
                        }
                        if (e.getMessage().equals("HTTP 429 ")) {
                            errorMessage.setValue("please try Again after 10 second");

                        } else {
                            errorMessage.setValue("Check Internet Connection");

                        }
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

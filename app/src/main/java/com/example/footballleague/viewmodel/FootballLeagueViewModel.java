package com.example.footballleague.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.footballleague.model.detailsteam.DetailsTeams;
import com.example.footballleague.model.sss.Alldata;
import com.example.footballleague.model.teams.Teams;
import com.example.footballleague.repository.FootballLeagueRepository;
import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
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

    @Inject
    public FootballLeagueViewModel(FootballLeagueRepository footballLeagueRepository) {
        this.footballLeagueRepository = footballLeagueRepository;
    }

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
                .subscribeWith(new DisposableSubscriber<DetailsTeams>() {


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

    private void teamsResponce(String token, int id, View v) {
        disposable.add(footballLeagueRepository.Teams(token, id)
                .subscribeOn(Schedulers.io())
                .timeout(1, TimeUnit.MINUTES)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Teams>() {

                    @Override
                    public void onNext(Teams teams) {
                        teamsMutableLiveData.setValue(teams);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Snackbar.make(v, "Something wrong happen", Snackbar.LENGTH_LONG).show();

                        //      Log.e("error", e.getCause().toString());


                    }

                    @Override
                    public void onComplete() {

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

package com.example.footballleague.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.footballleague.di.ViewModelKey;
import com.example.footballleague.viewmodel.FootballLeagueViewModel;
import com.example.footballleague.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FootballLeagueViewModel.class)


    abstract ViewModel bindViewModel(FootballLeagueViewModel footballLeagueViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
}

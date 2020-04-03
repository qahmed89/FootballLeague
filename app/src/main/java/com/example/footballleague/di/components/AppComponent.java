package com.example.footballleague.di.components;


import com.example.footballleague.di.modules.ContextModel;
import com.example.footballleague.di.modules.NetworkModel;
import com.example.footballleague.view.DetailsFragment;
import com.example.footballleague.view.MainActivity;
import com.example.footballleague.view.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModel.class, ContextModel.class})
public interface AppComponent {


    void inject(MainActivity mainActivity);
    void injectFragment(MainFragment mainFragment);
    void injectFragment(DetailsFragment detailsFragment);


}

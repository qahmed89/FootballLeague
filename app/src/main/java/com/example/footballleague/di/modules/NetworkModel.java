package com.example.footballleague.di.modules;



import com.example.footballleague.remote.FootballLeagueServices;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class NetworkModel {
    @Provides
    @Singleton
    static Retrofit provideRetrofit() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()

                .baseUrl("https://api.football-data.org/v2/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    @Provides
    @Singleton
    static FootballLeagueServices provideUserServices(Retrofit retrofit) {
        return retrofit.create(FootballLeagueServices.class);
    }
}

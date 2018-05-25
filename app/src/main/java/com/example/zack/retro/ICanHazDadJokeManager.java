package com.example.zack.retro;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ICanHazDadJokeManager {

    private String BASE_URL="https://icanhazdadjoke.com/";
    private ICanHazDadJokeSevice service;
    public ICanHazDadJokeManager(){
        Retrofit retrofit = new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient.Builder().build())
                            .baseUrl(BASE_URL)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();

        service = retrofit.create(ICanHazDadJokeSevice.class);
    }

    public static ICanHazDadJokeManager getInstance() {
        if(instance == null) instance = new ICanHazDadJokeManager();
        return instance;
    }

    public Observable<DadJoke> getJokes() throws Exception {
        if(service == null) throw new Exception("Service not initialized");

        return service.fetchJokes("");
    }

    private static ICanHazDadJokeManager instance;
}

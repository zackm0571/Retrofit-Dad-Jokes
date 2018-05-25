package com.example.zack.retro;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface ICanHazDadJokeSevice {
    @Headers("Accept: application/json")
    @GET
    Observable<DadJoke> fetchJokes(@Url String s);
}

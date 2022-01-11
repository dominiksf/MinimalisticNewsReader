package com.example.newsapp;

import android.graphics.Camera;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    //Top News Feed
    @GET("/feeds/topnews.rss")
    public Call<Feed> fetchTopNews();

    // Politik Feed
    @GET("/feeds/section/politik.rss")
    public Call<Feed> fetchPolitics();

    // Wirtschaft
    @GET("/feeds/section/wirtschaft.rss")
    public Call<Feed> fetchEconomics();

    // Geld
    @GET("/feeds/section/finanzen.rss")
    public Call<Feed> fetchMoney();

    // Digital
    @GET("/feeds/section/wirtschaft/webwelt.rss")
    public Call<Feed> fetchDigital();

    // Wissen
    @GET("https://www.welt.de/feeds/section/wissenschaft.rss")
    public Call<Feed> fetchScience();
}

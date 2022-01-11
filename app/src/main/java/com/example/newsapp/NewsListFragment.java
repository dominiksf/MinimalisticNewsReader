package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListFragment extends Fragment implements Callback<Feed> {

    public static NewsListFragment newInstance(NewsCategory.Name categoryName) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("categoryName", categoryName);
        NewsListFragment fragment = new NewsListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    RecyclerView recyclerView;
    NewsListAdapter newsListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initViews(view);
        fetchNewsList();
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchNewsList();
    }

    protected void initViews(View view) {
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        newsListAdapter = new NewsListAdapter();
        recyclerView.setAdapter(newsListAdapter);
    }

    protected void fetchNewsList() {
        Call<Feed> call = getNewsCall();
        call.enqueue(this);
    }

    protected Call<Feed> getNewsCall() {
        MainActivity mainActivity = (MainActivity) getActivity();
        NewsService newsService = mainActivity.getNewsService();
        Bundle bundle = getArguments();
        NewsCategory.Name categoryName = (NewsCategory.Name) bundle.getSerializable("categoryName");
        switch (categoryName) {
            case TOP_NEWS: return newsService.fetchTopNews();
            case POLITIK: return newsService.fetchPolitics();
            case WIRTSCHAFT: return newsService.fetchEconomics();
            case GELD: return newsService.fetchMoney();
            case DIGITALES: return newsService.fetchDigital();
            default: return newsService.fetchScience();
        }
    }

    // Request erfolgreich
    @Override
    public void onResponse(Call<Feed> call, Response<Feed> response) {
        if (response.isSuccessful()) {
            Feed feed = response.body();
            onFeedRecieved(feed);

        } else {
            Log.e("NewsListFragment", "onResponse was not successful");
            onError();
        }
    }

    // Request fehlgeschlagen
    @Override
    public void onFailure(Call<Feed> call, Throwable throwable) {
        Log.e("NewsListFragment", throwable.getMessage());
        onError();
    }

    protected void onFeedRecieved(Feed feed) {
        Log.d("NewsListFragment", "Feed recieved: " + feed.toString());
        newsListAdapter.setFeed(feed);
    }

    protected void onError() {
        Log.e("NewsListFragment", "Feed request error");
    }
}

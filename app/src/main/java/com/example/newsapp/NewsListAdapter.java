package com.example.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import retrofit2.http.GET;

import static android.widget.Toast.LENGTH_SHORT;

public class NewsListAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    Feed feed;

    // connect ViewHolder with layout
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_cell, parent, false));
    }

    // fill ViewHolder with data
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem newsItem = feed.channel.newsList.get(position);
        holder.titleTextView.setText(newsItem.title);
        holder.teaserTextView.setText(newsItem.description);
        Picasso.get().load(newsItem.image.url).into(holder.imageView);
        holder.itemView.setOnClickListener(view -> onNewsClick(view, newsItem));

    }

    protected void onNewsClick(View view, NewsItem newsItem) {
        Uri uri = Uri.parse(newsItem.link);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        view.getContext().startActivity(intent);
    }

    // get number of news items for setting recycler view size
    @Override
    public int getItemCount() {
        return feed != null ? feed.channel.newsList.size() : 0;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
        notifyDataSetChanged();
    }




}

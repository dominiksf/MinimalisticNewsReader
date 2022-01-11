package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabAdapter extends FragmentStateAdapter {


    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        NewsCategory.Name categoryName = NewsCategory.Name.values()[position];
        Fragment fragment = NewsListFragment.newInstance(categoryName);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NewsCategory.Name.values().length;
    }
}

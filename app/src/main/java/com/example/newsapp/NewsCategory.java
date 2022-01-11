package com.example.newsapp;

public class NewsCategory {

    public enum Name {
        TOP_NEWS, POLITIK, WIRTSCHAFT, GELD, DIGITALES, WISSENSCHAFT;


        public String getName() {

            return this == TOP_NEWS ? "TOP NEWS" : this.name();
        }

    }


}

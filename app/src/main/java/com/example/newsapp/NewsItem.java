package com.example.newsapp;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class NewsItem {

    @Element String title;
    @Element String link;
    @Element String description;
    @Element String category;
    @Element(name = "pubDate") String publishTime;
    @Element(required = false) String author;
    @Element(name = "enclosure") Image image;


}

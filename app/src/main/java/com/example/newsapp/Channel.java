package com.example.newsapp;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Channel {

    @Element
    String title;
    @Element
    String description;

    @ElementList(inline = true)
    List<NewsItem> newsList;




}

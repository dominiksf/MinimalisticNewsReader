package com.example.newsapp;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// strict = nur notwendige Elemente einlesen, die ausgewählt werden
@Root(name = "rss", strict = false)
public class Feed {

    @Element
    Channel channel;
}
